package com.renovite.transactionidmapper.utils;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.CertificatePinner;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;

import android.util.Log;


public class UnsafeOkHttpClient {
    //Hardcoded for now. Move this to constants
    private static final long TIMEOUT = 30000;
    private static final String hostname = "apigateway.poc.wrsops.net";
    private static final String SHA1_PIN = "sha1/r/mIkG3eEpVdm+u/ko/cwxzOMo1bk4TyHIlByibiA5E=";
    private static final String SHA256_PIN = "sha256/5kJvNEMw0KjrCAu7eXY5HZdvyCS13BbA0VJG1RSP91w=";

    public static OkHttpClient getHttpClient() {
        CertificatePinner certificatePinner = new CertificatePinner.Builder()
                .add(hostname, SHA256_PIN)
                .add(hostname, SHA1_PIN)
                .build();
        //VJ: This specs are needed when we want to control okhttp3. Not necessarly needed
        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_2)
                .supportsTlsExtensions(true)
                .cipherSuites(
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256

                )
                .build();
        OkHttpClient okHttpClient = null;
        try {
            RenoTLSSocketFactory renoTLSSocketFactory = new RenoTLSSocketFactory();
            Log.d("CIPHERS-DEFAULT", String.valueOf(Arrays.asList(renoTLSSocketFactory.getDefaultCipherSuites())));
            Log.d("CIPHERS-SUPPORTED", String.valueOf(Arrays.asList(renoTLSSocketFactory.getSupportedCipherSuites())));
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                    .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                    .writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                    //.connectionSpecs(Collections.singletonList(spec)) // Only needed in some cases
                    .certificatePinner(certificatePinner)
                    .hostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname, SSLSession session) {
                            return true;
                        }
                    })
                    .sslSocketFactory(renoTLSSocketFactory, new SelfSignedTrustManager())
                    .build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return okHttpClient;
    }
}
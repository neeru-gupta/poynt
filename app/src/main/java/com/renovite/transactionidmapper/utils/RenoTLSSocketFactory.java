package com.renovite.transactionidmapper.utils;

import android.util.Log;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class RenoTLSSocketFactory extends SSLSocketFactory {
    private SSLSocketFactory delegate;

    public RenoTLSSocketFactory() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, null, null);
        delegate = context.getSocketFactory();
    }

    @Override
    public String[] getDefaultCipherSuites() {
        return delegate.getDefaultCipherSuites();
    }

    @Override
    public String[] getSupportedCipherSuites() {
        return delegate.getSupportedCipherSuites();
    }

    @Override
    public Socket createSocket() throws IOException {
        return enableTLSOnSocket(delegate.createSocket());
    }

    @Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        return enableTLSOnSocket(delegate.createSocket(s, host, port, autoClose));
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        return enableTLSOnSocket(delegate.createSocket(host, port));
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        return enableTLSOnSocket(delegate.createSocket(host, port, localHost, localPort));
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        return enableTLSOnSocket(delegate.createSocket(host, port));
    }

    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        return enableTLSOnSocket(delegate.createSocket(address, port, localAddress, localPort));
    }

    private Socket enableTLSOnSocket(Socket socket) {
        if(socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket)socket).setEnabledProtocols(new String[] {"TLSv1.2"});
            //Uncomment only when we want to limit the Ciphers that are available, otherwise all the 29 list will be negotiated
            //((SSLSocket)socket).setEnabledCipherSuites(getCipherList(socket));
            //Uncomment only when we want to limit the Ciphers that are available, otherwise all the 29 list will be negotiated
            //adjustSocket(socket);
            Log.d("Enabled-Ciphers", Arrays.asList(((SSLSocket)socket).getEnabledCipherSuites()).toString());
        }
        return socket;
    }
    private void adjustSocket(Socket socket)
    {
        String[] cipherSuites = ((SSLSocket) socket).getSSLParameters().getCipherSuites();
        ArrayList<String> cipherSuiteList = new ArrayList<String>(Arrays.asList(cipherSuites));

        cipherSuiteList.add("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        cipherSuites = cipherSuiteList.toArray(new String[cipherSuiteList.size()]);
        ((SSLSocket) socket).getSSLParameters().setCipherSuites(cipherSuites);

        String[] protocols = ((SSLSocket) socket).getSSLParameters().getProtocols();
        ArrayList<String> protocolList = new ArrayList<String>(Arrays.asList(protocols));

        for (int ii = protocolList.size() - 1; ii >= 0; --ii )
        {
            if ((protocolList.get(ii).contains("SSLv3")) || (protocolList.get(ii).contains("TLSv1.1")) || (protocolList.get(ii).contains("TLSv1.2")))
                protocolList.remove(ii);
        }

        protocols = protocolList.toArray(new String[protocolList.size()]);
        ((SSLSocket)socket).setEnabledProtocols(protocols);
    }
    private String[] getCipherList(Socket socket)
    {
        String[] preferredCiphers = {
                //Check with the supported CIPHERS
                "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA",
                "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA",
                "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
                "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA"
        };

        String[] availableCiphers = null;

        try
        {
            availableCiphers = ((SSLSocket)socket).getSupportedCipherSuites();
            Arrays.sort(availableCiphers);
        }
        catch(Exception e)
        {
            Log.d("EXCEPTION:", e.getLocalizedMessage());
            return new String[] {
                    "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
                    "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"
            };
        }

        List<String> aa = new ArrayList<String>();
        for(int i = 0; i < preferredCiphers.length; i++)
        {
            int idx = Arrays.binarySearch(availableCiphers, preferredCiphers[i]);
            if(idx >= 0)
                aa.add(preferredCiphers[i]);
        }
        aa.add("TLS_ECDHE-RSA-AES256-GCM-SHA");
        aa.add("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");

        return aa.toArray(new String[0]);
    }


}
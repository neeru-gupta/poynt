# poyntdemo


  Poyntdemo is application that runs on POS ( Poynt Device based on Android OS minimum version 4.4 ) that retrieve transaction and order details and send a Receipt to customer by using polaris end point(/orders).
  For Poynt Development Details : http://poynt.github.io/developer/overview/overview.html
  
  
# Build Project 


1) Install Android Studio with SDK form here : https://developer.android.com/studio/index.html3
2) Clone the repo and save it local directory
3) Open Android Studio
4) Click on File Menu then New -> Import Project.
5) Select given project PoyntDemo from your local directory and press OK.
6) The project will download gradle and necessary files to compile  project .
7) Once project successfully import, click on build menu  -> build apk.
8) After building successful apk at the bottom of screen its shows  (APK Explorer Window) 
9) Open APK Explorer that having apk file.
10. OOB, generated apk(`app-debug.apk`) get generates inside project folder at following path: poyntdemo/app/build/outputs/apk


# Run APK By Command 

(Connect to Poynt Device to computer or laptop by USB and allow USB debugging on device screen)

  a) get SDK path File->Project Structure-> SDK Location  
  b) click terminal window at bottom of screen in android studio.
  c) go to generated apk path (e.g:  `cd /poyntdemo/app/build/outputs/apk` )
  d) execute following command : `adb install app/build/outputs/apk/app-debug.apk`
  		e.g  

  		`$ adb install app/build/outputs/apk/app-debug.apk

		app/build/outputs/apk/app-debug.apk: 1 file pushed. 6.9 MB/s (3873910 bytes in 0.536s)
        		pkg: /data/local/tmp/app-debug.apk
		Success
		$ `


 e) If apk is already install first unstall it using following command from terminal: `adb uninstall com.renovite.transactionidmapper`
			e.g:

		`$ adb uninstall com.renovite.transactionidmapper
		Success
		$ `






# Run APK By Directly from Android studio menu option:

    a) Run->Run APP 





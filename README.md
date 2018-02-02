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
7) When project successful import .Click on build menu  -> build apk.
8) After building successful apk at the bottom of screen its shows  (APK Explorer Window) 
9) Open APK Explorer that having apk file.

# Run APK By Command 

(Connect to Poynt Device to computer or laptop by USB and allow USB debugging on device screen)

  a) get SDK path File->Project Structure-> SDK Location  
  b) click terminal window at bottom of screen in android studio.
  c) go to platform-tools path of SDK (e.g:  `cd C:\Users\AppData\Local\Android\Sdk\platform-tools\` )
  d) execute following command : `adb install path_of_apk`
  		e.g  `adb install c:\myfolder\poyntdemo.apk`


# Run APK By Directly from Android studio menu option:

    a) Run->Run APP 





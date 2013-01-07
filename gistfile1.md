From terminal

    # logcat

shows the android log.

    Failed to set PTK to the driver
    # modprobe ieee80211_crypt_tkip

 - http://androidcookbook.com/ViewTOC.seam

Package bla.bla.bla has corrupt installation 
 - http://osdir.com/ml/android-ndk/2010-08/msg00263.html
 - http://www.pawfal.org/dave/blog/category/complaint/

 > $ adb shell cat /data/system/packages.list

SDCARD
------

It's the less speedy type of storage of the device.

The ``vold`` demon mounts the sdcard and it's configurated using the ``/etc/vold.fstab`` (older version uses ``vold.conf``)

JAVA
----

 - http://leepoint.net/notes-java/index.ht
 - http://stackoverflow.com/questions/4082799/android-how-to-store-cookies/4083144#4083144ml

BROWSER
-------

 - [Change the User Agent](http://www.abidibo.net/blog/2011/09/26/change-user-agent-android-default-browser/)

Lifecycle
---------

 - [Three law of android](http://www.youtube.com/watch?v=631T7B8HOv4)

THREAD
------

**Don't violate the single thread for the UI** [Painless threading](http://developer.android.com/resources/articles/painless-threading.html)
 - http://mindtherobot.com/blog/159/android-guts-intro-to-loopers-and-handlers/
 - http://codinghard.wordpress.com/2009/05/16/android-thread-messaging/
 - 

ANR
---

In case you are presented with a ANR dialog you can see in the logcat the following message

    I/dalvikvm(  292): Wrote stack traces to '/data/anr/traces.txt'

Pull the file via adb and look at the stack trace.

If you use a spinning wheel as loading indication, keep attention that is actuallty animated, otherwise you are in the UI thread and you are not doing right the threading stuffs.

RESOURCES
---------

 - [Asset studio](http://android-ui-utils.googlecode.com/hg/asset-studio/dist/index.html)
 - https://code.google.com/p/android-ui-utils/
 - http://code.google.com/p/apps-for-android/
 - http://wiresareobsolete.com/2010/06/9-patches/

GAPPS
-----

 - http://goo.im/gapps/

STYLE
-----
 - [Defining custom attributes](http://stackoverflow.com/questions/3441396/defining-custom-attrs)

PORTING
-------

 - http://gstreamer.freedesktop.org/wiki/GstreamerAndroid_InstallInstructions
 - http://mobilepearls.com/labs/native-android-api/
 - http://stackoverflow.com/questions/11312576/how-would-i-make-an-embedded-android-os-with-just-one-app
 - http://blog.linuxconsulting.ro/2010/04/porting-wifi-drivers-to-android.html
 - http://www.ankara-gtug.org/2012/01/29/step-by-step-guide-to-building-a-custom-android-device/

DEBUGGING
---------

 - http://omappedia.org/wiki/Android_Debugging
 - http://www.openintents.org/en/node/23
 - http://www.curious-creature.org/2012/12/01/android-performance-case-study/
 - http://www.curious-creature.org/2012/12/06/android-performance-in-practice/

LOW LEVEL
---------

 - http://marakana.com/s/remixing_android,1044/index.html
 - http://www.kandroid.org/online-pdk/guide/build_cookbook.html
 - http://elinux.org/Android_Device
 - http://blog.linuxconsulting.ro/2010/04/porting-wifi-drivers-to-android.html
 - http://bootloader.wikidot.com/linux:boot:android
 - http://android-dls.com/wiki/index.php?title=HOWTO:_Unpack%2C_Edit%2C_and_Re-Pack_Boot_Images
 - system/core/init/readme.txt
 - http://rxwen.blogspot.it/2010/01/android-property-system.html
 - http://www.netmite.com/android/mydroid/1.6/development/ndk/docs/ANDROID-MK.TXT
 - http://www.slideshare.net/jserv/android-ipc-mechanism
 - http://stackoverflow.com/questions/2442713/view-the-tasks-activity-stack

Launch an app from command line

    $ adb shell am start -n org.ktln2.android.packt/.ActionBarActivity

BLOGROLL
--------

 - http://www.pushing-pixels.org/category/android
 - http://blog.stylingandroid.com/
 - http://android.cyrilmottier.com/
 - http://elinux.org/Android_Portal
 - http://www.androiddesignpatterns.com/
 - http://www.grokkingandroid.com
 - http://www.curious-creature.org

BUGS
----

 - http://corner.squareup.com/2012/08/getting-to-the-bottom.html
 - http://portabledroid.wordpress.com/2011/04/19/programmatic-and-layout-fragments/
 - http://stackoverflow.com/questions/7707032/illegalstateexception-when-replacing-a-fragment


    A fragment that is created as part of a layout has its onCreateView
    method called when it leaves the Fragment.INITIALIZING state.  If
    the fragment is created programmatically its onCreateView method isn’t
    called until it leaves the Fragment.CREATED state.  When
    Activity.onCreate is called, the fragment is still in the Fragment.CREATED
    state: it’s onCreateView method has not been called and it has no view.
    The moral appears to be: “Never mix layout and programmatic fragments”.


EMULATOR
--------

It's possible to use [buildroid](http://www.buildroid.org/) to have a VirtualBox image with Google Apps that is more speedy respect to the qemu one.

In order to simulate a call in the cellphone

    $ telnet localhost 5554 <<!
    > gsm call 12345678
    > !
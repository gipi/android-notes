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

THREAD
------

**Don't violate the single thread for the UI** [Painless threading](http://developer.android.com/resources/articles/painless-threading.html)

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

STYLE
-----
 - [Defining custom attributes](http://stackoverflow.com/questions/3441396/defining-custom-attrs)

PORTING
-------

 - http://gstreamer.freedesktop.org/wiki/GstreamerAndroid_InstallInstructions
 - http://mobilepearls.com/labs/native-android-api/

DEBUGGING
---------

 - http://omappedia.org/wiki/Android_Debugging
 - http://www.openintents.org/en/node/23

LOW LEVEL
---------

 - http://www.kandroid.org/online-pdk/guide/build_cookbook.html
 - http://blog.linuxconsulting.ro/2010/04/porting-wifi-drivers-to-android.html
 - http://bootloader.wikidot.com/linux:boot:android
 - http://android-dls.com/wiki/index.php?title=HOWTO:_Unpack%2C_Edit%2C_and_Re-Pack_Boot_Images


BLOGROLL
--------

 - http://www.pushing-pixels.org/category/android
 - http://blog.stylingandroid.com/
 - http://android.cyrilmottier.com/
 - http://elinux.org/Android_Portal

EMULATOR
--------

In order to simulate a call in the cellphone

    $ telnet localhost 5554 <<!
    > gsm call 12345678
    > !
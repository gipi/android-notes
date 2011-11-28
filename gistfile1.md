 - http://blog.linuxconsulting.ro/2010/04/porting-wifi-drivers-to-android.html

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

STYLE
-----
 - [Defining custom attributes](http://stackoverflow.com/questions/3441396/defining-custom-attrs)

PORTING
-------

 - http://gstreamer.freedesktop.org/wiki/GstreamerAndroid_InstallInstructions

BLOGROLL
--------

 - http://www.pushing-pixels.org/category/android
 - http://blog.stylingandroid.com/
 - http://blog.linuxconsulting.ro/2010/04/porting-wifi-drivers-to-android.html

From terminal

 # logcat

shows the android log.

Failed to set PTK to the driver
 # modprobe ieee80211_crypt_tkip

 - http://androidcookbook.com/ViewTOC.seam

THREAD
------

**Don't violate the single thread for the UI** [Painless threading](http://developer.android.com/resources/articles/painless-threading.html)

ANR
---

In case you are presented with a ANR dialog you can see in the logcat the following message

 > I/dalvikvm(  292): Wrote stack traces to '/data/anr/traces.txt'

Pull the file via adb and look at the stack trace.

If you use a spinning wheel as loading indication, keep attention that is actuallty animated, otherwise you are in the UI thread and you are not doing right the threading stuffs.
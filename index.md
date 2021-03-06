---
layout: default
title: Home
---

 - [Gradle syntax video](https://www.youtube.com/watch?v=fHhf1xG0pIA)
 - http://chris.banes.me/2014/07/04/palette-preview/
 - http://antonioleiva.com/recyclerview/
 - http://www.doubleencore.com/2013/05/layout-inflation-as-intended/
 - http://cyrilmottier.com/2011/11/23/listview-tips-tricks-4-add-several-clickable-areas/
 - http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
 - http://www.developerphil.com/parcelable-vs-serializable/
 - http://flavienlaurent.com/blog/2013/08/28/each-navigation-drawer-hides-a-viewdraghelper/
 - http://petrnohejl.github.io/Android-Cheatsheet-For-Graphic-Designers/
 - http://www.androidzeitgeist.com/2013/08/read-code-intentservice.html?
 - http://omgitsmgp.com/2013/09/09/a-conservative-guide-to-proguard-for-android/
 - http://developer.sonymobile.com/2010/05/31/android-tutorial-making-your-own-3d-list-part-2/ : example of 3d rendering of list items
 - http://developer.sonymobile.com/knowledge-base/tutorials/ui-graphics/use-the-blindsview-effect-from-the-xperia-lockscreen/
 - http://onyxmueller.net/2013/09/28/using-drawables-in-textviews/
 - http://stackoverflow.com/questions/9162481/styling-indeterminate-progressbar-on-actionbar/9162700#9162700
 - https://github.com/thecodepath/android_guides
 - http://www.doubleencore.com/2013/10/shifty-baseline-alignment/
 - http://eclipsesource.com/blogs/2013/09/19/crossing-boundaries-with-the-new-android-viewoverlay/
 - http://idunnolol.com/android/drawables.html
 - [Android master key exploit](https://github.com/robertmillan/mkbreak)
 - http://www.curious-creature.org/2013/12/21/android-recipe-4-path-tracing/
 - http://www.doubleencore.com/2013/06/context/
 - http://androidtuts.net/how-to-make-a-chathead-like-facebook-messenger/
 - [Never call focus-changing methods like requestFocus() from inside a onFocusChanged() call](http://stackoverflow.com/questions/3003062/focus-issue-with-multiple-edittexts/22862803#22862803)
 - Activity and Fragment [lifecycle](https://plus.google.com/+StevePomeroy/posts/HsthxN21Yp1)
 - http://lucasr.org/2014/05/12/custom-layouts-on-android/
 - [Video](http://parleys.com/play/52adb157e4b04354fb7e7abb/chapter0/about) about Awesome Android Design
 - http://nerds.weddingpartyapp.com/tech/2014/06/20/primer-threading-handlers-android/
 - http://slides.com/dmytrodanylyk/missing-material-components
 - http://www.grokkingandroid.com/first-glance-androids-recyclerview/
 - http://saulmm.github.io/2015/02/02/A%20useful%20stack%20on%20android%20%231,%20architecture/
 - http://saulmm.github.io/a-useful-stack-on-android-2-user-interface/
 - http://saulmm.github.io/a-useful-stack-on-android-3-compatibility/

## Flavors

 - http://blog.brainattica.com/how-to-work-with-flavours-on-android/

## Thread

 - http://www.androiddesignpatterns.com/2013/04/activitys-threads-memory-leaks.html

TRANSITION
----------

 - http://lucasr.org/2014/03/13/how-android-transitions-work/

**Why my list item doesn't remain selected**

    Imagine a simple application, ApiDemos for example, that shows a list of text items. The user can freely navigate
    through the list using the trackball but also, alternatively, scroll and fling the list using the touch screen. The
    issue in this scenario is how to handle the selection properly when the user manipulates the list through the touch
    screen.

    In this case, if the user selects an item at the top of the list and then flings the list towards the bottom, what
    should happen to the selection? Should it remain on the item and scroll off the screen? What should happen if the user
    then decided to move the selection with the trackball? Or worse, what should happen if the user presses the trackball to
    act upon the currently selected item, which is not shown on screen anymore?

    After careful consideration, we decided to remove the selection altogether, when the user manipulates the UI through the
    touch screen.

    In touch mode, there is no focus and no selection. Any selected item in a list of in a grid becomes unselected as soon
    as the user enters touch mode. Similarly, any focused widgets become unfocused when the user enters touch mode. The
    image below illustrates what happens when the user touches a list after selecting an item with the trackball.


Remember that a list item can be selected or choosen

UTILITY
-------

 - [android dpi calculator](http://coh.io/adpi/)

MISCELLANEOUS
-------------

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
 - http://corner.squareup.com/2013/10/android-main-thread-1.html
 - http://corner.squareup.com/2013/12/android-main-thread-2.html

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
 - http://www.jayway.com/2013/01/22/custom-typeface-in-android/

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

    adb -d shell monkey -p packagename -v 10000

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
 - http://stackoverflow.com/questions/11728844/classcastexception-in-android-after-changing-drawable-name
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

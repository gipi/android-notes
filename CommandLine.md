---
layout: default
title: command line
---
Obtain info about an APK

    $ aapt dump badging <application.apk>
 
Obtain the certificate of the given apk

    $ unzip -l <application.apk> | awk '/RSA/{print $4}'
    $ unzip -p <application.apk> /META-INF/X.RSA | keytool -printcert 

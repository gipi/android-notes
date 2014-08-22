for a new device

```
# ~/.android/adb_usb.ini
0x2207

# /etc/udev/rules.d/70-android.rules
SUBSYSTEM=="usb", ATTR{idVendor}=="2207", MODE="0666", GROUP="plugdev"
```

If for some reason you need to use the ``TCP``

    $ adb tcpip 5555
    restarting in TCP mode port: 5555
    $ adb connect 192.168.1.6
    connected to 192.168.1.6:5555

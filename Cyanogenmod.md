---
layout: default
title: Cyanogenmod
---
Cyanogenmod allows to build for your device an Android distribution; in most cases however the official
repository doesn't contain your device so you must download from another repository with its manifest.

If you don't want to re-download all the things but using the previous donwloaded code, you can use
a separate manifest from that repository saving it in a temporary location and using it with ``repo sync``
and its ``-m`` option (using a absolute path to it).

For example in the following commands we use the repository for the motorola

    $ wget https://raw.github.com/kfazz/android/jellybean/default.xml -O .repo/motorola_sholes.xml
    $ repo sync -m .repo/motorola_sholes.xml -j 6

Links
-----

 - http://linux-sunxi.org/Starting_a_CyanogenMod_device_tree

HUAWEI8800pro
-------------

Holding **Volume up** and **Volume down** while **power** on the phone, a pink screen will appear; if you connect the cellphone to your computer with the mini usb cable you can access the partitions like an usb key.

Holding **Volume up** and **power** instead you can access the recovery.

If you want to compile cyanogenmod, this is the ``local_manifest.xml`` used by me

```

<?xml version="1.0" encoding="UTF-8"?>
<manifest>
  <project name="Blefish/android_device_huawei_u8800/" path="device/huawei/u8800" remote="github" revision="cm-10.1" />
  <project name="Blefish/android_vendor_huawei_u8800/" path="vendor/huawei/u8800" remote="github" revision="cm-10.1" />
  <project name="Blefish/android_kernel_huawei_u8800/" path="kernel/huawei/u8800" remote="github" revision="U8800_M7630AABBQMLZA40901040" />
  <!--remove-project name="CyanogenMod/android_hardware_qcom_display"/-->
  <project name="Blefish/android_hardware_qcom_display-msm7x30" path="hardware/qcom/display-msm7x30" remote="github" revision="cm-10.1" />
</manifest>
```

And this is the modification done in order to made compilable

```
project device/huawei/u8800/
diff --git a/BoardConfig.mk b/BoardConfig.mk
index 758a74e..bc866f6 100644
--- a/BoardConfig.mk
+++ b/BoardConfig.mk
@@ -137,7 +137,7 @@ BOARD_FLASH_BLOCK_SIZE := 262144 # (BOARD_KERNEL_PAGESIZE * 64)
 BOARD_CUSTOM_GRAPHICS := ../../../device/huawei/u8800/recovery/graphics.c
 BOARD_USE_CUSTOM_RECOVERY_FONT := \"roboto_10x18.h\"
 BOARD_HAS_NO_SELECT_BUTTON := true
-BOARD_TOUCH_RECOVERY := true
+#BOARD_TOUCH_RECOVERY := false
 
 # Custom releasetools for old partition table.
 TARGET_PROVIDES_RELEASETOOLS := true
diff --git a/libcamera/Android.mk b/libcamera/Android.mk
index a602447..642a363 100644
--- a/libcamera/Android.mk
+++ b/libcamera/Android.mk
@@ -31,7 +31,7 @@ LOCAL_C_INCLUDES += hardware/qcom/display/libgralloc \
                     hardware/qcom/display/libgenlock \
                     hardware/qcom/media/libstagefrighthw
 
-LOCAL_SHARED_LIBRARIES:= libutils libui libcamera_client liblog libcutils libmmjpeg
+LOCAL_SHARED_LIBRARIES:= libutils libui libcamera_client liblog libcutils
 
 LOCAL_SHARED_LIBRARIES+= libgenlock libbinder
 LOCAL_SHARED_LIBRARIES+= libdl

diff --git a/proprietary-files.txt b/proprietary-files.txt
index dbabfed..369dc93 100644
--- a/proprietary-files.txt
+++ b/proprietary-files.txt
@@ -2,6 +2,7 @@ bin/qmuxd
 bin/cnd
 bin/rmt_storage
 bin/oem_rpc_svc
+lib/libmmjpeg.so
 lib/libxml.so
 lib/libcneutils.so
 lib/libcneqmiutils.so
```

before compile

```
$ cd vendor/cm
$ ./get-prebuilts
$ cd device/huawei/u8800
$ ./extract-files.sh
```

TROUBLESHOOTING
---------------

First of all, this is the [android-building](http://groups.google.com/group/android-building) group

    /bin/bash: prebuilts/gcc/linux-x86/arm/arm-linux-androideabi-4.6/bin/arm-linux-androideabi-gcc: cannot execute binary file

go to the prebuilt directory and checkout the revision with the toolchain for x86

    $ cd prebuilts/gcc/linux-x86/arm/arm-linux-androideabi-4.6/
    "(android-4.1.1_r6.1)" branch :) $ git tag
    android-4.1.1_r1
    android-4.1.1_r1.1
    android-4.1.1_r2
    android-4.1.1_r3
    android-4.1.1_r4
    android-4.1.1_r5
    android-4.1.1_r6
    android-4.1.1_r6.1
    android-4.1.2_r1
    android-cts-4.1_r1
    android-sdk-adt_r20
    "(android-4.1.1_r6.1)" branch :) $ git checkout android-sdk-adt_r20

or a shortcuts

```
$ (cd prebuilts/gcc/linux-x86/arm/arm-linux-androideabi-4.6/ && git checkout android-sdk-adt_r20)
```

INTERNALS
---------

Understanding the Cyanogenmod is not so easy: these are the simple stuffs that I put together

``vendorsetup.sh``

```
add_launch_combo  <whatever>_<device>-eng
```

This is fondamental in order to compile: ``cm.mk``, this recall the ``full_u8800pro.mk`` but you can call
as you want (before ics you MUST call in this way)
```
## Specify phone tech before including full_phone
$(call inherit-product, vendor/cm/config/gsm.mk)

# Release name
PRODUCT_RELEASE_NAME := U8800

# Boot animation
TARGET_BOOTANIMATION_NAME := vertical-480x800

# Inherit device configuration
$(call inherit-product, device/huawei/u8800/full_u8800.mk)

# Inherit some common CM stuff.
$(call inherit-product, vendor/cm/config/common_full_phone.mk)

## Device identifier. This must come after all inclusions
PRODUCT_DEVICE := u8800
PRODUCT_NAME := cm_u8800
PRODUCT_BRAND := Huawei
PRODUCT_MODEL := U8800
PRODUCT_MANUFACTURER := Huawei

#Set build fingerprint / ID / Product Name ect.
PRODUCT_BUILD_PROP_OVERRIDES += \
	PRODUCT_NAME=u8800 \
	BUILD_DISPLAY_ID="IMM76I" \
	BUILD_FINGERPRINT=huawei/u8800:4.0.4/IMM76I/223133:userdebug/test-keys \
	PRIVATE_BUILD_DESC="huawei-user 4.0.4 IMM76I 223133 test-keys" \
	BUILD_NUMBER=223133
```

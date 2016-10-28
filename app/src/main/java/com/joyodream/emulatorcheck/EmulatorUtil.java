package com.joyodream.emulatorcheck;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 *
 *
 * TelephonyManager
 – getLine1Number == 155 5521 <emu-port>
 – getDeviceId == 000000000000000
 – getDeviceId == 012345678912345
 – getSubscriberId == 310260000000000
 – getVoiceMailNumber == 15552175049
 – getSimSerialNumber == 89014103211118510720
 • Build
 – BRAND == generic
 – DEVICE == generic
 – HARDWARE == goldfish
 – PRODUCT== sdk
 – HOST == android-test
 – TAGS == test-keys
 – ......
 2014/9/21  12
 反模拟器行为特征(cont.)
 • 特征文件
 – /dev/socket/qemud
 – /dev/qemu_pipe
 – /system/lib/libc_malloc_debug_qemu.so
 – /sys/qemu_trace
 – /system/bin/qemu-props
 • 系统属性
 – ro.hardware == goldfish
 – ro.product.device == generic
 – ro.product.model == sdk
 – ro.product.name == sdk
 * Created by lipeilong on 2016/10/28.
 *
 *  还可以通过电量变化、声音、震动来检测
 *  联系人、相册、短信
 */

public class EmulatorUtil {
    public static final String TAG  = "EmulatorUtil";

    public static void log(String log){
        Log.d(TAG, log == null ? "null" : log);
    }

    public static boolean checkBuildDevice(){
        log(Build.DEVICE);
        if(Build.DEVICE == "generic"){
            return true;
        }
        return false;
    }

    public static boolean checkBuildBrand(){
        log(Build.BRAND);
        if(Build.BRAND == "generic"){
            return true;
        }
        return false;
    }

    public static boolean checkBuildModel(){
        log(Build.MODEL);
        if(Build.MODEL == "sdk"){
            return true;
        }
        return false;
    }

    public static boolean checkBuildProduct(){
        log(Build.PRODUCT);
        if(Build.PRODUCT == "sdk"){
            return true;
        }
        return false;
    }

    public static boolean checkBuildHardware(){
        log(Build.HARDWARE);
        if(Build.HARDWARE == "goldfish"){
            return true;
        }
        return false;
    }

    public static boolean checkBuildFingerPrint(){
        log(Build.FINGERPRINT);
        if(Build.FINGERPRINT == "sdk"){
            return true;
        }
        return false;
    }

    public static boolean checkTelephoneDeviceId(Activity activity){
        String id   = ((TelephonyManager)activity.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        log(id);
        if("000000000000000".equals(id) || "012345678912345".equals(id)){
            return true;
        }
        return false;
    }

    public static boolean checkTelephoneLineNumb(Activity activity){
        String id   = ((TelephonyManager)activity.getSystemService(Context.TELEPHONY_SERVICE)).getLine1Number();
        log(id);
        if("000000000000000".equals(id) || "012345678912345".equals(id)){
            return true;
        }
        return false;
    }
}

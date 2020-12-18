package com.lisn.voicechange;

/**
 * @author : lishan
 * @e-mail : cnlishan@163.com
 * @date : 2020/12/17 4:54 PM
 * @desc :
 */
public class VoiceUtils {

    public static final int MODE_PRIMARY = 0;
    public static final int MODE_LUOLI = 1;
    public static final int MODE_DASHU = 2;
    public static final int MODE_JINSONG = 3;
    public static final int TYPE_GAOGUAI = 4;
    public static final int TYPE_KONGLING = 5;



    static {
        try {
            System.loadLibrary("native-lib");
            System.loadLibrary("fmod");
            System.loadLibrary("fmodL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static native void luoli(String path,int type);
}

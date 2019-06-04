package com.jade.api.utils.helpers;

/**
 * FireBasePushIdGenerator
 */
public class FireBasePushIdGenerator {
    static final String PUSH_CHARS = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz";
    static long lastPushTime = 0;
    static int[] lastRandomChar = new int[12];
    static char[] id = new char[20];

    public static String getFirebaseId() {
        long now = System.currentTimeMillis();
        boolean duplicateTime = (now == lastPushTime);
        lastPushTime = now;

        if(!duplicateTime) {
            for (int i = 7; i >= 0; i--) {
                id[i] = PUSH_CHARS.charAt((int) (now % 64));
                now = (long) Math.floor(now / 64);
            }
        }

        if(!duplicateTime) {
            for (int i = 0; i < 12; i++) {
                lastRandomChar[i] = (int) Math.floor(Math.random() * 64);
                id[8 + i] = PUSH_CHARS.charAt(lastRandomChar[i]);
            }
        } else {
            int i = 11;
            for (; i >= 0 && lastRandomChar[i] == 63; i--) {
                lastRandomChar[i] = 0;
            }
            lastRandomChar[i]++;
        }
        for(int i = 0; i < 12; i++) {
            id[8 + i] = PUSH_CHARS.charAt(lastRandomChar[i]);
        }
        return String.valueOf(id);
    }
}

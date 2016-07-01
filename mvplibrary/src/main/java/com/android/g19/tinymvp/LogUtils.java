package com.android.g19.tinymvp;

import android.util.Log;

/**
 * Created by gagandeep on 30/6/16.
 */

public final class LogUtils {

    private LogUtils() {
    }

    public static void logd(String TAG, String message) {
        Log.d(TAG, message);
    }
}

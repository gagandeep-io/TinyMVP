package com.android.g19.tinymvp.sample.data;

/**
 * Created by gagandeep on 30/6/16.
 */

public interface NetworkInterface {

    interface NetworkResult {
        void onSuccess(String result);

        void onFailure(String message);
    }

    void process(int first, int second, int expectedResult,NetworkResult listener);

    void cancel();

    boolean isProcessing();
}

package com.android.g19.tinymvp.sample.data;

import android.os.Handler;

/**
 * Created by gagandeep on 30/6/16.
 */

public class FakePuzzleNetworkInterface implements NetworkInterface {

    private static final int TIME = 3000;
    private boolean inProgress;

    @Override
    public void process(final int first, final int second, final int expectedResult, final NetworkResult listener) {
        inProgress = true;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                inProgress = false;
                if (listener != null) {
                    int actualResult = first + second;
                    if (actualResult != expectedResult) {
                        listener.onFailure("Wrong Answer!!!");
                    } else {
                        listener.onSuccess("Good, Right Answer");
                    }
                }
            }
        }, TIME);
    }

    @Override
    public void cancel() {

    }

    @Override
    public boolean isProcessing() {
        return inProgress;
    }
}

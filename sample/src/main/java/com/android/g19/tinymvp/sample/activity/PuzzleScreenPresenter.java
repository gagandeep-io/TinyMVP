package com.android.g19.tinymvp.sample.activity;

import com.android.g19.tinymvp.sample.data.NetworkInterface;
import com.android.g19.tinymvp.sample.data.PuzzleGenerator;

/**
 * Created by gagandeep on 30/6/16.
 */

public class PuzzleScreenPresenter extends PuzzleMvp.Presenter implements NetworkInterface.NetworkResult {

    private NetworkInterface mNetworkInterface;
    private PuzzleGenerator mPuzzleGenerator;

    public PuzzleScreenPresenter(Class clazz,NetworkInterface networkInterface, PuzzleGenerator mPuzzleGenerator) {
        super(clazz);
        this.mNetworkInterface = networkInterface;
        this.mPuzzleGenerator = mPuzzleGenerator;
    }

    @Override
    public void attachView(PuzzleMvp.View view) {
        super.attachView(view);
        int[] result = new int[2];
        mPuzzleGenerator.generate(result);
        mView.initPuzzleScreenParams(result[0], result[1]);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    void onSubmitClicked(int firstParam, int secondParam, int expected) {
        if (!mNetworkInterface.isProcessing()) {
            mNetworkInterface.process(firstParam, secondParam, expected, this);
            mView.hideMessageView();
            mView.showLoading();
        }
    }

    @Override
    public void onSuccess(String result) {
        mView.showSuccessMessage(result);
        mView.showMessageView();
        mView.hideLoading();
    }

    @Override
    public void onFailure(String message) {
        mView.showFailureMessage(message);
        mView.showMessageView();
        mView.hideLoading();
    }

}

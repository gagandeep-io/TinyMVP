package com.android.g19.tinymvp.sample.activity;

import com.android.g19.tinymvp.TinyMVPPresenter;
import com.android.g19.tinymvp.TinyMVPView;

/**
 * Created by gagandeep on 30/6/16.
 */

public interface PuzzleMvp {

    interface View extends TinyMVPView {
        void initPuzzleScreenParams(int first, int expectedResult);

        void showSuccessMessage(String successMessage);

        void showFailureMessage(String message);

        void hideMessageView();

        void showMessageView();

        void showLoading();

        void hideLoading();
    }

    abstract class Presenter extends TinyMVPPresenter<View> {

        public Presenter(Class<View> clazz) {
            super(clazz);
        }

        abstract void onSubmitClicked(int firstParam, int secondParam, int expected);

    }

}

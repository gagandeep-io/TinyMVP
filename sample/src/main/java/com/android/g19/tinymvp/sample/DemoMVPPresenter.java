package com.android.g19.tinymvp.sample;

import com.android.g19.tinymvp.TinyMVPPresenter;

/**
 * Created by gagandeep on 28/6/16.
 */

public class DemoMVPPresenter extends TinyMVPPresenter<MVPDemoView> {

    public DemoMVPPresenter() {
        super(null);
    }

    @Override
    public void attachView(MVPDemoView view) {
        super.attachView(view);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void detachView() {
        super.detachView();
    }
}

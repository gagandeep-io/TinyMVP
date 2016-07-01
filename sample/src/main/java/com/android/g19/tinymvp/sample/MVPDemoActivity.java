package com.android.g19.tinymvp.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.g19.tinymvp.views.TinyMVPBaseActivity;

/**
 * Created by gagandeep on 28/6/16.
 */

public class MVPDemoActivity extends TinyMVPBaseActivity<MVPDemoView,DemoMVPPresenter> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected DemoMVPPresenter createPresenter() {
        return new DemoMVPPresenter();
    }


    @Override
    protected void onPresenterLoaded(DemoMVPPresenter presenter) {

    }
}

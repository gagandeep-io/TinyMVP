package com.android.g19.tinymvp.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

import com.android.g19.tinymvp.TinyMVPPresenter;
import com.android.g19.tinymvp.TinyMVPPresenterLoader;
import com.android.g19.tinymvp.TinyMVPView;

/**
 * Created by gagandeep on 28/6/16.
 */

public abstract class TinyMVPBaseActivity<VIEW extends TinyMVPView, PRESENTER extends TinyMVPPresenter<VIEW>> extends AppCompatActivity implements LoaderManager.LoaderCallbacks<PRESENTER> {

    private final int ID_PRESENTER_LOADER = Integer.MAX_VALUE;
    private PRESENTER mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportLoaderManager().initLoader(ID_PRESENTER_LOADER, null, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().attachView( (VIEW) this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        getPresenter().detachView();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public Loader<PRESENTER> onCreateLoader(int id, Bundle args) {
        return new TinyMVPPresenterLoader<>(getApplicationContext(), createPresenter());
    }

    @Override
    public void onLoadFinished(Loader<PRESENTER> loader, PRESENTER presenter) {
        onPresenterLoaded(presenter);
    }

    @Override
    public void onLoaderReset(Loader<PRESENTER> loader) {

    }

    protected abstract PRESENTER createPresenter();

    protected void onPresenterLoaded(PRESENTER presenter) {
        mPresenter = presenter;
        mPresenter.onCreate();
    }

    protected PRESENTER getPresenter() {
        return mPresenter;
    }


}

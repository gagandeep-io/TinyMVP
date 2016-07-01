package com.android.g19.tinymvp;

import android.content.Context;
import android.support.v4.content.Loader;


/**
 * Created by gagandeep on 29/3/16.
 */
public class TinyMVPPresenterLoader<PRESENTER extends TinyMVPPresenter> extends Loader<PRESENTER> {


    private PRESENTER mPresenter;
    public static final String TAG = TinyMVPPresenterLoader.class.getSimpleName();

    /**
     * Stores away the application context associated with context.
     * Since Loaders can be used across multiple activities it's dangerous to
     * store the context directly; always use {@link #getContext()} to retrieve
     * the Loader's Context, don't use the constructor argument directly.
     * The Context returned by {@link #getContext} is safe to use across
     * Activity instances.
     *
     * @param context used to retrieve the application context.
     */
    public TinyMVPPresenterLoader(Context context, PRESENTER presenter) {
        super(context);
        checkPresenterIfNull(presenter);
        this.mPresenter = presenter;
        LogUtils.logd(TAG,String.format("TinyMVPPresenterLoader(...) TinyMVPPresenterLoader = %d",this.hashCode()));
    }

    @Override
    protected void onStartLoading() {
        LogUtils.logd(TAG,String.format("onStartLoading(...) TinyMVPPresenterLoader = %d",this.hashCode()));
        deliverResult(mPresenter);
    }

    private void checkPresenterIfNull(PRESENTER presenter) {
        if (presenter == null) {
            throw new RuntimeException("Presenter passed to loader can not be null");
        }
    }
}

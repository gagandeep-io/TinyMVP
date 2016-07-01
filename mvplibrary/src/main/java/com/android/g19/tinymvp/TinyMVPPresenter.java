package com.android.g19.tinymvp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by gagandeep on 28/6/16.
 */

public abstract class TinyMVPPresenter<VIEW extends TinyMVPView> {

    private static final String TAG = TinyMVPPresenter.class.getSimpleName();

    protected VIEW mView;
    private TinyMVPViewInvocationHandler mInvocationHandler;

    public TinyMVPPresenter(Class<VIEW> clazz) {
        mInvocationHandler = new TinyMVPViewInvocationHandler();
        mView = (VIEW) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, mInvocationHandler);
    }

    public void attachView(VIEW view) {
        mInvocationHandler.setView(view);
        LogUtils.logd(TAG,String.format("attachView(...) Presenter = %d",this.hashCode()));
    }

    public abstract void onCreate();

    public abstract void onDestroy();

    public void detachView() {
        mInvocationHandler.setView(null);
        LogUtils.logd(TAG,String.format("detachView(...) Presenter = %d",this.hashCode()));
    }

    protected VIEW getView() {
        return mView;
    }

    private class TinyMVPViewInvocationHandler implements InvocationHandler {
        private VIEW view;

        public void setView(VIEW view) {
            this.view = view;
        }

        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
            if (view != null) {
                method.invoke(view, objects);
            }
            return null;
        }
    }

}

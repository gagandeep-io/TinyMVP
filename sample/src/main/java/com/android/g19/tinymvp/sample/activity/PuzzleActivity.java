package com.android.g19.tinymvp.sample.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.g19.tinymvp.sample.R;
import com.android.g19.tinymvp.sample.data.FakePuzzleNetworkInterface;
import com.android.g19.tinymvp.sample.data.PuzzleGenerator;
import com.android.g19.tinymvp.views.TinyMVPBaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gagandeep on 30/6/16.
 */

public class PuzzleActivity extends TinyMVPBaseActivity<PuzzleMvp.View, PuzzleMvp.Presenter> implements PuzzleMvp.View {

    @Bind(R.id.tv_first)
    TextView mFirstParamView;

    @Bind(R.id.tv_second)
    EditText mSecondParamView;

    @Bind(R.id.tv_expected_result)
    TextView mExpectedResultView;

    @Bind(R.id.tv_message)
    TextView mMessageView;

    @Bind(R.id.loading)
    View mLoadingView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_submit)
    public void onSubmit() {
        int first = Integer.parseInt(mFirstParamView.getText().toString());
        int second = Integer.parseInt(mSecondParamView.getText().toString());
        int expected = Integer.parseInt(mExpectedResultView.getText().toString());
        getPresenter().onSubmitClicked(first,second,expected);
    }

    @Override
    protected PuzzleMvp.Presenter createPresenter() {
        return new PuzzleScreenPresenter(PuzzleMvp.View.class,new FakePuzzleNetworkInterface(), new PuzzleGenerator());
    }


    @Override
    public void initPuzzleScreenParams(int first, int expectedResult) {
        mFirstParamView.setText(String.valueOf(first));
        mSecondParamView.setText(String.valueOf(0));
        mExpectedResultView.setText(String.valueOf(expectedResult));
    }

    @Override
    public void showSuccessMessage(String successMessage) {
        mMessageView.setText(successMessage);
        mMessageView.setTextColor(Color.GREEN);
    }

    @Override
    public void showFailureMessage(String message) {
        mMessageView.setText(message);
        mMessageView.setTextColor(Color.RED);
    }

    @Override
    public void hideMessageView() {
        mMessageView.setVisibility(View.GONE);
    }

    @Override
    public void showMessageView() {
        mMessageView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoadingView.setVisibility(View.GONE);
    }
}

package com.taurus.androidtest.splash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.taurus.androidtest.R;
import com.taurus.androidtest.core.BaseFragment;

public class SplashFragment extends BaseFragment<SplashView, SplashPresenter> implements SplashView {

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_splash;
    }

    @NonNull
    @Override
    public SplashPresenter createPresenter() {
        return new SplashPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getPresenter().onCategoryListRequested();

    }
}

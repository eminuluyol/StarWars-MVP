package com.taurus.androidtest.core;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.taurus.androidtest.R;
import com.taurus.androidtest.core.dialog.ProgressDialogFragment;
import com.taurus.androidtest.core.dialog.ProgressDialogFragmentBuilder;
import com.taurus.androidtest.core.injection.Injector;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends MvpActivity<V, P>
        implements BaseView {

    private static final String TAG_PROGRESS_DIALOG = "PROGRESS_DIALOG";

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Nullable
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @Nullable
    @BindView(R.id.root)
    View rootView;

    private boolean homeAsUpEnabled;

    private ProgressDialogFragment progressDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Injector.getInstance().createActivityScope(this);

        super.onCreate(savedInstanceState);

        setContentView(getLayoutResId());

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (savedInstanceState == null) {

            final BaseFragment fragment = getContainedFragment();

            if (fragment != null) {
                addFragment(fragment).commit();
            }
        }

        progressDialogFragment = new ProgressDialogFragmentBuilder().build();

    }

    /**
     * Start fragment transaction and add a fragment.
     * <p>
     * DO NOT FORGET to commit transaction after this method call.
     * It means, use this method like <code>addFragment(fragment).commit()</code>
     *
     * @param fragment fragment that inherits {@link BaseFragment}
     * @return fragment transaction instance to specify your transaction and commit on child activities
     */
    protected FragmentTransaction addFragment(BaseFragment fragment) {
        return addFragment(fragment, fragment.getDefaultFragmentTag());
    }

    /**
     * Start fragment transaction and add a fragment.
     * <p>
     * DO NOT FORGET to commit transaction after this method call.
     * It means, use this method like <code>addFragment(fragment, tag).commit()</code>
     *
     * @param fragment fragment that inherits {@link BaseFragment}
     * @param tag      fragment tag
     * @return fragment transaction instance to specify your transaction and commit on child activities
     */
    protected FragmentTransaction addFragment(BaseFragment fragment, String tag) {
        return getSupportFragmentManager().beginTransaction()
                .add(getContainerLayoutId(), fragment, tag);
    }

    /**
     * Start fragment transaction and replace a fragment.
     * <p>
     * DO NOT FORGET to commit transaction after this method call.
     * It means, use this method like <code>replaceFragment(fragment).commit()</code>
     *
     * @param fragment fragment that inherits {@link BaseFragment}
     * @return fragment transaction instance to specify your transaction and commit on child activities
     */
    protected FragmentTransaction replaceFragment(BaseFragment fragment) {
        return replaceFragment(fragment, fragment.getDefaultFragmentTag());
    }

    /**
     * Start fragment transaction and replace a fragment.
     * <p>
     * DO NOT FORGET to commit transaction after this method call.
     * It means, use this method like <code>replaceFragment(fragment, tag).commit()</code>
     *
     * @param fragment fragment that inherits {@link BaseFragment}
     * @param tag      fragment tag
     * @return fragment transaction instance to specify your transaction and commit on child activities
     */
    protected FragmentTransaction replaceFragment(BaseFragment fragment, String tag) {
        return getSupportFragmentManager().beginTransaction()
                .replace(getContainerLayoutId(), fragment, tag);
    }

    /**
     * Find fragment by tag.
     *
     * @param tag fragment tag
     * @return fragment instance
     */
    protected Fragment findFragment(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag);
    }

    /**
     * Get container layout id.
     * <p>
     * It will be used for adding fragment automatically. {@see BaseActivity#getContainedFragment()}.
     * Override this if you create different layout for child activity.
     *
     * @return container layout id
     */
    @IdRes
    protected int getContainerLayoutId() {
        return R.id.container;
    }

    /**
     * Get layout resource id of activity.
     * <p>
     * It is activity_base.xml by default. Override this to change layout.
     *
     * @return layout resource id
     */
    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_base;
    }

    /**
     * Get root view of activity layout.
     *
     * @return root view
     */
    public View getRootView() {
        return rootView;
    }

    /**
     * Specify contained fragment.
     *
     * @return contained fragment
     */
    @Nullable
    protected abstract BaseFragment getContainedFragment();

    /**
     * Set toolbar title
     *
     * @param title string will be used for setting the toolbar title
     */
    @Override
    public void setTitle(CharSequence title) {
        toolbarTitle.setText(title);
    }

    /**
     * Set toolbar title
     *
     * @param titleId string resource id will be used for setting the toolbar title
     */
    @Override
    public void setTitle(@StringRes int titleId) {
        toolbarTitle.setText(titleId);
    }

    /**
     * Set home as up enabled
     *
     * @param enabled if true home as up button will be visible on toolbar
     */
    protected void setHomeAsUpEnabled(boolean enabled) {
        homeAsUpEnabled = enabled;
        getSupportActionBar().setDisplayHomeAsUpEnabled(enabled);
    }

    @CallSuper
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            navigateUp();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (!getSupportFragmentManager().popBackStackImmediate()) {
            if (homeAsUpEnabled) {
                navigateUp();
            } else {
                finish();
            }
        }

    }

    private void navigateUp() {
        NavUtils.navigateUpFromSameTask(this);
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

    protected void setupStatusBar() {

        Window window = getWindow();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.transparent));
        }

    }

    @Override
    public void showError(String message) {

        if (TextUtils.isEmpty(message)) return;

        Snackbar snackbar = Snackbar.make(getRootView(), message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.red));
        snackbar.show();

    }

    @Override
    public void showProgress() {
        if (progressDialogFragment == null || progressDialogFragment.isVisible()) return;

        progressDialogFragment.show(getSupportFragmentManager(), TAG_PROGRESS_DIALOG);
    }

    @Override
    public void showProgress(String message) {
        if (progressDialogFragment == null || progressDialogFragment.isVisible()) return;

        progressDialogFragment.setMessage(message);
        progressDialogFragment.show(getSupportFragmentManager(), TAG_PROGRESS_DIALOG);
    }

    @Override
    public void setProgressMessage(String message) {
        progressDialogFragment.setMessage(message);
    }

    @Override
    public void dismissProgress() {
        if(progressDialogFragment == null) return;;
        progressDialogFragment.dismissAllowingStateLoss();
    }

}

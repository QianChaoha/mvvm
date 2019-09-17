package com.cqian.app.activity;

import android.text.TextUtils;
import android.view.View;

import com.cqian.app.R;
import com.cqian.app.databinding.ActivityLoginBinding;
import com.cqian.app.viewmodel.LoginViewModel;
import com.cqian.baselibrary.utils.ToastUtil;
import com.cqian.mvvm.base.BaseMvvmActivity;

/**
 * Description:
 * Date: 2019/9/10
 *
 * @author: cqian
 */
public class LoginActivity extends BaseMvvmActivity<LoginViewModel, ActivityLoginBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    public void login(View view) {
        if (TextUtils.isEmpty(mBindingView.etUserName.getText().toString())) {
            ToastUtil.showToast(getApplication(), "请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(mBindingView.etPassword.getText().toString())) {
            ToastUtil.showToast(getApplication(), "请输入密码");
            return;
        }
    }
}

package com.cqian.app.activity;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.cqian.app.R;
import com.cqian.app.bean.LoginBean;
import com.cqian.app.databinding.ActivityLoginBinding;
import com.cqian.app.viewmodel.LoginViewModel;
import com.cqian.baselibrary.utils.ToastUtils;
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
        String userName = mBindingView.etUserName.getText().toString();
        String password = mBindingView.etPassword.getText().toString();
        if (TextUtils.isEmpty(userName)) {
            ToastUtils.showToast(getApplication(), "请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            ToastUtils.showToast(getApplication(), "请输入密码");
            return;
        }
        mViewModel.login(userName, password).observe(this, new Observer<LoginBean>() {
            @Override
            public void onChanged(@Nullable LoginBean loginBean) {

            }
        });
    }
}

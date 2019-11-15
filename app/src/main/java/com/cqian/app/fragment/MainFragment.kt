package com.cqian.app.fragment

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import com.cqian.app.R
import com.cqian.app.databinding.FragmentMainBinding
import com.cqian.app.viewmodel.main.MainViewModel
import com.cqian.baselibrary.base.BaseFragment
import com.cqian.mvvm.base.BaseMvvmFragment

/**
 * Description:
 * Date: 2019/11/12
 * @author: cqian
 */
class MainFragment() : BaseMvvmFragment<MainViewModel, FragmentMainBinding>() {

    override fun initView(view: View?, savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

    override fun setContentId(): Int {
        return R.layout.fragment_main
    }

}
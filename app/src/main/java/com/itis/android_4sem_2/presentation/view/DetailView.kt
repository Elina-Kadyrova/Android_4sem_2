package com.itis.android_4sem_2.presentation.view

import com.itis.android_4sem_2.domain.entity.DetailModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

@AddToEndSingle
interface DetailView : MvpView {
    fun loadInfo(detailModel: DetailModel)
    fun showLoading()
    fun hideLoading()
    @Skip
    fun showError(throwable: Throwable)
}

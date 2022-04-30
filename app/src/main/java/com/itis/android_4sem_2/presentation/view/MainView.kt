package com.itis.android_4sem_2.presentation.view

import com.itis.android_4sem_2.domain.entity.ListModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution
import moxy.viewstate.strategy.alias.Skip

@AddToEndSingle
interface MainView : MvpView {
    fun showList(listModel: List<ListModel>)
    fun showLoading()
    fun hideLoading()
    @Skip
    fun showError(throwable: Throwable)
    @OneExecution
    fun openDetailsScreen(id:Int)
}

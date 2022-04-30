package com.itis.android_4sem_2.presentation.presenter

import com.itis.android_4sem_2.domain.usecase.GetRecipeByIdUseCase
import com.itis.android_4sem_2.presentation.view.DetailView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import moxy.MvpPresenter
import javax.inject.Inject

class DetailFragmentPresenter @Inject constructor(
    private val getRecipeByIdUseCase: GetRecipeByIdUseCase
) : MvpPresenter<DetailView>() {

    private val disposables = CompositeDisposable()

    override fun attachView(view: DetailView?) {
        super.attachView(view)
    }

    override fun detachView(view: DetailView?) {
        super.detachView(view)
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

    fun loadDetailInfo(id:Int) {
        disposables += getRecipeByIdUseCase(id)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoading()
            }
            .doAfterTerminate {
                viewState.hideLoading()
            }
            .subscribeBy(
                onSuccess = {
                    viewState.loadInfo(it)
                }, onError = { error ->
                    viewState.showError(error)
                })
    }
}

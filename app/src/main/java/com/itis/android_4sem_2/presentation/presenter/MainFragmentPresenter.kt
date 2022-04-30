package com.itis.android_4sem_2.presentation.presenter

import com.itis.android_4sem_2.domain.usecase.GetRandomRecipeUseCase
import com.itis.android_4sem_2.domain.usecase.GetRecipeByTitleUseCase
import com.itis.android_4sem_2.presentation.view.MainView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import moxy.MvpPresenter
import javax.inject.Inject

class MainFragmentPresenter @Inject constructor(
    private val getRandomRecipeUseCase: GetRandomRecipeUseCase,
    private val getRecipeByTitleUseCase: GetRecipeByTitleUseCase
) : MvpPresenter<MainView>() {

    private val disposables = CompositeDisposable()

    override fun attachView(view: MainView?) {
        super.attachView(view)
    }

    override fun detachView(view: MainView?) {
        super.detachView(view)
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

    fun loadListFirst() {
        disposables += getRandomRecipeUseCase.invoke()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoading()
            }.doAfterTerminate {
                viewState.hideLoading()
            }
            .subscribeBy(onSuccess = {
                viewState.showList(listOf(it))
            }, onError = { error ->
                viewState.showError(error)
            })
    }

    fun loadListBySearch(query: String){
        disposables += getRecipeByTitleUseCase.invoke(query)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoading()
            }.doAfterTerminate {
                viewState.hideLoading()
            }
            .subscribeBy(onSuccess = {
                viewState.showList(listOf(it))
            }, onError = { error ->
                viewState.showError(error)
            })
    }
}

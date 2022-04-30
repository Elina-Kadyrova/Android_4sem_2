package com.itis.android_4sem_2.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import com.itis.android_4sem_2.R
import com.itis.android_4sem_2.databinding.DetailFragmentBinding
import com.itis.android_4sem_2.domain.converters.ImageConverter
import com.itis.android_4sem_2.domain.entity.DetailModel
import com.itis.android_4sem_2.presentation.presenter.DetailFragmentPresenter
import com.itis.android_4sem_2.presentation.rv.IngredientAdapter
import com.itis.android_4sem_2.presentation.view.DetailView
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import retrofit2.HttpException
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : MvpAppCompatFragment(R.layout.detail_fragment), DetailView {

    private var binding: DetailFragmentBinding? = null
    private var ingredientAdapter: IngredientAdapter? = null
    private val recipeId: Int by lazy {
        arguments?.getInt("RECIPE_ID") ?: -1
    }
    @Inject
    @InjectPresenter
    lateinit var presenter: DetailFragmentPresenter
    @ProvidePresenter
    fun providePresenter(): DetailFragmentPresenter = presenter
    @Inject
    lateinit var converter: ImageConverter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadDetailInfo(recipeId)
    }

    override fun loadInfo(detailModel: DetailModel) {
        this.binding.apply{
            this?.tvTitle?.text = detailModel.title
            this?.tvReadyMin?.text = detailModel.readyInMinutes.toString()
            //this?.ivRecipeDetail.load(converter.setImageIconUrl(recipe.image))
        }
        initIngredientList(detailModel)
    }

    private fun initIngredientList(detailModel: DetailModel) {
        ingredientAdapter = IngredientAdapter(detailModel)
        this.binding?.rvIngridients?.apply {
            adapter = ingredientAdapter
        }
    }

    override fun showLoading() {
        binding?.progressDetail?.isVisible = true
    }

    override fun hideLoading() {
        binding?.progressDetail?.isVisible = false
    }

    override fun showError(throwable: Throwable) {
        when (throwable) {
            is HttpException -> {
                   showMessage("CONNECTION ERROR")
            }
            is NullPointerException -> {
               showMessage("DATA ERROR")
            }
            else -> {
                showMessage("ERROR")
            }
        }
    }

    private fun showMessage(message: String) {
        Snackbar.make(
            requireActivity().findViewById(R.id.container),
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}

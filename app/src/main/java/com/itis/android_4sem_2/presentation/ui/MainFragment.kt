package com.itis.android_4sem_2.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.itis.android_4sem_2.R
import com.itis.android_4sem_2.databinding.MainFragmentBinding
import com.itis.android_4sem_2.domain.converters.ImageConverter
import com.itis.android_4sem_2.domain.entity.ListModel
import com.itis.android_4sem_2.presentation.presenter.MainFragmentPresenter
import com.itis.android_4sem_2.presentation.rv.RecipeAdapter
import com.itis.android_4sem_2.presentation.view.MainView
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import retrofit2.HttpException
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : MvpAppCompatFragment(R.layout.main_fragment), MainView {

    private var binding: MainFragmentBinding? = null
    private lateinit var recipeAdapter: RecipeAdapter
    @Inject
    @InjectPresenter
    lateinit var presenter: MainFragmentPresenter
    @ProvidePresenter
    fun providePresenter(): MainFragmentPresenter = presenter
    @Inject
    lateinit var converter: ImageConverter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
        presenter.loadListFirst()
        initSearchView()
    }

    private fun initSearchView() {
        binding?.searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    presenter.loadListBySearch(it)
                }
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }

    override fun showList(listModel: List<ListModel>) {
        recipeAdapter = RecipeAdapter(converter) {
            openDetailsScreen(it)
        }
        recipeAdapter.submitList(listModel.toMutableList())
        binding?.rvList?.apply {
            adapter = recipeAdapter
        }
    }

    override fun showLoading() {
        binding?.progressMain?.isVisible = true
    }

    override fun hideLoading() {
        binding?.progressMain?.isVisible = false
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

    override fun openDetailsScreen(id: Int) {
        val bundle = Bundle().apply {
            putInt("RECIPE_ID", id)
        }
        val options = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .build()
        findNavController().navigate(
            R.id.action_mainFragment_to_detailFragment,
            bundle,
            options
        )
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}

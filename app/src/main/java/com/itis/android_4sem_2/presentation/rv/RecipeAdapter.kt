package com.itis.android_4sem_2.presentation.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.itis.android_4sem_2.domain.converters.ImageConverter
import com.itis.android_4sem_2.domain.entity.ListModel

class RecipeAdapter(
    private val imageConverter: ImageConverter,
    private val onClick: (Int) -> (Unit)
) :  ListAdapter<ListModel, RecipeHolder>(RecipeDiffUtilsCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder
    = RecipeHolder.create(parent, imageConverter, onClick)

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: MutableList<ListModel>?) {
        super.submitList(
            if (list == null) null
            else ArrayList(list)
        )
    }
}

class RecipeDiffUtilsCallback : DiffUtil.ItemCallback<ListModel>() {

    override fun areItemsTheSame(
        oldItem: ListModel,
        newItem: ListModel
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: ListModel,
        newItem: ListModel
    ): Boolean = oldItem == newItem
}

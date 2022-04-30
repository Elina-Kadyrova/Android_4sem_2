package com.itis.android_4sem_2.presentation.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itis.android_4sem_2.databinding.ItemRecipeBinding
import com.itis.android_4sem_2.domain.converters.ImageConverter
import com.itis.android_4sem_2.domain.entity.ListModel

class RecipeHolder (
    private val binding: ItemRecipeBinding,
    private val imageConverter: ImageConverter,
    private val onClick: (Int) -> (Unit))
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ListModel) {
        with(binding) {
            tvItemRecipeTitle.text = item.title
            //ivRecipePhoto.load(imageConverter.setImageIconUrl(item.image))
            itemView.setOnClickListener {
                onClick(item.id)
            }
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            imageConverter: ImageConverter,
            onClick: (Int) -> Unit
        ) = RecipeHolder(
            ItemRecipeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            imageConverter,
            onClick
        )
    }
}

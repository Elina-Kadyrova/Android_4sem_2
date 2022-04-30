package com.itis.android_4sem_2.presentation.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itis.android_4sem_2.R
import com.itis.android_4sem_2.domain.converters.ImageConverter
import com.itis.android_4sem_2.domain.entity.DetailModel

class IngredientAdapter (
    private var detailModel: DetailModel
    ) : RecyclerView.Adapter<IngredientHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientHolder {
        return IngredientHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_ingridient, parent,false))
    }

    override fun getItemCount() = detailModel.extendedIngredients.size

    override fun onBindViewHolder(holder: IngredientHolder, position: Int) {
        holder.bind(detailModel.extendedIngredients[position])
    }
}

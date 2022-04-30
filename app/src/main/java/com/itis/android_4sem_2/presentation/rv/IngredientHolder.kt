package com.itis.android_4sem_2.presentation.rv

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itis.android_4sem_2.R
import com.itis.android_4sem_2.domain.entity.IngredientModel

class IngredientHolder(
    itemView: View)
: RecyclerView.ViewHolder(itemView)
{
    private val title: TextView = itemView.findViewById(R.id.tv_itemRecipeTitle)
    private val amount: TextView = itemView.findViewById(R.id.tv_temAmount)

    fun bind(ingredientModel: IngredientModel) {
        title.text = ingredientModel.name
        amount.text = ingredientModel.amount.toString()
    }
}

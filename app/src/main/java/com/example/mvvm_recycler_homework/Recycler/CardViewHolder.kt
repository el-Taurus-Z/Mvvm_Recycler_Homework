package com.example.mvvm_recycler_homework.Recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_recycler_homework.domain.models.GraphicCard
import com.example.mvvm_recycler_homework.OnClick.OnCardItemClick
import com.example.mvvm_recycler_homework.R
import com.example.mvvm_recycler_homework.domain.models.NewGraphicCard

class CardViewHolder(itemView: View, private val OnItemClickListener: OnCardItemClick) :
    RecyclerView.ViewHolder(itemView) {
    companion object {
        fun newInstance(parent: ViewGroup, OnCardItemClick: OnCardItemClick) = CardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false),
            OnCardItemClick
        )
    }


    private val nameOfCard by lazy { itemView.findViewById<TextView>(R.id.cardName) }
    private val seriesOfCard by lazy { itemView.findViewById<TextView>(R.id.cardsSeries) }
    private val postfixCard by lazy { itemView.findViewById<TextView>(R.id.cardPostfix) }
    private val rootView by lazy { itemView.findViewById<ConstraintLayout>(R.id.root) }


    fun bindItem(item: NewGraphicCard) {
        with(item) {
            nameOfCard.text=item.cardInfo
        }
        rootView.setOnClickListener{
            OnItemClickListener.OnItemClick(item)
        }
    }


}

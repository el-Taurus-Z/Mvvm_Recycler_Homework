package com.example.mvvm_recycler_homework.Recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_recycler_homework.domain.models.GraphicCard
import com.example.mvvm_recycler_homework.OnClick.OnCardItemClick
import com.example.mvvm_recycler_homework.domain.models.NewGraphicCard

class CardAdapter(private val OnCardItemClick:OnCardItemClick) : RecyclerView.Adapter<CardViewHolder>() {
    private var items: List<NewGraphicCard> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder.newInstance(parent, OnCardItemClick)
    }


    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int=items.size

    fun submitList(data: List<NewGraphicCard>) {
        items = data
        notifyDataSetChanged()
    }

}
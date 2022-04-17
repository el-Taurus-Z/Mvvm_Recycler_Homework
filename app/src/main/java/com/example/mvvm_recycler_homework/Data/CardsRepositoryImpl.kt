package com.example.mvvm_recycler_homework.Data

import com.example.mvvm_recycler_homework.domain.CardsRepository
import com.example.mvvm_recycler_homework.domain.models.GraphicCard
import com.example.mvvm_recycler_homework.domain.models.NewGraphicCard

object CardsRepositoryImpl: CardsRepository {
    private val cardsList = listOf(
        GraphicCard("GTX", "3060", "TI"),
        GraphicCard("GTX", "1060", ""),
        GraphicCard("AMD", "Hui znaet", "Don't understand")
    )
    override fun getCards(): List<GraphicCard> {
        return cardsList
    }
}
package com.example.mvvm_recycler_homework.domain

import com.example.mvvm_recycler_homework.domain.models.GraphicCard
import com.example.mvvm_recycler_homework.domain.models.NewGraphicCard

class CardsInteractorImpl(private val repository: CardsRepository) : CardsInteractor {
    override fun getCards(): List<NewGraphicCard> {
        return repository.getCards().map { graphicCard ->
            NewGraphicCard(
                cardInfo = "${graphicCard.cardName} ${graphicCard.cardSeries} ${graphicCard.cardPostfix}"
            )

        }

    }
}

package com.example.mvvm_recycler_homework.domain

import com.example.mvvm_recycler_homework.domain.models.GraphicCard
import com.example.mvvm_recycler_homework.domain.models.NewGraphicCard

interface CardsInteractor {
    fun getCards():List<NewGraphicCard>
}
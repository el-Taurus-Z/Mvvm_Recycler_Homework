package com.example.mvvm_recycler_homework.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_recycler_homework.Data.CardsRepositoryImpl
import com.example.mvvm_recycler_homework.domain.CardsInteractor
import com.example.mvvm_recycler_homework.domain.CardsInteractorImpl
import com.example.mvvm_recycler_homework.domain.CardsRepository
import com.example.mvvm_recycler_homework.domain.models.GraphicCard
import com.example.mvvm_recycler_homework.domain.models.NewGraphicCard

class MVVMViewModel:ViewModel() {



    val cardsLiveData: LiveData<List<NewGraphicCard>> get() = _cardsLiveData
    private val _cardsLiveData = MutableLiveData<List<NewGraphicCard>>()
    private val repository:CardsRepository=CardsRepositoryImpl
    private val interactor:CardsInteractor=CardsInteractorImpl(
        repository )
    init {
        loadCards()
    }

    private fun loadCards(){
        _cardsLiveData.value=interactor.getCards()
    }

}
package com.example.mvvm_recycler_homework.OnClick

import com.example.mvvm_recycler_homework.domain.models.GraphicCard
import com.example.mvvm_recycler_homework.domain.models.NewGraphicCard

interface FromFragmentToMainClick {
    fun TransferItem(item: NewGraphicCard)
}
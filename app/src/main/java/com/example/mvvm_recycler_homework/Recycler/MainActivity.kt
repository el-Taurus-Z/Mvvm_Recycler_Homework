package com.example.mvvm_recycler_homework.Recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm_recycler_homework.domain.models.GraphicCard
import com.example.mvvm_recycler_homework.Fragment.BottomSheetFragment
import com.example.mvvm_recycler_homework.OnClick.FromFragmentToMainClick
import com.example.mvvm_recycler_homework.R
import com.example.mvvm_recycler_homework.domain.models.NewGraphicCard
import com.example.mvvm_recycler_homework.presentation.MVVMViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
       val bottomSheetDialogFragment = BottomSheetFragment(FromFragmentToMainClick)
        chooseCard.setOnClickListener{
            bottomSheetDialogFragment.show(supportFragmentManager, "New Dialog")
        }
    }

    private val FromFragmentToMainClick = object : FromFragmentToMainClick{
        override fun TransferItem(item: NewGraphicCard) {
            chooseCard.setText(item.cardInfo)
        }

    }
}
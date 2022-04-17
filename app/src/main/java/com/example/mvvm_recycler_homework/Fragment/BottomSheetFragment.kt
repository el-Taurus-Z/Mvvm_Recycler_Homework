package com.example.mvvm_recycler_homework.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvm_recycler_homework.domain.models.GraphicCard

import com.example.mvvm_recycler_homework.OnClick.FromFragmentToMainClick
import com.example.mvvm_recycler_homework.OnClick.OnCardItemClick
import com.example.mvvm_recycler_homework.R
import com.example.mvvm_recycler_homework.Recycler.CardAdapter
import com.example.mvvm_recycler_homework.domain.models.NewGraphicCard
import com.example.mvvm_recycler_homework.presentation.MVVMViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottomsheet_fragment.*

class BottomSheetFragment(FromFragmentToMainClick: FromFragmentToMainClick) :
    BottomSheetDialogFragment() {
    private val viewModel = MVVMViewModel()
    private val adapter by lazy { CardAdapter(OnCardItemClick) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottomsheet_fragment, container, false)
    }

    private val OnCardItemClick by lazy {
        object : OnCardItemClick {
            override fun OnItemClick(item: NewGraphicCard) {
                FromFragmentToMainClick.TransferItem(item)
                dismiss()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.adapter=adapter
        viewModel.cardsLiveData.observe(viewLifecycleOwner) { graphicCard ->
            adapter.submitList(
                graphicCard
            )
        }
    }
}
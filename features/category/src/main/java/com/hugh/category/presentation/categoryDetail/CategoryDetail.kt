package com.hugh.category.presentation.categoryDetail

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hugh.category.R
import com.hugh.category.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryDetail : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private val categoryDetailViewModel: CategoryDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DataBindingUtil.bind(view)!!

        categoryDetailViewModel.sample()
    }
}
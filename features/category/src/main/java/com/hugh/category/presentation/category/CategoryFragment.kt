package com.hugh.category.presentation.category

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.hugh.category.R
import com.hugh.category.databinding.FragmentCategoryBinding
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.presentation.category.adapter.CategoryAdapter
import com.hugh.category.presentation.category.adapter.GridSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment(R.layout.fragment_category) {

    private lateinit var binding: FragmentCategoryBinding
    private val articleViewModel: ArticleViewModel by viewModels()

    private val moveDetailCallback: (CategoryType) -> Unit = {
        val action = CategoryFragmentDirections.actionCategoryToCategoryDetail(it)
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DataBindingUtil.bind(view)!!

        binding.recycler.apply {
            adapter = CategoryAdapter(moveDetailCallback).apply {
                submitList(articleViewModel.createCategoryTypeList())
            }
            layoutManager = GridLayoutManager(this.context, 3)
            addItemDecoration(GridSpacingItemDecoration(3, 50))
            setHasFixedSize(true)
        }
    }
}
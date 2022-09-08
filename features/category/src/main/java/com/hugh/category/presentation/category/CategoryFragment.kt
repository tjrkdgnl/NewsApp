package com.hugh.category.presentation.category

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.hugh.navigator.FragmentNavigator
import com.hugh.category.R
import com.hugh.category.databinding.FragmentCategoryBinding
import com.hugh.category.presentation.category.adapter.CategoryAdapter
import com.hugh.util.GridSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CategoryFragment : Fragment(R.layout.fragment_category) {

    private lateinit var binding: FragmentCategoryBinding
    private val articleViewModel: ArticleViewModel by viewModels()

    @Inject
    lateinit var fragmentNavigator: FragmentNavigator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = viewLifecycleOwner

        binding.recycler.apply {
            adapter = CategoryAdapter {
                fragmentNavigator.categoryToCategoryList(it,findNavController())
            }.also {
                it.submitList(articleViewModel.createCategoryTypeList())
            }
            layoutManager = GridLayoutManager(this.context, 3)
            addItemDecoration(GridSpacingItemDecoration(3, 50))
            setHasFixedSize(true)
        }
    }
}
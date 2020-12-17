package com.demotrix.fooddelivery.home

import android.content.Context
import android.os.Bundle
import android.view.View
import com.airbnb.mvrx.*
import com.demotrix.fooddelivery.R
import com.demotrix.fooddelivery.adapter.FoodAdapter
import com.demotrix.fooddelivery.databinding.FragmentFoodBinding
import com.google.android.material.chip.Chip


class FoodFragment : BaseMvRxFragment(R.layout.fragment_food) {

    lateinit var activity: HomeActivity
    lateinit var binding: FragmentFoodBinding
    private val viewModel: FoodViewModel by activityViewModel()
    private val adapter: FoodAdapter = FoodAdapter {
        viewModel.addToCart(it)
    }
    var categoryId: Int = -1

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is HomeActivity) {
            activity = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFoodBinding.bind(view)
        with(binding) {
            foodList.adapter = adapter
        }
        setupFilter()
        requireArguments().apply {
            categoryId = getInt(ARG_CATEGORY)
        }
    }

    private fun setupFilter() {
        //dummy filter
        for (i: Int in 0..4) {
            with(Chip(requireContext())) {
                binding.filterGroup.addView(this)
            }

        }
    }

    override fun invalidate(): Unit = withState(viewModel) { state ->
        when (state.items) {
            is Loading -> {
                binding.pgLoading.visibility = View.VISIBLE
                binding.contentGroup.visibility = View.GONE
            }
            is Success -> {
                binding.pgLoading.visibility = View.GONE
                binding.contentGroup.visibility = View.VISIBLE
                adapter.updateDataSet(state.items.invoke().filter { it.categoryId == categoryId })
            }

            else -> {
                //ignore
            }
        }
    }

    companion object {
        private const val ARG_CATEGORY = "arg_filter"

        fun ofCategory(category: Int): FoodFragment {
            val bundle: Bundle = Bundle().apply {
                putInt(ARG_CATEGORY, category)
            }
            return FoodFragment().apply {
                arguments = bundle
            }
        }
    }
}
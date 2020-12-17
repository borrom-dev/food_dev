package com.demotrix.fooddelivery.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.demotrix.fooddelivery.R
import com.demotrix.fooddelivery.adapter.CategoryPagerAdapter
import com.demotrix.fooddelivery.adapter.FeaturePagerAdapter
import com.demotrix.fooddelivery.databinding.FragmentHomeBinding
import com.demotrix.fooddelivery.utils.categories
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseMvRxFragment(R.layout.fragment_home) {

    private val viewModel: FoodViewModel by activityViewModel()

    private lateinit var activity: HomeActivity

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: CategoryPagerAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is HomeActivity) {
            activity = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        adapter = CategoryPagerAdapter(categories, requireActivity() as AppCompatActivity)
        with(binding) {
            featureList.adapter = FeaturePagerAdapter()
            pagerCategory.adapter = adapter
            setupPager(tabCategory, pagerCategory)
        }
    }

    private fun setupPager(tabLayout: TabLayout, pager: ViewPager2) {
        TabLayoutMediator(tabLayout, pager) { tab, index ->
            tab.text = adapter.getTitle(index)
        }.attach()
    }

    override fun invalidate(): Unit = withState(viewModel) { state ->
        when (state.items) {
            is Success -> {
                showCounter(state.cartItems.size)
            }
            else -> {

            }
        }
    }

    private fun showCounter(itemsCount: Int) {
        with(binding.btnCheckout) {
            text = "{$itemsCount}"
            translationY = 0.0f
            setOnClickListener {
                activity.showCheckout()
            }
        }
    }

    companion object {
        val TAG: String = HomeFragment::class.java.simpleName
    }
}
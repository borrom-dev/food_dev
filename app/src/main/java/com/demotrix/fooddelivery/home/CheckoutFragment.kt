package com.demotrix.fooddelivery.home

import android.os.Bundle
import android.view.View
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.demotrix.fooddelivery.R
import com.demotrix.fooddelivery.adapter.CheckoutAdapter
import com.demotrix.fooddelivery.databinding.FragmentCheckoutBinding

class CheckoutFragment : BaseMvRxFragment(R.layout.fragment_checkout) {

    private val viewModel: FoodViewModel by activityViewModel()
    private lateinit var binding: FragmentCheckoutBinding
    private val adapter = CheckoutAdapter {
        viewModel.removeFromCart(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCheckoutBinding.bind(view)
        binding.cartList.adapter = adapter
        binding.btnMenu.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun invalidate(): Unit = withState(viewModel) { state ->
        when (state.items) {
            is Success -> {
                adapter.notifyDataSet(state.cartItems)
                with(if (state.cartItems.isNotEmpty()) View.GONE else View.VISIBLE) {
                    binding.txtEmpty.visibility = this
                    binding.cartList.visibility != this
                }
            }
            else -> {

            }
        }
    }

    companion object {
        val TAG: String = HomeFragment::class.java.simpleName
    }
}
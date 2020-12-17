package com.demotrix.fooddelivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demotrix.fooddelivery.R
import com.demotrix.fooddelivery.databinding.FeatureItemViewBinding

class FeaturePagerAdapter : RecyclerView.Adapter<FeaturePagerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).run {
            inflate(R.layout.feature_item_view, parent, false)
        }
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = 20

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when (position % 2) {
            0 -> {
                holder.binding.imgFeature.setImageResource(R.drawable.feature_img_01)
            }
            else -> {
                holder.binding.imgFeature.setImageResource(R.drawable.feature_img_02)
            }
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: FeatureItemViewBinding = FeatureItemViewBinding.bind(view)
    }

}
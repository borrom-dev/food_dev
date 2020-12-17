package com.demotrix.fooddelivery.utils

import android.animation.Animator
import android.widget.Button
import androidx.core.content.ContextCompat
import com.demotrix.fooddelivery.R

typealias DoCheckout = () -> Unit

fun Button.doCheckout(doCheckout: DoCheckout) {
    val text: CharSequence = text
    animate().setListener(object : Animator.AnimatorListener {
        override fun onAnimationRepeat(animation: Animator?) {
            //ignore
        }

        override fun onAnimationEnd(animation: Animator?) {
            setText(text)
            setBackgroundColor(ContextCompat.getColor(context, R.color.black))
            doCheckout.invoke()
        }

        override fun onAnimationCancel(animation: Animator?) {
            //ignore
        }

        override fun onAnimationStart(animation: Animator?) {
            setText(R.string.txt_add_cart_plus)
            setBackgroundColor(
                ContextCompat.getColor(context, R.color.design_default_color_primary)
            )
        }
    }).start()
}
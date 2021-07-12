package com.mcdev.animatedloadingbutton

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.mcdev.animatedloadingbutton.databinding.ActivityAlbbuttonBinding

class ALBButton @JvmOverloads constructor(context: Context,
                                          attrs: AttributeSet? = null,
                                          defStyle: Int = 0) : RelativeLayout(
        context, attrs, defStyle
    ){
    private var TAG = "ALBButton"
    private val binding: ActivityAlbbuttonBinding = ActivityAlbbuttonBinding.inflate(LayoutInflater.from(context), this, true)
    private val helper: Helper = Helper()


    private var mDisplayText: String? = null
    private var mLoadingText: String? = null
    private var isButtonLoading : Boolean = false


    init {
        val attributes = context.theme.obtainStyledAttributes(attrs, R.styleable.ALBView, defStyle, defStyle)
        mDisplayText = attributes.getString(R.styleable.ALBView_display_text)
        mLoadingText = attributes.getString(R.styleable.ALBView_loading_text)

        setDisplayText(mDisplayText)

        binding.albBtnLayout.setOnClickListener {
            when (isButtonLoading) {
                false -> {
                    animateText(Techniques.SlideOutDown)
                    animateLoadingText(mLoadingText)
                    isButtonLoading = true
                }
            }

        }
    }

    private fun animateText(animation: Techniques) {
        YoYo.with(animation)
            .duration(300)
            .playOn(binding.albTv)
    }
    private fun animateLoadingText(loadingText: String?) {
            Handler(Looper.getMainLooper()).postDelayed({
                setLoadingText(loadingText)
                animateText(Techniques.BounceInDown)
            }, 300)
    }

    fun setDisplayText(displayText: String?) {
        binding.albTv.text = displayText
    }

    fun setLoadingText(loadingText: String?) {
        binding.albTv.text = loadingText
    }

    fun isSuccess() {
        setDisplayText(mDisplayText)
        animateText(Techniques.BounceInUp)
        isButtonLoading = false
    }
}
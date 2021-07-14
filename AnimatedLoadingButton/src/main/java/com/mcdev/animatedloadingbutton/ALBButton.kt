package com.mcdev.animatedloadingbutton

import android.animation.*
import android.content.Context
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.mcdev.animatedloadingbutton.databinding.ActivityAlbbuttonBinding


class ALBButton @JvmOverloads constructor(context: Context,
                                          attrs: AttributeSet? = null,
                                          defStyle: Int = 0) : RelativeLayout(
        context, attrs, defStyle
    ){
    private var TAG = "ALBButton"
    private val ANIMATION_DURATION = 300L
    private val binding: ActivityAlbbuttonBinding = ActivityAlbbuttonBinding.inflate(LayoutInflater.from(context), this, true)
    private val helper: Helper = Helper()


    /*default*/
    private var mDefaultText: String? = null
    private var mDefaultBgColor: Int
    private var mDefaultTextColor: Int

    /*loading*/
    private var isButtonLoading : Boolean = false
    private var mLoadingText: String? = null
    private var mLoadingBgColor: Int
    private var mLoadingTextColor: Int

    /*success*/
    private var mSuccessText: String? = null
    private var mSuccessBgColor: Int
    private var mSuccessTextColor: Int

    /*error*/
    private var mErrorText: String? = null
    private var mErrorBgColor: Int
    private var mErrorTextColor: Int



    init {
        val attributes = context.theme.obtainStyledAttributes(attrs, R.styleable.ALBButton, defStyle, defStyle)
       /*default*/
        mDefaultText = attributes.getString(R.styleable.ALBButton_default_text)
        mDefaultBgColor = attributes.getColor(R.styleable.ALBButton_default_bg_color, ContextCompat.getColor(context, R.color.design_default_color_primary))
        mDefaultTextColor = attributes.getColor(R.styleable.ALBButton_default_text_color, Color.WHITE)

        setDefaultText(mDefaultText)
        setDefaultBgColor(mDefaultBgColor)
        setDefaultTextColor(mDefaultTextColor)

        /*loading*/
        mLoadingText = attributes.getString(R.styleable.ALBButton_loading_text)
        mLoadingBgColor = attributes.getColor(R.styleable.ALBButton_loading_bg_color, ContextCompat.getColor(context, R.color.design_default_color_primary))
        mLoadingTextColor = attributes.getColor(R.styleable.ALBButton_loading_text_color, Color.WHITE)

        /*success*/
        mSuccessText = attributes.getString(R.styleable.ALBButton_success_text)
        mSuccessBgColor = attributes.getColor(R.styleable.ALBButton_success_bg_color, ContextCompat.getColor(context, R.color.green_500))
        mSuccessTextColor = attributes.getColor(R.styleable.ALBButton_success_text_color, Color.WHITE)

        /*error*/
        mErrorText = attributes.getString(R.styleable.ALBButton_error_text)
        mErrorBgColor = attributes.getColor(R.styleable.ALBButton_error_bg_color, Color.RED)
        mErrorTextColor = attributes.getColor(R.styleable.ALBButton_error_text_color, Color.WHITE)


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
            .duration(ANIMATION_DURATION)
            .playOn(binding.albTv)
    }
    private fun animateLoadingText(loadingText: String?) {
            Handler(Looper.getMainLooper()).postDelayed({
                setLoadingText(loadingText)
                binding.albTv.text = loadingText
                binding.albTv.setTextColor(mLoadingTextColor)
                changeButtonBgColor(mLoadingBgColor)
                animateText(Techniques.BounceInDown)
            }, ANIMATION_DURATION)
    }

    fun setDefaultText(defaultText: String?) {
        this.mDefaultText = defaultText
        binding.albTv.text = defaultText
    }

    fun setDefaultBgColor(color: Int) {
        this.mDefaultBgColor = color
        changeButtonBgColor(color)
    }

    fun setDefaultTextColor(color: Int) {
        this.mDefaultTextColor = color
        binding.albTv.setTextColor(color)
    }

    fun setLoadingText(loadingText: String?) {
        this.mLoadingText = loadingText
    }

    fun setLoadingBgColor(color: Int) {
        this.mLoadingBgColor = color
    }

    fun setLoadingTextColor(color: Int) {
        this.mLoadingTextColor = color
    }

    fun setSuccessText(successText: String?) {
        this.mSuccessText = successText
    }

    fun setSuccessBgColor(color: Int) {
        this.mSuccessBgColor = color
    }

    fun setSuccessTextColor(color: Int) {
        this.mSuccessTextColor = color
    }

    fun setErrorText(errorText: String?) {
        this.mErrorText = errorText
    }

    fun setErrorBgColor(color: Int) {
        this.mErrorBgColor = color
    }

    fun setErrorTextColor(color: Int) {
        this.mErrorTextColor = color
    }

    fun isSuccess() {
        changeButtonText(mSuccessText)
        animateText(Techniques.BounceInUp)
        changeButtonBgColor(mSuccessBgColor)
        changeButtonTextColor(mSuccessTextColor)
        isButtonLoading = false
    }

    fun isError() {
        changeButtonText(mErrorText)
        animateText(Techniques.BounceInUp)
        changeButtonBgColor(mErrorBgColor)
        changeButtonTextColor(mErrorTextColor)
        isButtonLoading = false
    }

    private fun changeButtonText(text: String?) {
        binding.albTv.text = text
    }

    private fun changeButtonBgColor(color: Int) {
        binding.albBtnLayout.setCardBackgroundColor(color)
    }

    private fun changeButtonTextColor(color: Int) {
        binding.albTv.setTextColor(color)
    }
}
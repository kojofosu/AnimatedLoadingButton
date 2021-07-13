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

    /*success*/
    private var mButtonSuccessColor: Int = Color.GREEN

    /*fail*/
    private var mButtonErrorColor: Int = Color.RED


    init {
        val attributes = context.theme.obtainStyledAttributes(attrs, R.styleable.ALBView, defStyle, defStyle)
       /*default*/
        mDefaultText = attributes.getString(R.styleable.ALBView_default_text)
        mDefaultBgColor = attributes.getColor(R.styleable.ALBView_default_bg_color, ContextCompat.getColor(context, R.color.design_default_color_primary))
        mDefaultTextColor = attributes.getColor(R.styleable.ALBView_default_text_color, Color.WHITE)

        setDefaultText(mDefaultText)
        setDefaultBgColor(mDefaultBgColor)
        setDefaultTextColor(mDefaultTextColor)

        /*loading*/
        mLoadingText = attributes.getString(R.styleable.ALBView_loading_text)

        /*success*/

        /*fail*/


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

                startColorAnimation(binding.albBtnLayout, mDefaultBgColor, mButtonErrorColor)
                animateText(Techniques.BounceInDown)
            }, ANIMATION_DURATION)
    }

    fun setDefaultText(defaultText: String?) {
        binding.albTv.text = defaultText
    }

    fun setDefaultBgColor(color: Int) {
        binding.albBtnLayout.setCardBackgroundColor(color)
    }

    fun setDefaultTextColor(color: Int) {
        binding.albTv.setTextColor(color)
    }

    fun setLoadingText(loadingText: String?) {
        binding.albTv.text = loadingText
    }

    fun isSuccess() {
        setDefaultText(mDefaultText)
        animateText(Techniques.BounceInUp)
        startColorAnimation(binding.albBtnLayout, mDefaultBgColor, Color.GREEN)
        isButtonLoading = false
    }

    private fun startColorAnimation(target: View, colorStart: Int, colorEnd : Int) {
        val colorAnim: ValueAnimator = ObjectAnimator.ofInt(target, "backgroundColor", colorStart, colorEnd)
        colorAnim.duration = ANIMATION_DURATION
        colorAnim.setEvaluator(ArgbEvaluator())
        colorAnim.repeatCount = 0
        colorAnim.repeatMode = ValueAnimator.REVERSE
        colorAnim.start()
    }
}
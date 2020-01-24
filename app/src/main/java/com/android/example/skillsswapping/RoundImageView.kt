package com.android.example.skillsswapping

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.R
import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.Path
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import android.graphics.RectF
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class RoundImageView : AppCompatImageView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        val path = Path()
        val rectF = RectF()
        val width = measuredWidth.toFloat()
        val height = measuredHeight.toFloat()
        rectF.set(0.0f, 0.0f, width, height)
        path.addRoundRect(rectF,width / 2, height / 2, Path.Direction.CW)
        canvas?.clipPath(path)
        super.onDraw(canvas)
    }
}
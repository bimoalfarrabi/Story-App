package com.dicoding.picodiploma.loginwithanimation.view.signup

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText


class PasswordEditText : AppCompatEditText {
    private val minLength = 8

    constructor(context: Context?) : super(context!!)
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    )

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!, attrs, defStyleAttr
    )

    override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
        super.onTextChanged(text, start, before, count)
        error = if (text.length < minLength) {
            "Password harus lebih dari 8 karakter"
        } else {
            null
        }
    }
}
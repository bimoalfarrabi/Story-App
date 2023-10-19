package com.dicoding.picodiploma.loginwithanimation.view.signup

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class EmailEditText : AppCompatEditText {

    private val EMAIL_PATTERN = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        // Set inputType
        inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
    }

    override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
        super.onTextChanged(text, start, before, count)

        error = if (text.isNotBlank() && !EMAIL_PATTERN.matches(text)) {
            "Email tidak valid"
        } else {
            null
        }
    }
}
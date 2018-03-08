package com.fiap.evandro.firebase.extensions

import android.support.design.widget.TextInputLayout

fun TextInputLayout.getText() : String {
    return editText?.text.toString()
}
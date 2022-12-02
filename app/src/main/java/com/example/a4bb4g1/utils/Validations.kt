package com.example.a4bb4g1

import android.text.TextUtils
import android.util.Patterns


    fun String.isValidEmail():Boolean{
            return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
        }

    fun String.isValidPassword():Boolean{
        return this.length >= 8
    }
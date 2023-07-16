package com.example.android.shoestoreinventory.screen.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private var _isLogin = MutableLiveData<Boolean>()

    val isLogin: LiveData<Boolean>
        get() = _isLogin

    init {
        _isLogin.value = false
    }

    fun loginApp() {
        _isLogin.value = true
    }
}

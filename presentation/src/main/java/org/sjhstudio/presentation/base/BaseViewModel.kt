package org.sjhstudio.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {

    private val _loading: MutableLiveData<Boolean> by lazy { MutableLiveData(false) }
    val loading: LiveData<Boolean>
        get() = _loading

    fun handleLoading(loading: Boolean) {
        _loading.postValue(loading)
    }

}
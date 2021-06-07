package com.example.usecase.ui.main.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usecase.data.model.CommentResponse
import com.example.usecase.data.repository.MainRepository
import com.example.usecase.utils.NetworkHelper
import com.example.usecase.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _comments = MutableLiveData<Resource<CommentResponse>>()
    val comments: LiveData<Resource<CommentResponse>> get() = _comments


     fun fetchComments() {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getComments().let {
                    if (it.isSuccessful) {
                        _comments.postValue(Resource.success(it.body()))
                    }
                }
            }
        }
    }


}
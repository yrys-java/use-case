package com.example.usecase.interactor

//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.async
//import kotlinx.coroutines.launch
//import java.rmi.ServerError
//import java.rmi.ServerException
//
//abstract class UseCase<T, Params> {
//    abstract suspend fun doOnBackground(params: Params?): Result<T>
//
//    fun execute(scope: CoroutineScope, params: Params? = null, onResult: (Result<T>) -> Unit) {
//        scope.launch {
//            val deferred = async(Dispatchers.IO) {
//                doOnBackground(params)
//            }
//
//            onResult(deferred.await())
//        }
//    }
//}
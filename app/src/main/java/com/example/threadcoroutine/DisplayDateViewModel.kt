package com.example.threadcoroutine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime


class DisplayDateViewModel : ViewModel() {
    /*
    Data, która będzie wyświetlana przez wątek w trakcie działania aplikacji:
     */
    private var _date : MutableLiveData<LocalDateTime> = MutableLiveData<LocalDateTime>()
    val date : LiveData<LocalDateTime>
        get() = _date
    /*
    Licznik, który będzie inkrementowany przez coroutine w trakcie działania aplikacji:
     */
    private var _counter : MutableLiveData<Int> = MutableLiveData<Int>()
    val counter : LiveData<Int>
        get() = _counter

    init{
        _date.value = LocalDateTime.now()
        _counter.value = 0
    }
    /*
    Funkcje, które odpowiadają za działanie wątku i coroutine
    */
    fun dateTimeThread(){
        object : Thread(){
            override fun run(){
                while(true){
                  _date.postValue(LocalDateTime.now())
                  sleep(1000)
                }
            }
        }.start()
    }

    fun counterCoroutine(){
        viewModelScope.launch {
            while(true){
                _counter.value = counter.value?.inc()
                delay(1000)
            }
        }
    }
}
package com.example.anilist.Data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anilist.Data.Entities.Anime
import com.example.anilist.Data.Entities.AnimeDetail
import com.example.anilist.Data.ServicesApi.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel: ViewModel(){

                val apiService= ApiClient.create()
                private val _items_liveData = MutableLiveData<List<Anime>>()
                val itemLiveData:LiveData<List<Anime>> = _items_liveData
                private val _filtredItemsLiveData=MutableLiveData<List<AnimeDetail>>()
                val filtredItemsLiveData: LiveData<List<AnimeDetail>>get() = _filtredItemsLiveData
                fun fetchAnimes(){
                    viewModelScope.launch {
                        try {
                            val response = apiService.getAnimes()
                            withContext(Dispatchers.Main){
                                _items_liveData.value = response
                            }
                        }catch (e:Exception){

                        }
                    }
                }

}
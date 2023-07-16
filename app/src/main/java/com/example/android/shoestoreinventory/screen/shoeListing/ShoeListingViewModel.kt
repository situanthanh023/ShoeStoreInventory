package com.example.android.shoestoreinventory.screen.shoeListing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.shoestoreinventory.model.Shoe

class ShoeListingViewModel : ViewModel() {
    private var _listShoes = MutableLiveData<List<Shoe>>()

    private var shoes = mutableListOf(
        Shoe("Adidas", 42, "Adidas", "Good shoe"),
        Shoe("Nike", 42, "Adidas","Good shoe"),
        Shoe("Biti's hunter", 42, "Adidas","Good shoe"),
        Shoe("Puma", 42, "Adidas","Good shoe"),
        Shoe("Rebook", 42, "Adidas","Good shoe"),
    )

    val listShoes: LiveData<List<Shoe>>
        get() = _listShoes

    init {
        _listShoes.value = shoes
    }

    fun updateListShoe(shoe: Shoe) {
        shoes.add(shoe)
        _listShoes.value = shoes
    }
}

package com.example.android.shoestoreinventory.screen.shoeListing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.shoestoreinventory.model.Shoe

class ShoeListingViewModel : ViewModel() {
    private var _listShoes = MutableLiveData<List<Shoe>>()

    private var shoes = mutableListOf(
        Shoe("11122", "Adidas", 42, 10),
        Shoe("11123", "Nike", 42, 11),
        Shoe("11124", "Biti's hunter", 42, 12),
        Shoe("11125", "Puma", 42, 13),
        Shoe("11126", "Rebook", 42, 14)
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

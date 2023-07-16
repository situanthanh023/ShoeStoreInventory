package com.example.android.shoestoreinventory.screen.shoeListing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.shoestoreinventory.model.Shoe

class ShoeListingViewModel : ViewModel() {
    private var _listShoes = MutableLiveData<List<Shoe>>()

    var nameShoe = ""
    var sizeShoe = ""
    var companyShoe = ""
    var description = ""

    private var shoes = mutableListOf(
        Shoe("Adidas", 42, "Adidas", "Good shoe"),
        Shoe("Nike", 42, "Adidas", "Good shoe"),
        Shoe("Biti's hunter", 42, "Adidas", "Good shoe"),
        Shoe("Puma", 42, "Adidas", "Good shoe"),
        Shoe("Rebook", 42, "Adidas", "Good shoe"),
    )

    val listShoes: LiveData<List<Shoe>>
        get() = _listShoes

    init {
        _listShoes.value = shoes
    }

    fun updateListShoe() {
        if (validateData()) {
            shoes.add(Shoe(nameShoe, sizeShoe.toInt(), companyShoe, description))
            _listShoes.value = shoes
        }
    }

    fun resetData() {
        nameShoe = ""
        sizeShoe = ""
        companyShoe = ""
        description = ""
    }

    private fun validateData(): Boolean {
        if (nameShoe.isEmpty() || sizeShoe.isEmpty() || companyShoe.isEmpty() || description.isEmpty()) {
            return false
        }
        return true
    }
}

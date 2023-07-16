package com.example.android.shoestoreinventory.screen.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.shoestoreinventory.R
import com.example.android.shoestoreinventory.databinding.ShoeDetailFragmentBinding
import com.example.android.shoestoreinventory.model.Shoe

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_detail_fragment, container, false)

        binding.saveNewShoe.setOnClickListener { view ->
            val shoe = Shoe(
                binding.edtIdShoe.text.toString(),
                binding.edtNameShoe.text.toString(),
                binding.edtSizeShoe.text.toString().toInt(),
                binding.edtQuantity.text.toString().toInt()
            )
            view.findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment(
                    shoe
                )
            )
        }

        return binding.root
    }
}

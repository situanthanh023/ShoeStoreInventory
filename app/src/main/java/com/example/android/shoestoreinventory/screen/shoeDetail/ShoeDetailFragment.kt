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
            val name = binding.edtNameShoe.text.toString()
            val size = binding.edtSizeShoe.text.toString()
            val company = binding.edtCompanyShoe.text.toString()
            val description = binding.edtDescription.text.toString()
            if (name.isEmpty() || size.isEmpty() || company.isEmpty() || description.isEmpty()) {
                view.findNavController().navigate(
                    ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment(
                        null
                    )
                )
            } else {
                val shoe = Shoe(
                    name, size.toInt(), company, description
                )
                view.findNavController().navigate(
                    ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment(
                        shoe
                    )
                )
            }
        }

        binding.cancelNewShoe.setOnClickListener { view ->
            view.findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment(
                    null
                )
            )
        }

        return binding.root
    }
}

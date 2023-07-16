package com.example.android.shoestoreinventory.screen.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.android.shoestoreinventory.R
import com.example.android.shoestoreinventory.databinding.ShoeDetailFragmentBinding
import com.example.android.shoestoreinventory.screen.shoeListing.ShoeListingViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding

    private val viewModel: ShoeListingViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_detail_fragment, container, false)

        binding.shoe = viewModel

        binding.lifecycleOwner = this

        binding.saveNewShoe.setOnClickListener { view ->
            viewModel.updateListShoe()
            view.findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment()
            )
        }

        binding.cancelNewShoe.setOnClickListener { view ->
            viewModel.resetData()
            view.findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment()
            )
        }

        return binding.root
    }
}

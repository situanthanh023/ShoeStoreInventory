package com.example.android.shoestoreinventory.screen.shoeListing

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.android.shoestoreinventory.R
import com.example.android.shoestoreinventory.databinding.ShoeItemViewBinding
import com.example.android.shoestoreinventory.databinding.ShoeListingFragmentBinding
import com.example.android.shoestoreinventory.model.Shoe


class ShoeListingFragment : Fragment() {
    private lateinit var binding: ShoeListingFragmentBinding

    private lateinit var viewModel: ShoeListingViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.shoe_listing_fragment, container, false)

        val shoeListingFragmentArgs by navArgs<ShoeListingFragmentArgs>()

        val shoe = shoeListingFragmentArgs.shoe


        viewModel = ViewModelProvider(this)[ShoeListingViewModel::class.java]
        binding.listShoe = viewModel
        binding.lifecycleOwner = this

        if (shoe != null) {
            viewModel.updateListShoe(shoe)
        }

        viewModel.listShoes.observe(viewLifecycleOwner) {
            val list = viewModel.listShoes.value
            if (list != null) {
                binding.linearLayout.removeAllViews()
                for (item in list) {
                    binding.linearLayout.addView(
                        createViewForShoe(
                            shoe = item
                        )
                    )
                }
            }
        }

        binding.addNewShoe.setOnClickListener { view ->
            view.findNavController()
                .navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }

        return binding.root
    }

    private fun createViewForShoe(shoe: Shoe): View? {
        val inflater =
            requireContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val bindingShoe: ShoeItemViewBinding? =
            DataBindingUtil.inflate(inflater, R.layout.shoe_item_view, binding.linearLayout, false)

        if (bindingShoe != null) {
            bindingShoe.nameShoe.text = shoe.name
            bindingShoe.quantityShoe.text = shoe.count.toString()
            bindingShoe.sizeShoe.text = shoe.size.toString()
        }


        return bindingShoe?.root
    }
}
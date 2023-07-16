package com.example.android.shoestoreinventory.screen.shoeListing

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.android.shoestoreinventory.R
import com.example.android.shoestoreinventory.databinding.ShoeItemViewBinding
import com.example.android.shoestoreinventory.databinding.ShoeListingFragmentBinding
import com.example.android.shoestoreinventory.model.Shoe


class ShoeListingFragment : Fragment() {
    private lateinit var binding: ShoeListingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.shoe_listing_fragment, container, false)

        val viewModel = ViewModelProvider(requireActivity())[ShoeListingViewModel::class.java]

        binding.listShoe = viewModel
        binding.lifecycleOwner = this

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
            viewModel.resetData()
            view.findNavController()
                .navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.logout_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                when (menuItem.itemId) {
                    R.id.loginFragment ->
                        findNavController().navigate(
                            ShoeListingFragmentDirections.actionShoeListingFragmentToLoginFragment()
                        )
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }

    private fun createViewForShoe(shoe: Shoe): View? {
        val inflater =
            requireContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val bindingShoe: ShoeItemViewBinding? =
            DataBindingUtil.inflate(inflater, R.layout.shoe_item_view, binding.linearLayout, false)

        if (bindingShoe != null) {
            bindingShoe.nameShoe.text = shoe.name
            bindingShoe.companyName.text = shoe.company
            bindingShoe.sizeShoe.text = shoe.size.toString()
        }

        return bindingShoe?.root
    }
}
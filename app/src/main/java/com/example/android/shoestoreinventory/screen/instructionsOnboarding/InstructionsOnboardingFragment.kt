package com.example.android.shoestoreinventory.screen.instructionsOnboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.shoestoreinventory.R
import com.example.android.shoestoreinventory.databinding.InstructionsOnboardingFragmentBinding

class InstructionsOnboardingFragment : Fragment() {

    private lateinit var binding: InstructionsOnboardingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.instructions_onboarding_fragment, container, false
        )

        binding.nextPage.setOnClickListener { view ->
            view.findNavController().navigate(
                    InstructionsOnboardingFragmentDirections.actionInstructionsOnboardingFragmentToShoeListingFragment(
                        null
                    )
                )
        }

        return binding.root
    }
}

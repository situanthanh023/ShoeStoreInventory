package com.example.android.shoestoreinventory.screen.onboarding

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.shoestoreinventory.R
import com.example.android.shoestoreinventory.databinding.OnboardingFragmentBinding

class OnboardingFragment : Fragment() {

    private lateinit var binding: OnboardingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.onboarding_fragment, container, false)

        binding.nextPage.setOnClickListener { view ->
            view.findNavController()
                .navigate(OnboardingFragmentDirections.actionOnboardingFragmentToInstructionsOnboardingFragment())
        }

//        binding.root.setOnKeyListener { v, keyCode, event ->
//            {
//                if( keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
//
//                    return true;
//                }
//            }
//        }

        return binding.root
    }

}

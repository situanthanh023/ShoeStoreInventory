package com.example.android.shoestoreinventory.screen.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.shoestoreinventory.R
import com.example.android.shoestoreinventory.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.isLogin = viewModel

        binding.lifecycleOwner = this

        viewModel.isLogin.observe(viewLifecycleOwner) { isLogin ->
            if (isLogin) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToOnboardingFragment())
            }
        }

        return binding.root
    }
}

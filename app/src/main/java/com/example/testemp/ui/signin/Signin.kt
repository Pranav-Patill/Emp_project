package com.example.testemp.ui.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.testemp.R
import com.example.testemp.databinding.FragmentLoginBinding
import com.example.testemp.databinding.FragmentSigninBinding
import com.example.testemp.ui.login.LoginViewModel
import com.example.testemp.ui.login.LoginViewModelFactory

class Signin : Fragment() {

    private lateinit var signinViewModel: SigninViewModel
    private var _binding: FragmentSigninBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSigninBinding.inflate(inflater, container, false)
        binding.clickLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signin_to_loginFragment)
        }
        return binding.root
    }

}
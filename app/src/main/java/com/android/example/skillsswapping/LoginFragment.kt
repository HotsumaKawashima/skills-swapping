package com.android.example.skillsswapping


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import com.android.example.skillsswapping.LoginViewModel.AuthenticationState.*
import com.android.example.skillsswapping.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private val viewModel by viewModels<LoginViewModel> {
        LoginViewModel.Factory(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(inflater)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
        }

        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                AUTHENTICATED -> startMainActivityWithUserName()
                INVALID_AUTHENTICATION -> showErrorMessage()
            }
        })
    }

    private fun showErrorMessage() {
        Toast.makeText(context , "invalid input", Toast.LENGTH_LONG).show()
    }

    private fun startMainActivityWithUserName() {
        var activity = requireActivity()
        var intent = Intent(activity, MainActivity::class.java)
        intent.putExtra("userName", viewModel.userName.value)
        intent.putExtra("userPassword", viewModel.userPassword.value)
        startActivity(intent)
        activity.finish()
    }
}

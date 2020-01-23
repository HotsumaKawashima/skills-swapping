package com.android.example.skillsswapping


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.android.example.skillsswapping.LoginViewModel.AuthenticationState.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var loginButton: Button = view.findViewById(R.id.signInBtn)
        loginButton.setOnClickListener {
            loginViewModel.authenticate("usrname", "password")
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
        }

        loginViewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                AUTHENTICATED -> {
                    var activity = requireActivity()
                    var intent = Intent(activity, MainActivity::class.java)
                    intent.putExtra("userId", "test")
                    startActivity(intent)
                    activity.finish()
                }
                INVALID_AUTHENTICATION -> showErrorMessage()
            }
        })
    }

    private fun showErrorMessage() {
        Toast.makeText(context , "invalid input", Toast.LENGTH_LONG).show()
    }

}

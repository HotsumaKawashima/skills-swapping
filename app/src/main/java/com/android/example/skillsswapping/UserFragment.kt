package com.android.example.skillsswapping


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.android.example.skillsswapping.database.getDatabase
import com.android.example.skillsswapping.databinding.FragmentUserBinding
import com.android.example.skillsswapping.repository.UserRepository

/**
 * A simple [Fragment] subclass.
 */
class UserFragment : Fragment() , View.OnClickListener{

    private val viewModel by viewModels<UserViewModel>()

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUserBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.new_post_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.my_post_button).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.new_post_button -> navController!!.navigate(R.id.action_userFragment_to_newPostFragment)
            R.id.my_post_button -> navController!!.navigate(R.id.action_userFragment_to_myPostsFragment)
        }
    }
}

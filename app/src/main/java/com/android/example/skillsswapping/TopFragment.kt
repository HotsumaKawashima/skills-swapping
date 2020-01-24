package com.android.example.skillsswapping


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.android.example.skillsswapping.databinding.FragmentTopBinding

class TopFragment : Fragment(), View.OnClickListener {

    private val viewModel by lazy {
        ViewModelProviders.of(this, TopViewModel.Factory("")).get(TopViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTopBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_top, container, false
        )
        // Set the lifecycleOwner so DataBinding can observe LiveData
        binding.lifecycleOwner = viewLifecycleOwner
        binding.linearArt.setOnClickListener(this)
        binding.linearMusic.setOnClickListener(this)
        binding.linearCooking.setOnClickListener(this)
        binding.linearPrograming.setOnClickListener(this)
        binding.linearBeauty.setOnClickListener(this)
        binding.linearOthers.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.linearArt -> {
                this.findNavController()
                    .navigate(R.id.action_topFragment_to_categoryFragment,
                        viewModel.goToCategory("art"))
            }
            R.id.linearCooking -> {
                this.findNavController()
                    .navigate(R.id.action_topFragment_to_categoryFragment,
                        viewModel.goToCategory("cooking"))
            }
            R.id.linearPrograming -> {
                this.findNavController()
                    .navigate(R.id.action_topFragment_to_categoryFragment,
                        viewModel.goToCategory("programing"))
            }
            R.id.linearMusic -> {
                this.findNavController()
                    .navigate(R.id.action_topFragment_to_categoryFragment,
                        viewModel.goToCategory("music"))
            }
            R.id.linearBeauty -> {
                this.findNavController()
                    .navigate(R.id.action_topFragment_to_categoryFragment,
                        viewModel.goToCategory("beauty"))
            }
            R.id.linearOthers -> {
                this.findNavController()
                    .navigate(R.id.action_topFragment_to_categoryFragment,
                        viewModel.goToCategory("others"))
            }
        }
    }
}

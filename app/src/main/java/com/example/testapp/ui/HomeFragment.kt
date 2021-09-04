package com.example.testapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testapp.R
import com.example.testapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home){

    lateinit var binding :FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        binding.selectButton.setOnClickListener {

            findNavController().navigate(R.id.home_to_list)

        }

        if(arguments!= null && !requireArguments().isEmpty)
        {
            if(requireArguments().containsKey("name"))
            {
               val name = requireArguments().getString("name")
                binding.textView.text = name
            }

        }

    }

}
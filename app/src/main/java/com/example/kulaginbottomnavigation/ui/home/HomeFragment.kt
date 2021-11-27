package com.example.kulaginbottomnavigation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kulaginbottomnavigation.R
import com.example.kulaginbottomnavigation.databinding.FragmentAddEventBinding
import com.example.kulaginbottomnavigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)

        binding.tvToSettings.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_profile_to_fragment_settings)
        }

        binding.tvToAbout.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_profile_to_fragment_about)
        }

        binding.tvShare.setOnClickListener {
            Toast.makeText(requireContext(), "Фичи пока нет, мб будет позже)))", Toast.LENGTH_LONG).show()
        }
        return binding.root
    }

}
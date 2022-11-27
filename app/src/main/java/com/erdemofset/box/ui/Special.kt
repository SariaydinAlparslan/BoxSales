package com.erdemofset.box.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.erdemofset.box.R
import com.erdemofset.box.databinding.FragmentSpecialBinding

class Special : Fragment() {

    private var _binding: FragmentSpecialBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpecialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainslider1.progress = 75
        binding.mainslider2.progress = 45
        binding.mainslider3.progress = 50
        binding.mainslider1.setOnProgressChangeListener {
            binding.sliderText1.text = it.toString()
        }
        binding.mainslider2.setOnProgressChangeListener {
            binding.sliderText2.text = it.toString()
        }
        binding.mainslider3.setOnProgressChangeListener {
            binding.sliderText3.text = it.toString()
        }

        binding.mainslider2.barCornerRadius = 50
        binding.mainslider2.barWidth = 80
        binding.mainslider1.barCornerRadius = 50
        binding.mainslider1.barWidth = 80
        binding.mainslider3.barCornerRadius = 50
        binding.mainslider3.barWidth = 80

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
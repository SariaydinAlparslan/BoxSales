package com.erdemofset.box.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import com.erdemofset.box.R
import com.erdemofset.box.databinding.FragmentProductionBinding

class Production : Fragment() {
    private var _binding: FragmentProductionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProductionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(binding.videoView)

        binding.birVideo.setOnClickListener {
            val uri = Uri.parse("android.resource://com.erdemofset.box/${R.raw.bir}")
            binding.videoView.setMediaController(mediaController)
            binding.videoView.setVideoURI(uri)
            binding.videoView.requestFocus()
            binding.videos.visibility = View.GONE
            binding.videoViewLayout.visibility = View.VISIBLE
            binding.videoView.start()
        }
        binding.ikiVideo.setOnClickListener {
            val uri2 = Uri.parse("android.resource://com.erdemofset.box/${R.raw.iki}")
            binding.videoView.setMediaController(mediaController)
            binding.videoView.setVideoURI(uri2)
            binding.videoView.requestFocus()
            binding.videos.visibility = View.GONE
            binding.videoViewLayout.visibility = View.VISIBLE
            binding.videoView.start()
        }
        binding.ucVideo.setOnClickListener {
            val uri3 = Uri.parse("android.resource://com.erdemofset.box/${R.raw.uc}")
            binding.videoView.setMediaController(mediaController)
            binding.videoView.setVideoURI(uri3)
            binding.videoView.requestFocus()
            binding.videos.visibility = View.GONE
            binding.videoViewLayout.visibility = View.VISIBLE
            binding.videoView.start()
        }
        binding.dortVideo.setOnClickListener {
            val uri4 = Uri.parse("android.resource://com.erdemofset.box/${R.raw.dort}")
            binding.videoView.setMediaController(mediaController)
            binding.videoView.setVideoURI(uri4)
            binding.videoView.requestFocus()
            binding.videos.visibility = View.GONE
            binding.videoViewLayout.visibility = View.VISIBLE
            binding.videoView.start()
        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
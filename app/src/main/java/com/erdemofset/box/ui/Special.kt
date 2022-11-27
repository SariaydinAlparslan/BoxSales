package com.erdemofset.box.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.erdemofset.box.databinding.FragmentSpecialBinding
import java.net.URLEncoder

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
        slider()
        contactUs()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun contactUs(){
        val length = binding.lengthText.text
        val width = binding.widthText.text
        val height = binding.heightText.text
        val packageManager = requireActivity().packageManager
        binding.whatsapp.setOnClickListener {
            if (binding.lengthText.text.isNotEmpty()
                || binding.widthText.text.isNotEmpty()
                || binding.heightText.text.isNotEmpty() ){
                val whatsapp = Intent(Intent.ACTION_VIEW)
                val url = "https://api.whatsapp.com/send?phone=" + "+905452370510" + "&text="+ URLEncoder.encode("Length : "+""+ length +""+"Width :" +""+ width+ "Height : "+""+height)
                whatsapp.setPackage("com.whatsapp")
                whatsapp.data = Uri.parse(url)
                if (whatsapp.resolveActivity(packageManager) !=null){
                    startActivity(whatsapp)
                }
            }else{
                Toast.makeText(requireContext(), "Select Units", Toast.LENGTH_SHORT).show()
            }
        }
        binding.gmail.setOnClickListener {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    putExtra(Intent.EXTRA_EMAIL,"sariaydinalparslan@gmail.com")
                    putExtra(Intent.EXTRA_SUBJECT,"Order Box")
                    putExtra(Intent.EXTRA_TEXT,"Length : "+""+ length +""+"Width :" +""+ width+ "Height : "+""+height)
                }
                if (emailIntent.resolveActivity(packageManager)!=null){
                    startActivity(emailIntent)
                }else{
                    Toast.makeText(requireContext(), "Select Units", Toast.LENGTH_SHORT).show()
                }

        }
    }
    fun slider(){
        binding.mainslider1.progress = 75
        binding.mainslider2.progress = 45
        binding.mainslider3.progress = 50
        binding.mainslider1.setOnProgressChangeListener {
            binding.lengthText.text = it.toString()
        }
        binding.mainslider2.setOnProgressChangeListener {
            binding.widthText.text = it.toString()
        }
        binding.mainslider3.setOnProgressChangeListener {
            binding.heightText.text = it.toString()
        }

        binding.mainslider2.barCornerRadius = 50
        binding.mainslider2.barWidth = 80
        binding.mainslider1.barCornerRadius = 50
        binding.mainslider1.barWidth = 80
        binding.mainslider3.barCornerRadius = 50
        binding.mainslider3.barWidth = 80
    }
}
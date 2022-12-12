package com.erdemofset.box.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.erdemofset.box.databinding.FragmentSpecialBinding
import com.nvt.color.ColorPickerDialog
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
        contactUs()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun contactUs(){
        val packageManager = requireActivity().packageManager
        binding.whatsapp.setOnClickListener {
                if(binding.editH.text.isNotEmpty()&& binding.editL.text.isNotEmpty() && binding.editW.text.isNotEmpty()&& binding.pickColorText.text.isNotEmpty()){
                    val packageManager : PackageManager = packageManager
                    val i = Intent(Intent.ACTION_VIEW)
                    val url = "https://api.whatsapp.com/send?phone=" + "0905452370510" + "&text="+ URLEncoder
                        .encode("Length :"+ binding.editL.text.toString()+ " "+ " Width: "+ binding.editW.text.toString()+ " "+ "Height : " + binding.editH.text.toString()+ " "+ "Color : "+ binding.pickColorText.text
                            ,"UTF-8")
                    i.setPackage("com.whatsapp")
                    i.data = Uri.parse(url)
                    if(i.resolveActivity(packageManager) != null){
                        startActivity(i)
                    }
                }else{
                    Toast.makeText(requireContext(), "Please Enter Values And Pick Color", Toast.LENGTH_LONG).show()
                }
        }
        binding.gmail.setOnClickListener {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    putExtra(Intent.EXTRA_EMAIL,"sariaydinalparslan@gmail.com")
                    putExtra(Intent.EXTRA_SUBJECT,"Order Box")

                }
                if (emailIntent.resolveActivity(packageManager)!=null){
                    startActivity(emailIntent)
                }else{
                    Toast.makeText(requireContext(), "Select Units", Toast.LENGTH_SHORT).show()
                }
        }
        binding.pickColor.setOnClickListener {
            val colorPicker = ColorPickerDialog(
                requireContext(),
                Color.BLACK, // color init
                true, // true is show alpha
                object : ColorPickerDialog.OnColorPickerListener {
                    override fun onCancel(dialog: ColorPickerDialog?) {
                        // handle click button Cancel
                    }

                    override fun onOk(dialog: ColorPickerDialog?, colorPicker: Int) {
                         binding.pickColorText.text = colorPicker.toString()
                         binding.pickColorImage.setBackgroundColor(colorPicker)
                    }
                })
            colorPicker.show()
        }
    }
}
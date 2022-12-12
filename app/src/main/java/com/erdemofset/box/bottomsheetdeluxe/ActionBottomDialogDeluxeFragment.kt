package com.erdemofset.box.bottomsheetdeluxe

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.erdemofset.box.R
import com.erdemofset.box.singleton.boxSingleton
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_settings.*
import kotlinx.android.synthetic.main.bottom_sheet_settings.imageBottomSheet
import kotlinx.android.synthetic.main.bottom_sheet_settings.productCodeText
import kotlinx.android.synthetic.main.bottom_sheet_settings_deluxe.*
import kotlinx.android.synthetic.main.fragment_deluxe.*
import kotlinx.coroutines.flow.combine
import java.net.URLEncoder

class ActionBottomDialogDeluxeFragment(private var mListener: ItemClickListenerDeluxe):BottomSheetDialogFragment(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_settings_deluxe,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productCodeText.text = boxSingleton.productCode2

        val resourceID =  requireContext().resources.getIdentifier("${boxSingleton.imageDeluxe}", "drawable",requireContext().packageName)
        imageBottomSheet.setImageResource(resourceID)

        //whatsapp
        deluxeWhat.setOnClickListener {
            val packageManager : PackageManager =requireActivity().packageManager
            val i = Intent(Intent.ACTION_VIEW)
            val url = "https://api.whatsapp.com/send?phone=" + "0905452370510" + "&text="+ URLEncoder
                .encode( productCodeText.text.toString()
                    ,"UTF-8")
            i.setPackage("com.whatsapp")
            i.data = Uri.parse(url)
            if(i.resolveActivity(packageManager) != null){
                startActivity(i)
            }
        }
    }

    override fun onClick(p0: View?) {
        val tvSelected = p0 as TextView
        mListener!!.onItemClickDeluxe(tvSelected.text.toString())
        dismiss()
    }
}
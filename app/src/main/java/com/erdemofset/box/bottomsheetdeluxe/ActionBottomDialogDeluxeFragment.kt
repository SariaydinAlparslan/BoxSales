package com.erdemofset.box.bottomsheetdeluxe

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
import kotlinx.android.synthetic.main.fragment_deluxe.*

class ActionBottomDialogDeluxeFragment(private var mListener: ItemClickListenerDeluxe):BottomSheetDialogFragment(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_settings,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dss.setOnClickListener { Toast.makeText(requireContext(), "Hello My Friend", Toast.LENGTH_SHORT).show() }

        productNameText.text = boxSingleton.productName2
        productInfoText.text = boxSingleton.productInfo2
        productCodeText.text = boxSingleton.productCode2
        internalDimensionsText.text= boxSingleton.internalDimensions2
        rawMaterialText.text = boxSingleton.rawMaterial2
        priceText.text = boxSingleton.price2!!.toInt().toString() +" "+"$"
        lengthText.text =boxSingleton.length2.toString()
        heightText.text =boxSingleton.height2.toString()
        widthText.text =boxSingleton.width2.toString()

        val resourceID =  requireContext().resources.getIdentifier("${boxSingleton.imageDeluxe}", "drawable",requireContext().packageName)
        imageBottomSheet.setImageResource(resourceID)
    }

    override fun onClick(p0: View?) {
        val tvSelected = p0 as TextView
        mListener!!.onItemClickDeluxe(tvSelected.text.toString())
        dismiss()
    }
}
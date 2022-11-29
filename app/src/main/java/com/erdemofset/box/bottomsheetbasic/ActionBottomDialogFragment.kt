package com.erdemofset.box.bottomsheetbasic

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

class ActionBottomDialogFragment(private var mListener: ItemClickListener):BottomSheetDialogFragment(), View.OnClickListener{

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
        basdad.setOnClickListener { Toast.makeText(requireContext(), "HappyBirthdayPastaDiyorum", Toast.LENGTH_SHORT).show() }

        productNameText.text = boxSingleton.productName
        productInfoText.text = boxSingleton.productInfo
        productCodeText.text = boxSingleton.productCode
        internalDimensionsText.text= boxSingleton.internalDimensions
        rawMaterialText.text = boxSingleton.rawMaterial
        priceText.text = boxSingleton.price!!.toInt().toString() +" "+"$"
        lengthText.text =boxSingleton.length.toString()
        heightText.text =boxSingleton.height.toString()
        widthText.text =boxSingleton.width.toString()

        val resourceID =  requireContext().resources.getIdentifier("${boxSingleton.imageBasic}", "drawable",requireContext().packageName)
        imageBottomSheet.setImageResource(resourceID)

    }
    override fun onClick(p0: View?) {
        val tvSelected = p0 as TextView
        mListener!!.onItemClick(tvSelected.text.toString())
        dismiss()
    }
}
package com.erdemofset.box.bottomsheetbasic

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.erdemofset.box.R
import com.erdemofset.box.singleton.boxSingleton
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_settings.*
import kotlinx.android.synthetic.main.bottom_sheet_settings.priceText
import kotlinx.android.synthetic.main.bottom_sheet_settings.productCodeText
import kotlinx.android.synthetic.main.fragment_sales.*


class ActionBottomDialogFragment(private var mListener: ItemClickListener):BottomSheetDialogFragment(), View.OnClickListener{

    var order1Ready : Boolean? = false
    var order2Ready : Boolean? = false


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


        val sharedPreferences = this.activity?.getSharedPreferences("com.erdemofset.box",
            Context.MODE_PRIVATE)
        //orders
        order1Ready = sharedPreferences!!.getBoolean("order1",false)
        order2Ready = sharedPreferences!!.getBoolean("order2",false)

        productNameText.text = boxSingleton.productName
        productInfoText.text = boxSingleton.productInfo
        productCodeText.text = boxSingleton.productCode
        internalDimensionsText.text= boxSingleton.internalDimensions
        rawMaterialText.text = boxSingleton.rawMaterial
        priceText.text = boxSingleton.price!!.toInt().toString() +" "+"$"
        lengthText.text =boxSingleton.length.toString()
        heightText.text =boxSingleton.height.toString()
        widthText.text =boxSingleton.width.toString()

        val textNumber = 50
        product50Text.text = textNumber.toString()+ " " + "Pieces"


        val resourceID =  requireContext().resources.getIdentifier("${boxSingleton.imageBasic}", "drawable",requireContext().packageName)
        imageBottomSheet.setImageResource(resourceID)

        //spinner
        spNumbersBasic.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                //new price
                val value1 = boxSingleton.price!!.toInt()
                val value2 = p0?.getItemAtPosition(p2).toString().toInt()
                val result = value1*value2
                priceText.text = "$result"+" "+"$"

                //new pieces count
                val piecesCount = p0?.getItemAtPosition(p2).toString().toInt()
                product50Text.text = (textNumber*piecesCount).toString()+ " " + "Pieces"

                lottie1.setOnClickListener {
                        lottie1.playAnimation()
                        boxSingleton.salesProductName = productInfoText.text.toString()
                        boxSingleton.salesProductNumber = p0?.getItemAtPosition(p2).toString()
                        boxSingleton.salesProductPrice = result
                        boxSingleton.salesProductCode = productCodeText.text.toString()
                        boxSingleton.salesProductNumber50 = product50Text.text.toString()

                    if (order1Ready == false){
                    sharedPreferences!!.edit().putBoolean("order1",true).apply()
                    sharedPreferences!!.edit().putString("order1Number",boxSingleton.salesProductNumber).apply()
                    sharedPreferences!!.edit().putString("order1Code",boxSingleton.salesProductCode).apply()
                    sharedPreferences!!.edit().putInt("order1Price",boxSingleton.salesProductPrice!!).apply()
                    sharedPreferences!!.edit().putString("order1Number50",boxSingleton.salesProductNumber50!!).apply()
                    }
                    if (order1Ready == true && order2Ready ==false){
                        sharedPreferences!!.edit().putBoolean("order2",true).apply()
                        sharedPreferences!!.edit().putString("order2Number",boxSingleton.salesProductNumber).apply()
                        sharedPreferences!!.edit().putString("order2Code",boxSingleton.salesProductCode).apply()
                        sharedPreferences!!.edit().putInt("order2Price",boxSingleton.salesProductPrice!!).apply()
                        sharedPreferences!!.edit().putString("order2Number50",boxSingleton.salesProductNumber50!!).apply()
                    }
                    if (order1Ready == true && order2Ready == true){
                        sharedPreferences!!.edit().putBoolean("order3",true).apply()
                        sharedPreferences!!.edit().putString("order3Number",boxSingleton.salesProductNumber).apply()
                        sharedPreferences!!.edit().putString("order3Code",boxSingleton.salesProductCode).apply()
                        sharedPreferences!!.edit().putInt("order3Price",boxSingleton.salesProductPrice!!).apply()
                        sharedPreferences!!.edit().putString("order3Number50",boxSingleton.salesProductNumber50!!).apply()
                    }

                    Handler().postDelayed({
                        replaceFragment(com.erdemofset.box.ui.Basic())
                    },3000)
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
    override fun onClick(p0: View?) {
        val tvSelected = p0 as TextView
        mListener!!.onItemClick(tvSelected.text.toString())
        dismiss()
    }
    private fun replaceFragment (fragment : Fragment){

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}
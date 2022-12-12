package com.erdemofset.box.ui

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.erdemofset.box.R
import com.erdemofset.box.databinding.FragmentSalesBinding
import com.erdemofset.box.singleton.boxSingleton
import kotlinx.android.synthetic.main.fragment_sales.*

class Sales : Fragment() {

    private var _binding: FragmentSalesBinding? = null
    private val binding get() = _binding!!
    var order1Number : String? = null
    var order1Code : String? = null
    var order1Price : Int? = null
    var order1Number50 : String? = null
    var order2Number : String? = null
    var order2Code : String? = null
    var order2Price : Int? = null
    var order2Number50 : String? = null
    var order3Number : String? = null
    var order3Code : String? = null
    var order3Price : Int? = null
    var order3Number50 : String? = null
    var order1Ready : Boolean? = null
    var order2Ready : Boolean? = null
    var order3Ready : Boolean? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSalesBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = this.activity?.getSharedPreferences("com.erdemofset.box",
            MODE_PRIVATE)

        order1Number = sharedPreferences!!.getString("order1Number","")
        order1Price = sharedPreferences!!.getInt("order1Price",0)
        order1Code = sharedPreferences!!.getString("order1Code","")
        order1Number50 = sharedPreferences!!.getString("order1Number50","")
        order1Ready = sharedPreferences!!.getBoolean("order1",false)
        order2Number = sharedPreferences!!.getString("order2Number","")
        order2Price = sharedPreferences!!.getInt("order2Price",0)
        order2Code = sharedPreferences!!.getString("order2Code","")
        order2Number50 = sharedPreferences!!.getString("order2Number50","")
        order2Ready = sharedPreferences!!.getBoolean("order2",false)
        order3Number = sharedPreferences!!.getString("order3Number","")
        order3Price = sharedPreferences!!.getInt("order3Price",0)
        order3Code = sharedPreferences!!.getString("order3Code","")
        order3Number50 = sharedPreferences!!.getString("order3Number50","")
        order3Ready = sharedPreferences!!.getBoolean("order3",false)

        if (order1Ready == true){
            order1.visibility = View.VISIBLE
        }
        if (order2Ready == true){
            order2.visibility = View.VISIBLE
        }
        if (order3Ready == true){
            order3.visibility = View.VISIBLE
        }

        binding.productCodeText.text = order1Code
        binding.priceText.text = order1Price.toString()
        binding.productNumberText.text =  order1Number50

        binding.productCodeText2.text = order2Code
        binding.priceText2.text = order2Price.toString()
        binding.productNumberText2.text = order2Number50

        binding.productCodeText3.text = order3Code
        binding.priceText3.text = order3Price.toString()
        binding.productNumberText3.text = order3Number50

        binding.toplamText.text = (order1Price!! + order2Price!! + order3Price!!).toString()+"  "+ "$"

        binding.moreProduction.setOnClickListener {
            replaceFragment(Basic())
        }
        binding.removeAll.setOnClickListener {
           /* binding.productNumberText.text = ""
            binding.productNumberText2.text = ""
            binding.productNumberText3.text = ""
*/
            sharedPreferences.edit().remove("order1").apply()
            sharedPreferences.edit().remove("order2").apply()
            sharedPreferences.edit().remove("order3").apply()
            sharedPreferences.edit().remove("order1Number").apply()
            sharedPreferences.edit().remove("order2Number").apply()
            sharedPreferences.edit().remove("order3Number").apply()
            sharedPreferences.edit().remove("order1Code").apply()
            sharedPreferences.edit().remove("order2Code").apply()
            sharedPreferences.edit().remove("order3Code").apply()
            sharedPreferences.edit().remove("order1Price").apply()
            sharedPreferences.edit().remove("order2Price").apply()
            sharedPreferences.edit().remove("order3Price").apply()
            sharedPreferences.edit().remove("order1Number50").apply()
            sharedPreferences.edit().remove("order2Number50").apply()
            sharedPreferences.edit().remove("order3Number50").apply()

            replaceFragment(Sales())
        }
        binding.contactUsBtn.setOnClickListener {
            //whatsupp
        }
    }
    private fun replaceFragment (fragment : Fragment){

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }

}
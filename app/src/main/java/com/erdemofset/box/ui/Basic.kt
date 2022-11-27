package com.erdemofset.box.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.erdemofset.box.R
import com.erdemofset.box.bottomsheet.ActionBottom
import com.erdemofset.box.bottomsheet.ItemClickListener
import com.erdemofset.box.databinding.FragmentBasicBinding
import com.erdemofset.box.entity.Product

class Basic : Fragment(),ItemClickListener {

    private var _binding: FragmentBasicBinding? = null
    private val binding get() = _binding!!
    private lateinit var productList : ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBasicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productList = ArrayList<Product>()

        val kutu1 = Product(getString(R.string.kargokutusu),23.3,15.0,8.2,390.00,getString(R.string.icerik),getString(R.string.dort),"SBP2228","TST E","","14,8x22x8,1")
        val kutu2 = Product(getString(R.string.kargokutusu),11.5,9.0,5.8,220.00,getString(R.string.icerik),getString(R.string.dort),"SBP2227","TST E","","8,5x10,3x5,5")
        val kutu3 = Product(getString(R.string.kargokutusu),8.5,8.5,9.0,170.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2226","TST E","","8,3x8,3x8,7")
        val kutu4 = Product(getString(R.string.kargokutusu),8.8,5.0,6.2,170.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2225","TST E","","4,8x8,5x6")
        val kutu5 = Product(getString(R.string.kargokutusu),21.0,19.5,7.5,385.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2224","TST E","","19,2x19x7,5")
        val kutu6 = Product(getString(R.string.kargokutusu),15.5,17.0,6.5,300.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2223","TST E","","15,2x15,5x6,5")
        val kutu7 = Product(getString(R.string.kargokutusu),21.3,13.3,4.7,300.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2221","TST E","","13x20x,47")
        val kutu8 = Product(getString(R.string.kargokutusu),15.0,11.0,3.3,170.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2222","TST E","","10,8x14x3,3")
        val kutu9 = Product(getString(R.string.lock),23.0,15.5,11.5,335.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2220","TST","Bu ürün en çok hamburger kutusu olarak tercih edilmektedir","12,3x22,8x11,3")
        val kutu10 = Product(getString(R.string.lock),12.7,4.6,10.4,180.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2219","TST E/BST E","","4,4x12,4x9,8")
        val kutu11 = Product(getString(R.string.lock),11.5,4.0,9.6,170.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2218","TST E/BST E","","3,8x11,2x9,3")
        val kutu12 = Product(getString(R.string.heart),10.8,17.5,10.0,300.00,getString(R.string.heart),getString(R.string.raf),"SBP2217","TST E/BST E","","17,3x10,6x9,7")
        val kutu13 = Product(getString(R.string.lock),11.0,4.7,6.0,400.00,getString(R.string.kroma),getString(R.string.lock),"SBP2216","400 gr Kroma Karton","","4,7x11x6")
        val kutu14 = Product(getString(R.string.lock),20.2,3.6,4.2,300.00,getString(R.string.kroma),getString(R.string.lock),"SBP2215","400 gr Kroma Karton","Ürün standartta dışı beyaz içi gri renktedir.","3,6x20,2x4,2")
        val kutu15 = Product(getString(R.string.lock),11.0,4.7,6.0,400.00,getString(R.string.icerik),getString(R.string.lock),"SBP2214","TST E/BST E","","3,8x9,3x8,3")
        val kutu16 = Product(getString(R.string.lock),9.3,5.9,19.6,200.00,getString(R.string.icerik),getString(R.string.lock),"SBP2213","TST E/BST E","","5,7x9,1x19,1")
        val kutu17 = Product(getString(R.string.lock),14.4,12.8,6.0,270.00,getString(R.string.icerik),getString(R.string.lock),"SBP2212","TST E/BST E","","12,6x14,2x7,1")
        val kutu18 = Product(getString(R.string.lock),11.0,9.3,10.2,210.00,getString(R.string.icerik),getString(R.string.lock),"SBP2211","TST E/BST E","","9,1x10,8x9,7")
        val kutu19 = Product(getString(R.string.tongue),11.0,4.7,6.0,180.00,getString(R.string.icerik),getString(R.string.tongue),"SBP2210","TST E/BST E","","6,1x16,5x6,8")
        val kutu20 = Product(getString(R.string.kargokutusu),11.0,4.7,6.0,400.00,getString(R.string.icerik),getString(R.string.dayanıklı),"SBP2209","TST E/BST E","","20,3x26,5x6,2")




        binding.birBasic.setOnClickListener { openBottomSheet() }
        binding.ikiBasic.setOnClickListener { openBottomSheet() }
        binding.ucBasic.setOnClickListener { openBottomSheet() }
        binding.dortBasic.setOnClickListener { openBottomSheet() }
        binding.besBasic.setOnClickListener { openBottomSheet()}
        binding.altBasic.setOnClickListener { openBottomSheet()}
    }
    private fun openBottomSheet(){
        val addPhotoBottomDialogFragment = ActionBottom.newInstance(this)
        addPhotoBottomDialogFragment.show(
            childFragmentManager,ActionBottom.TAG
        )
    }
    override fun onItemClick(item: String?) {
    }
}
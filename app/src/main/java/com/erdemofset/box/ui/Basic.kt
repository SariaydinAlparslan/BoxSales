package com.erdemofset.box.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.erdemofset.box.R
import com.erdemofset.box.adapter.BasicAdapter
import com.erdemofset.box.bottomsheetbasic.ActionBottom
import com.erdemofset.box.bottomsheetbasic.ItemClickListener
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

        val kutu1 = Product(getString(R.string.kargokutusu),23.3,15.0,8.2,20.0,getString(R.string.icerik),getString(R.string.dort),"SBP2228","TST E","","14,8x22x8,1","birbir","biriki")
        val kutu2 = Product(getString(R.string.kargokutusu),11.5,9.0,5.8,11.00,getString(R.string.icerik),getString(R.string.dort),"SBP2227","TST E","","8,5x10,3x5,5","ikibir","ikiki")
        val kutu3 = Product(getString(R.string.kargokutusu),8.5,8.5,9.0,9.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2226","TST E","","8,3x8,3x8,7","ucbir","uciki")
        val kutu4 = Product(getString(R.string.kargokutusu),8.8,5.0,6.2,9.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2225","TST E","","4,8x8,5x6","dortbir","dortiki")
        val kutu5 = Product(getString(R.string.kargokutusu),21.0,19.5,7.5,20.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2224","TST E","","19,2x19x7,5","besbir","besiki")
        val kutu6 = Product(getString(R.string.kargokutusu),17.0,15.5,6.5,15.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2223","TST E","","15,2x15,5x6,5","altibir","altıiki")
        val kutu7 = Product(getString(R.string.kargokutusu),15.0,11.0,3.3,15.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2221","TST E","","13x20x,47","yedibir","yediiki")
        val kutu8 = Product(getString(R.string.kargokutusu),21.3,13.3,4.7,9.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2222","TST E","","10,8x14x3,3","sekizbir","sekiziki")
        val kutu9 = Product(getString(R.string.lock),23.0,12.5,11.5,17.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2220","TST","Bu ürün en çok hamburger kutusu olarak tercih edilmektedir","12,3x22,8x11,3","dokuzbir","dokuziki")
        val kutu10 = Product(getString(R.string.lock),12.7,4.6,10.4,9.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2219","TST E/BST E","","4,4x12,4x9,8","onbir","oniki")
        val kutu11 = Product(getString(R.string.lock),11.5,4.0,9.6,9.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2218","TST E/BST E","","3,8x11,2x9,3","onbirbir","onbiriki")
        val kutu12 = Product(getString(R.string.heart),10.8,17.5,10.0,15.00,getString(R.string.heart),getString(R.string.raf),"SBP2217","TST E/BST E","","17,3x10,6x9,7","onikibir","onikiiki")
        val kutu13 = Product(getString(R.string.lock),11.0,4.7,6.0,20.00,getString(R.string.kroma),getString(R.string.lock),"SBP2216","400 gr Kroma Karton","","4,7x11x6","onucbir","onuciki")
        val kutu14 = Product(getString(R.string.lock),20.2,3.6,4.2,15.00,getString(R.string.kroma),getString(R.string.lock),"SBP2215","400 gr Kroma Karton","Ürün standartta dışı beyaz içi gri renktedir.","3,6x20,2x4,2","ondortbir","ondortiki")
        val kutu15 = Product(getString(R.string.lock),9.5,4.0,8.8,20.00,getString(R.string.icerik),getString(R.string.lock),"SBP2214","TST E/BST E","","3,8x9,3x8,3","onbesbir","onbesiki")
        val kutu16 = Product(getString(R.string.lock),9.3,5.9,19.6,10.00,getString(R.string.icerik),getString(R.string.lock),"SBP2213","TST E/BST E","","5,7x9,1x19,1","onaltibir","onaltiiki")
        val kutu17 = Product(getString(R.string.lock),14.4,12.8,6.0,14.00,getString(R.string.icerik),getString(R.string.lock),"SBP2212","TST E/BST E","","12,6x14,2x7,1","onyedibir","onyediiki")
        val kutu18 = Product(getString(R.string.lock),11.0,9.3,10.2,11.00,getString(R.string.icerik),getString(R.string.lock),"SBP2211","TST E/BST E","","9,1x10,8x9,7","onsekizbir","onsekiziki")
        val kutu19 = Product(getString(R.string.tongue),11.0,4.7,6.0,9.00,getString(R.string.icerik),getString(R.string.tongue),"SBP2210","TST E/BST E","","6,1x16,5x6,8","ondokuzbir","ondokuziki")
        val kutu20 = Product(getString(R.string.dayanıklı),27.5,21.0,6.3,18.00,getString(R.string.wall),getString(R.string.dayanıklı),"SBP2209","TST E/BST E","","20,3x26,5x6,2","yirmibir","yirmiiki")
        val kutu21 = Product(getString(R.string.dayanıklı),32.0,15.0,10.2,22.00,getString(R.string.wall),getString(R.string.dayanıklı),"SBP2208","TST B/BST B","","14,5x30x9,7","yirmibirbir","yirmibiriki")
        val kutu22 = Product(getString(R.string.dayanıklı),26.7,13.5,7.9,18.00,getString(R.string.wall),getString(R.string.dayanıklı),"SBP2207","BST B/TST B","","13x24,9x8,5","yirmiikibir","yirmiikiiki")
        val kutu23 = Product(getString(R.string.dayanıklı),25.0,11.0,6.8,14.00,getString(R.string.wall),getString(R.string.dayanıklı),"SBP2206","BST B/TST B","","10,5x23,5x6,3","yirmiucbir","yirmiuciki")
        val kutu24 = Product(getString(R.string.dayanıklı),24.0,9.5,6.3,13.00,getString(R.string.wall),getString(R.string.dayanıklı),"SBP2205","BST B/TST B","","20,3x26,5x6,2","yirmidortbir","yirmidortiki")
        val kutu25 = Product(getString(R.string.dayanıklı),21.5,9.0,5.8,12.00,getString(R.string.wall),getString(R.string.dayanıklı),"SBP2204","BST B/TST B","","8,5x20x5,5","yirmibesbir","yirmibesiki")
        val kutu26 = Product(getString(R.string.dayanıklı),16.5,7.5,5.4,9.00,getString(R.string.wall),getString(R.string.dayanıklı),"SBP2203","BST E/TST E","","7,3x15,5x4","yirmialtibir","yirmialtiiki")
        val kutu27 = Product(getString(R.string.dayanıklı),16.0,6.4,3.6,8.00,getString(R.string.wall),getString(R.string.dayanıklı),"SBP2202","BST E/TST E","","6,2x15x3,5","yirmiyedibir","yirmiyediiki")
        val kutu28 = Product(getString(R.string.dayanıklı),14.7,6.7,3.1,8.00,getString(R.string.wall),getString(R.string.dayanıklı),"SBP2201","BST E/TST E","Beyaz ve Kraft seçenekleri mevcuttur.","5,8x13,7x3","yirmisekizbir","yirmisekiziki")


        productList.add(kutu1)
        productList.add(kutu2)
        productList.add(kutu3)
        productList.add(kutu4)
        productList.add(kutu5)
        productList.add(kutu6)
        productList.add(kutu7)
        productList.add(kutu8)
        productList.add(kutu9)
        productList.add(kutu10)
        productList.add(kutu11)
        productList.add(kutu12)
        productList.add(kutu13)
        productList.add(kutu14)
        productList.add(kutu15)
        productList.add(kutu16)
        productList.add(kutu17)
        productList.add(kutu18)
        productList.add(kutu19)
        productList.add(kutu20)
        productList.add(kutu21)
        productList.add(kutu22)
        productList.add(kutu23)
        productList.add(kutu24)
        productList.add(kutu25)
        productList.add(kutu26)
        productList.add(kutu27)
        productList.add(kutu28)

        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.setHasFixedSize(true)
        val landmarkAdapter = BasicAdapter(requireContext(),productList)
        binding.recyclerView.adapter = landmarkAdapter
        landmarkAdapter.onItemClick = {
            openBottomSheet()
        }
    }
    fun openBottomSheet(){
        val addPhotoBottomDialogFragment = ActionBottom.newInstance(this)
        addPhotoBottomDialogFragment.show(
            childFragmentManager,ActionBottom.TAG
        )
    }
    override fun onItemClick(item: String?) {
    }
}

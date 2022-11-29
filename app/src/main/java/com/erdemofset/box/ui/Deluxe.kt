package com.erdemofset.box.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.erdemofset.box.R
import com.erdemofset.box.adapter.BasicAdapter
import com.erdemofset.box.adapter.DeluxeAdapter
import com.erdemofset.box.bottomsheetbasic.ActionBottom
import com.erdemofset.box.bottomsheetdeluxe.ActionBottomDeluxe
import com.erdemofset.box.bottomsheetdeluxe.ItemClickListenerDeluxe
import com.erdemofset.box.databinding.FragmentBasicBinding
import com.erdemofset.box.databinding.FragmentDeluxeBinding
import com.erdemofset.box.entity.Product

class Deluxe : Fragment(), ItemClickListenerDeluxe {
    private var _binding: FragmentDeluxeBinding? = null
    private val binding get() = _binding!!
    private lateinit var productDeluxeList : ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDeluxeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        productDeluxeList = ArrayList<Product>()

        val kutu1 = Product(getString(R.string.kargokutusu),23.3,15.0,8.2,390.00,getString(R.string.icerik),getString(R.string.dort),"SBP2228","TST E","","14,8x22x8,1","birbir","biriki")
        val kutu2 = Product(getString(R.string.kargokutusu),11.5,9.0,5.8,220.00,getString(R.string.icerik),getString(R.string.dort),"SBP2227","TST E","","8,5x10,3x5,5","ikibir","ikiki")
        val kutu3 = Product(getString(R.string.kargokutusu),8.5,8.5,9.0,170.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2226","TST E","","8,3x8,3x8,7","ucbir","uciki")
        val kutu4 = Product(getString(R.string.kargokutusu),8.8,5.0,6.2,170.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2225","TST E","","4,8x8,5x6","dortbir","dortiki")
        val kutu5 = Product(getString(R.string.kargokutusu),21.0,19.5,7.5,385.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2224","TST E","","19,2x19x7,5","besbir","besiki")
        val kutu6 = Product(getString(R.string.kargokutusu),15.5,17.0,6.5,300.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2223","TST E","","15,2x15,5x6,5","altibir","altıiki")
        val kutu7 = Product(getString(R.string.kargokutusu),15.5,17.0,6.5,300.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2223","TST E","","15,2x15,5x6,5","altibir","altıiki")
        val kutu8 = Product(getString(R.string.kargokutusu),15.5,17.0,6.5,300.00,getString(R.string.icerik),getString(R.string.kargokutusu),"SBP2223","TST E","","15,2x15,5x6,5","altibir","altıiki")

        productDeluxeList.add(kutu1)
        productDeluxeList.add(kutu2)
        productDeluxeList.add(kutu3)
        productDeluxeList.add(kutu4)
        productDeluxeList.add(kutu5)
        productDeluxeList.add(kutu6)
        productDeluxeList.add(kutu7)
        productDeluxeList.add(kutu8)

        binding.recyclerViewDeluxe.layoutManager = StaggeredGridLayoutManager(2,
            StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerViewDeluxe.setHasFixedSize(true)
        val landmarkAdapter = DeluxeAdapter(requireContext(),productDeluxeList)
        binding.recyclerViewDeluxe.adapter = landmarkAdapter
        landmarkAdapter.onItemClick = {
            openBottomSheet()
        }

    }
    fun openBottomSheet(){
        val addPhotoBottomDialogFragment = ActionBottomDeluxe.newInstance(this)
        addPhotoBottomDialogFragment.show(
            childFragmentManager, ActionBottom.TAG
        )
    }
    override fun onItemClickDeluxe(item: String?) {
        TODO("Not yet implemented")
    }

}
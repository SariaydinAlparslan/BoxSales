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
import com.erdemofset.box.entity.ProductDeluxe

class Deluxe : Fragment(), ItemClickListenerDeluxe {
    private var _binding: FragmentDeluxeBinding? = null
    private val binding get() = _binding!!
    private lateinit var productDeluxeList : ArrayList<ProductDeluxe>

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


        productDeluxeList = ArrayList<ProductDeluxe>()

        val kutu1 = ProductDeluxe("D13","deluxeonuc")
        val kutu2 = ProductDeluxe("D20","deluxeyirmi")
        val kutu3 = ProductDeluxe("D3","deluxeuc")
        val kutu4 = ProductDeluxe("D4","deluxedort")
        val kutu5 = ProductDeluxe("D5","deluxebes")
        val kutu6 = ProductDeluxe("D6","deluxealti")
        val kutu7 = ProductDeluxe("D7","deluxeyedi")
        val kutu8 = ProductDeluxe("D8","deluxesekiz")
        val kutu9 = ProductDeluxe("D9","deluxedokuz")
        val kutu10 = ProductDeluxe("D10","deluxeon")
        val kutu11 = ProductDeluxe("D11","deluxeonbir")
        val kutu12 = ProductDeluxe("D12","deluxeoniki")
        val kutu13 = ProductDeluxe("D1","deluxebir")
        val kutu14 = ProductDeluxe("D14","deluxeondort")
        val kutu15 = ProductDeluxe("D15","deluxeonbes")
        val kutu16 = ProductDeluxe("D16","deluxeonalti")
        val kutu17 = ProductDeluxe("D17","deluxeonyedi")
        val kutu18 = ProductDeluxe("D18","deluxeonsekiz")
        val kutu19 = ProductDeluxe("D19","deluxeondokuz")
        val kutu20 = ProductDeluxe("D2","deluxeiki")
        val kutu21 = ProductDeluxe("D21","deluxeyirmibir")
        val kutu22 = ProductDeluxe("D22","deluxeyirmiiki")
        val kutu23 = ProductDeluxe("D23","deluxeyirmiuc")
        val kutu24 = ProductDeluxe("D24","deluxeyirmidort")


        productDeluxeList.add(kutu1)
        productDeluxeList.add(kutu2)
        productDeluxeList.add(kutu3)
        productDeluxeList.add(kutu4)
        productDeluxeList.add(kutu5)
        productDeluxeList.add(kutu6)
        productDeluxeList.add(kutu7)
        productDeluxeList.add(kutu8)
        productDeluxeList.add(kutu9)
        productDeluxeList.add(kutu10)
        productDeluxeList.add(kutu11)
        productDeluxeList.add(kutu12)
        productDeluxeList.add(kutu13)
        productDeluxeList.add(kutu14)
        productDeluxeList.add(kutu15)
        productDeluxeList.add(kutu16)
        productDeluxeList.add(kutu17)
        productDeluxeList.add(kutu18)
        productDeluxeList.add(kutu19)
        productDeluxeList.add(kutu20)
        productDeluxeList.add(kutu21)
        productDeluxeList.add(kutu22)
        productDeluxeList.add(kutu23)
        productDeluxeList.add(kutu24)

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
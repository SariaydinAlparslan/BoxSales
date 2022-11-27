package com.erdemofset.box.bottomsheet

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.erdemofset.box.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_settings.*
import java.lang.RuntimeException

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
        //dialogda neler olacağı
        //text.setonClick(this)

    }

    override fun onClick(p0: View?) {
        val tvSelected = p0 as TextView
        mListener!!.onItemClick(tvSelected.text.toString())
        dismiss()
    }
}
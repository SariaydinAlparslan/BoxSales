package com.erdemofset.box.bottomsheet

import android.content.Context

class ActionBottom {
    companion object{
        const val TAG = "ActionBottomDialog"
        fun newInstance(mListener:ItemClickListener):ActionBottomDialogFragment{

            return ActionBottomDialogFragment(mListener)
        }
    }
}
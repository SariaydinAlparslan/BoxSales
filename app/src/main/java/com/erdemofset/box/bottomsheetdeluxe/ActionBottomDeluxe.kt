package com.erdemofset.box.bottomsheetdeluxe

class ActionBottomDeluxe {
    companion object{
        const val TAG = "ActionBottomDialogDeluxe"
        fun newInstance(mListener:ItemClickListenerDeluxe):ActionBottomDialogDeluxeFragment{

            return ActionBottomDialogDeluxeFragment(mListener)
        }
    }
}
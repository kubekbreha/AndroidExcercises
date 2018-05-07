package com.nosense.grizzly.anko

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.contentFrameLayout
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivityUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        frameLayout(){
            val textField =  editText{
                hint = "Text for toast and snack"
            }.lparams(width = matchParent){
                margin = dip(12)
                topMargin = dip(30)
            }

            imageView(R.drawable.ic_android){
                onClick {
                    this@imageView.imageTintList = ColorStateList.valueOf(Color.parseColor("#4CAF50"))
                }
            }.lparams(dip(72), dip(72)){
                gravity = Gravity.CENTER
            }

            linearLayout{
                button("show toast"){
                    onClick {
                        toast(textField.text)
                    }
                }

                button("show toast"){
                    onClick {
                        longSnackbar(this@frameLayout, textField.text.toString())
                    }
                }


            }.lparams{
                gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
                bottomMargin = dip(72)
            }
        }
    }

}
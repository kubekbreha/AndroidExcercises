package com.nosense.grizzly.popmenu

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView_options.setOnClickListener{
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId){
                    R.id.menu_1 -> {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("google.com"))
                        startActivity(intent)
                        true
                    }
                    R.id.menu_2 -> {
                        Toast.makeText(this, "Toast", Toast.LENGTH_SHORT ).show()
                        true
                    }
                    else -> false
                }
            }

            popupMenu.inflate(R.menu.menu_main)
            popupMenu.show()
        }
    }
}

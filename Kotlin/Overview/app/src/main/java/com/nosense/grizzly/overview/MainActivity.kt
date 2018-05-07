package com.nosense.grizzly.overview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt
import uk.co.samuelwall.materialtaptargetprompt.extras.backgrounds.RectanglePromptBackground
import uk.co.samuelwall.materialtaptargetprompt.extras.focals.RectanglePromptFocal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFabPrompt()
    }


    private fun showFabPrompt() {
        val prefManager = PreferenceManager.getDefaultSharedPreferences(this)

        if (!prefManager.getBoolean("didShowPrompt", false)) {
            MaterialTapTargetPrompt.Builder(this)
                    .setTarget(fab)
                    .setPrimaryText("Click me")
                    .setSecondaryText("I'' secondary text")
                    .setBackButtonDismissEnabled(true)
                    .setPromptStateChangeListener { prompt, state ->
                        if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                                || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                            val prefEditor = prefManager.edit()
                            prefEditor.putBoolean("didShowPrompt", true)
                            prefEditor.apply()

                            showButtonPrompt()
                        }
                    }.show()
        }
    }

    private fun showButtonPrompt(){
        MaterialTapTargetPrompt.Builder(this)
                .setTarget(button)
                .setPrimaryText("Click me")
                .setSecondaryText("I'' secondary text")
                .setBackButtonDismissEnabled(true)
                .setPromptBackground(RectanglePromptBackground())
                .setPromptFocal(RectanglePromptFocal())
                .show()
    }


}

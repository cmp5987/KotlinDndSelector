package edu.rit.cmp5987.dndselector

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class AboutDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity).setTitle("About")
            .setMessage("This Application is for Fragment Homework and Created by Catherine Poggioli").create()
    }
}//AboutDialog
package edu.rit.cmp5987.dndselector

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class SelectedClassFragment : Fragment() {

    var displayMessage: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_selected_class, container, false)
        displayMessage = arguments?.getString("selectedClass")
        view.findViewById<TextView>(R.id.selected_class_name).text = displayMessage
        val newDrawableImageId = resources.getIdentifier(displayMessage, "drawable",
            this.activity?.packageName
        )
        view.findViewById<ImageView>(R.id.selected_class_image).setImageResource(newDrawableImageId)

        return view
    }
}
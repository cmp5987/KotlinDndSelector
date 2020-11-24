package edu.rit.cmp5987.dndselector

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import edu.rit.cmp5987.dndselector.R

class MyItemRecyclerViewAdapter(
    private val values: ArrayList<String>,
    private val communicator: Communicator
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_dnd_class, parent, false)
        view.findViewById<LinearLayout>(R.id.class_item).setOnClickListener{
            communicator.passDataCom(view.findViewById<TextView>(R.id.class_item_text).text.toString())
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.contentView.text = item
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contentView: TextView = view.findViewById(R.id.class_item_text)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}
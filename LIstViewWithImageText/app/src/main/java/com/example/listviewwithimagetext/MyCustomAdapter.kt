package com.example.listviewwithimagetext
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class MyCustomAdapter (context: Context, stdList: ArrayList<Student>) : ArrayAdapter<Student>(context, 0, stdList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // convertView which is recyclable view
        var currentItemView = convertView

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView =
                LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        }

        // get the position of the view from the ArrayAdapter
        val student: Student? = getItem(position)

        val stdImg = currentItemView!!.findViewById<ImageView>(R.id.image)
        val nameTv = currentItemView.findViewById<TextView>(R.id.name_tv)
        val phoneTv = currentItemView.findViewById<TextView>(R.id.phone_tv)

        assert(student != null)
        if (student != null) {
            stdImg.setImageResource(student.img)
            nameTv.setText(student.name)
            phoneTv.setText(student.phone)
        }

        // then return the recyclable view
        return currentItemView
    }
}


package com.example.listviewwithimagetext

import android.os.Bundle
import android.widget.ListView
import android.widget.AdapterView
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.listviewwithimagetext.Student

class MainActivity : ComponentActivity() {
     val studentList: ArrayList<Student> = ArrayList<Student>()

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val listView: ListView = findViewById(R.id.list_view)
//        val myCustomAdapter = MyCustomAdapter(this, studentList)
//        listView.adapter = myCustomAdapter
//
//        // Example student data (you can replace this with your own data)
//        studentList.add(Student(R.mipmap.ic_launcher, "Ali Ahmad", "+923324554671"))
//        studentList.add(Student(R.mipmap.ic_launcher, "Muhammad Sabih", "+9232006728736"))
//        studentList.add(Student(R.mipmap.ic_launcher, "Hakeem Sheikh", "+923112254883"))
//        studentList.add(Student(R.mipmap.ic_launcher, "Sajid Saleem", "+9234429904755"))
//        studentList.add(Student(R.mipmap.ic_launcher, "M Snanzad", "+923103982504"))
//
//        // Call addStudentDetails function to add more students
//        addStudentDetails()
//        listView.onItemClickListener(AdapterView.OnItemClickListener {AdapterView :AdapterView<*>,view: View, pos: Int, l:long->
//            val student: Student =adapterView.getItemAtPosition(pos) as Student
//
//            Toast.makeText(this, student.name, Toast.LENGTH_SHORT).show()
//
//
//        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.list_view)
        val myCustomAdapter = MyCustomAdapter(this, studentList)
        listView.adapter = myCustomAdapter

        // Example student data (you can replace this with your own data)
        studentList.add(Student(3, "Ali Ahmad", "+923324554671"))
//        studentList.add(Student(R.mipmap.ic_launcher, "Muhammad Sabih", "+9232006728736"))
//        studentList.add(Student(R.mipmap.ic_launcher, "Hakeem Sheikh", "+923112254883"))
//        studentList.add(Student(R.mipmap.ic_launcher, "Sajid Saleem", "+9234429904755"))
//        studentList.add(Student(R.mipmap.ic_launcher, "M Snanzad", "+923103982504"))

        // Call addStudentDetails function to add more students
        addStudentDetails()

        // Set item click listener using lambda expression
        listView.setOnItemClickListener { parent, view, position, id ->
            val student: Student = parent.getItemAtPosition(position) as Student
            Toast.makeText(this@MainActivity, student.name, Toast.LENGTH_SHORT).show()
        }
    }



    private fun addStudentDetails() {
        // Add more students to the list here if needed
        studentList.add(Student(3, "New Student", "+1234567890"))
        // Add more students as needed
    }
}

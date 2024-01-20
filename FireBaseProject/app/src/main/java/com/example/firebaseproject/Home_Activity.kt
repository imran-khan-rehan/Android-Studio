package com.example.firebaseproject
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
class HomeActivity : AppCompatActivity() {


    private lateinit var etName: EditText
    private lateinit var etRollNo: EditText
    private lateinit var etSemester: EditText
    private lateinit var etCourse: EditText
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setContentView(R.layout.index_home);
        etName = findViewById(R.id.etName)
        etRollNo = findViewById(R.id.etRollNo)
        etSemester = findViewById(R.id.etSemester)
        etCourse = findViewById(R.id.etCourse)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            // Retrieve data from EditTexts
            val name = etName.text.toString()
            val rollNo = etRollNo.text.toString()
            val semester = etSemester.text.toString()
            val course = etCourse.text.toString()

            // Create a Student object
            val student = Student(name, rollNo, semester, course)
            Toast.makeText(this@HomeActivity, "Here is data", Toast.LENGTH_SHORT).show()

          //  println("Student Details: $student")
            submitData(student);
        }
    }

    private fun submitData(student: Student) {
       val database = FirebaseDatabase.getInstance().reference
//        database.push().setValue(student);
        // Specify the path where the student data will be stored (e.g., under "Students" node with rollNo as the key)
        val studentsReference = database.child("Students").child(student.rollNo)

        // Use setValue to store the student data
        studentsReference.setValue(student)
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                  // Log.e("firebase", "Error getting data", task.exception)
                    Toast.makeText(this@HomeActivity, "Data  stored", Toast.LENGTH_SHORT).show()
                } else {
                    // Log the result value (optional)
                   // Log.d("firebase", task.result?.value.toString())
                   Toast.makeText(this@HomeActivity, "Your data is stored", Toast.LENGTH_SHORT).show()
                }
            }
    }

}

package com.webid.cvfresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class CreateProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_profile)

        val saveButton = findViewById<Button>(R.id.button)

        saveButton.setOnClickListener(){
            val darkMode = findViewById<Switch>(R.id.switch1)
            val date = findViewById<EditText>(R.id.editTextDate)
            val time = findViewById<EditText>(R.id.editTextTime)
            val langauge = findViewById<EditText>(R.id.editTextLanguage)

            // Write a message to the database
            val database = Firebase.database
            val user : String? = intent.getStringExtra("User")
            val userid : String = user.toString()
            val myRef = database.getReference("cv_preferences").child(userid)

            myRef.push().setValue("DarkModeOn")
            Toast.makeText(this,userid, Toast.LENGTH_LONG).show()
        }
    }


}
package com.webid.cvfresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth
        //call in UI elements and set type
//        val username: EditText
//        val password: EditText
//        val btn_login: Button
        //  val btn_signUp: Button


        // call in UI elements and cast type

        val email = findViewById<EditText>(R.id.et_user_name)
        val password = findViewById<EditText>(R.id.et_passsword)
        val btn_signUp = findViewById<Button>(R.id.btn_register)
        val btn_login = findViewById<Button>(R.id.btn_login)




        btn_signUp.setOnClickListener()
        {

            val entered_email = email.text.toString();
            val entered_password = password.text.toString();

            auth.createUserWithEmailAndPassword(entered_email,entered_password).addOnCompleteListener(this)
        {

            task->
            if (task.isSuccessful)
            {
                Toast.makeText(this,"Success",Toast.LENGTH_LONG).show()
            }



        }
            .addOnFailureListener(this)
            {
                exception->
                Toast.makeText(this,exception.message, Toast.LENGTH_LONG).show()
            }

        }













    }
}
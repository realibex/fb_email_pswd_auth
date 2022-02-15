package com.example.fb_email_pswd_auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        val joinBtn = findViewById<Button>(R.id.joinBtn)
        joinBtn.setOnClickListener {
            val email = findViewById<EditText>(R.id.emailArea)
            val pswd = findViewById<EditText>(R.id.pswdArea)

            Log.d("MAIN", email.text.toString())
            Log.d("MAIN", pswd.text.toString())

            auth.createUserWithEmailAndPassword(email.text.toString(), pswd.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(this,"성공",Toast.LENGTH_LONG).show()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this,"실패",Toast.LENGTH_LONG).show()
                    }
                }

        }

        val loginBtn = findViewById<Button>(R.id.loginBtn)

    }
}
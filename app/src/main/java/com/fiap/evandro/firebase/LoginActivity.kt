package com.fiap.evandro.firebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import android.widget.Toast
import com.fiap.evandro.firebase.extensions.getText
import android.R.attr.password
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseUser


class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        btCriar.setOnClickListener {
            mAuth.createUserWithEmailAndPassword(inputEmail.getText(), inputSenha.getText())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = mAuth.currentUser
                            //updateUI(user)
                        } else {
                            Toast.makeText(this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                            //updateUI(null)
                        }
                    }
        }

        btLogin.setOnClickListener {
            mAuth.signInWithEmailAndPassword(inputEmail.getText(), inputSenha.getText())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = mAuth.currentUser
                            //updateUI(user)
                        } else {
                            Toast.makeText(this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                            //updateUI(null)
                        }
                    }
        }

        btnSignout.setOnClickListener {
            mAuth.signOut()
        }

        btnSendEmail.setOnClickListener {
            val user = mAuth.currentUser

            user?.sendEmailVerification()?.addOnCompleteListener(this, OnCompleteListener { task ->
                if (task.isSuccessful){

                } else {

                }
            })
        }

    }
}

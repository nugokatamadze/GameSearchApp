package com.example.gamesearchapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth

class ResetPassFragmenti : Fragment(R.layout.fragment_pass_reset) {
    private lateinit var mail : EditText
    private lateinit var send : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mail=view.findViewById(R.id.resetmail)
        send=view.findViewById(R.id.resetmailpass)
        val navController = Navigation.findNavController(view)



        send.setOnClickListener{
            val email = mail.text.toString()

            if(email.isEmpty()){
                Toast.makeText(this@ResetPassFragmenti.requireActivity(), "Please, input Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@ResetPassFragmenti.requireActivity(), "Recovery link sent, Check Email", Toast.LENGTH_SHORT).show()
                        val logini = ResetPassFragmentiDirections.actionResetPassFragmentiToLoginFragmenti()
                        navController.navigate(logini)

                    }
                    else {
                        Toast.makeText(this@ResetPassFragmenti.requireActivity(), "There was an error", Toast.LENGTH_SHORT).show()
                    }

                }
        }
    }}
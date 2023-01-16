package com.example.gamesearchapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth



class RegisterFragmenti : Fragment(R.layout.fragment_register) {



    private lateinit var mail : EditText
    private lateinit var pass : EditText
    private lateinit var register : Button
    private lateinit var login : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        mail=view.findViewById(R.id.email2)
        pass=view.findViewById(R.id.pass2)
        register=view.findViewById(R.id.register2)
        login=view.findViewById(R.id.back)


        val navController = Navigation.findNavController(view)


        login.setOnClickListener{


            val action = RegisterFragmentiDirections.actionRegisterFragmentiToLoginFragmenti()
            navController.navigate(action)


        }



        register.setOnClickListener{

            val email = mail.text.toString()
            val password = pass.text.toString()

            if(email.isEmpty()) {
                Toast.makeText(this@RegisterFragmenti.requireActivity(), "Please, input your Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(password.isEmpty() || password.length < 5) {
                Toast.makeText(
                    this@RegisterFragmenti.requireActivity(),
                    "Input your password(min 4 letter)",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this@RegisterFragmenti.requireActivity(), "Registration, was successful", Toast.LENGTH_SHORT).show()
                        val goToProfile = RegisterFragmentiDirections.actionRegisterFragmentiToLoginFragmenti()
                        navController.navigate(goToProfile)

                    }
                    else{
                        Toast.makeText(this@RegisterFragmenti.requireActivity(), "There was an error", Toast.LENGTH_SHORT).show()
                    }

                }}}}
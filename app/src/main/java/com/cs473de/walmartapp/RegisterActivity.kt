package com.cs473de.walmartapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.cs473de.walmartapp.models.User

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun createAccount(view: View) {

        val fName=findViewById<EditText>(R.id.edt_fNameR).text.toString()
        val lName=findViewById<EditText>(R.id.edt_lNameR).text.toString()
        val email=findViewById<EditText>(R.id.edt_emailR).text.toString().lowercase()
        val pass=findViewById<EditText>(R.id.edt_passR).text.toString()
        if (fName.isNotBlank()&&lName.isNotBlank()&&email.isNotBlank()&&pass.isNotBlank()){
            val intentt= Intent(this,MainActivity::class.java)
            val bundle=Bundle()
            intentt.putExtra("user", User(6,fName,lName,email,email,"12345678"))
            setResult(1, intentt)

        }

    }
}
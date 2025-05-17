package com.example.topacademy_android

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.topacademy_android.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var emailEditText: EditText
    private lateinit var passEditText : EditText
    private lateinit var loginBtn: Button

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("email", emailEditText.text.toString())
        outState.putString("pass", passEditText.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailEditText = this.findViewById(R.id.EmailTextEdit)
        passEditText = this.findViewById(R.id.PasswordTextEdit)
        loginBtn = findViewById(R.id.LoginBtn)

        if (savedInstanceState != null) {
            val savedEmail = savedInstanceState.getString("email", "")
            val savedPass = savedInstanceState.getString("pass", "")
            emailEditText.setText(savedEmail)
            passEditText.setText(savedPass)
        }

        loginBtn.setOnClickListener{
            checkEmail()
            checkPass()
        }
    }

    private fun checkEmail() {
        val inputText = emailEditText.text.toString()

        if(inputText.isEmpty())
        {
            Toast.makeText(this@MainActivity,"Enter your email!", Toast.LENGTH_LONG).show()
        }
        else
        {
            if (Patterns.EMAIL_ADDRESS.matcher(inputText).matches()) {
                Toast.makeText(this@MainActivity, "Email Verified", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@MainActivity, "Enter valid Email address!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkPass()
    {
        val inputText = passEditText.text.toString()

        if(inputText.isEmpty())
        {
            Toast.makeText(this@MainActivity,"Enter your password!", Toast.LENGTH_LONG).show()
        }

        else
        {
            if(inputText.length > 6)
            {
                Toast.makeText(this@MainActivity,"Password valid!", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this@MainActivity,"Password must be longer than 6 symbols!", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun onButtonClick(view: View?) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
package com.example.topacademy_android.main.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.topacademy_android.R
import com.example.topacademy_android.databinding.ActivityMainBinding
import com.example.topacademy_android.home.presentation.ui.HomeActivity


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

        emailEditText = binding.EmailTextEdit
        passEditText = binding.PasswordTextEdit
        loginBtn = binding.LoginBtn

        if (savedInstanceState != null) {
            val savedEmail = savedInstanceState.getString("email", "")
            val savedPass = savedInstanceState.getString("pass", "")
            emailEditText.setText(savedEmail)
            passEditText.setText(savedPass)
        }

        loginBtn.setOnClickListener{
            val isEmailValid = checkEmail()
            val isPasswordValid = checkPass()

            if (isEmailValid && isPasswordValid) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }

    }

    private fun checkEmail() : Boolean {
        val inputText = emailEditText.text.toString()

        if(inputText.isEmpty())
        {
            Toast.makeText(this@MainActivity,"Enter your email!", Toast.LENGTH_LONG).show()
            return false
        }
        else
        {
            if (Patterns.EMAIL_ADDRESS.matcher(inputText).matches()) {
                Toast.makeText(this@MainActivity, getString(R.string.emailValid), Toast.LENGTH_LONG).show()
                return true
            } else {
                Toast.makeText(this@MainActivity, getString(R.string.emailInvalid), Toast.LENGTH_LONG).show()
                return false
            }
        }
    }

    private fun checkPass() : Boolean
    {
        val inputText = passEditText.text.toString()

        if(inputText.isEmpty())
        {
            Toast.makeText(this@MainActivity, getString(R.string.passwordEmpty), Toast.LENGTH_LONG).show()
            return false
        }

        else
        {
            if(inputText.length > 6)
            {
                Toast.makeText(this@MainActivity,
                    getString(R.string.passwordValid), Toast.LENGTH_SHORT).show()
                return true
            }
            else
            {
                Toast.makeText(this@MainActivity,
                    getString(R.string.passwordTooShort),
                    Toast.LENGTH_LONG).show()
                return false
            }
        }
    }

    fun onButtonClick(view: View?) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
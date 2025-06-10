package com.example.topacademy_android.main.presentation.ui

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.topacademy_android.R
import com.example.topacademy_android.databinding.ActivityMainBinding

class MainFragment : Fragment() {
    private var _binding: ActivityMainBinding? = null

    private val binding get() = _binding!!
    private lateinit var emailEditText: EditText
    private lateinit var passEditText: EditText
    private lateinit var loginBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ActivityMainBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailEditText = binding.EmailTextEdit
        passEditText = binding.PasswordTextEdit
        loginBtn = binding.LoginBtn

        if (savedInstanceState != null) {
            val savedEmail = savedInstanceState.getString("email", "")
            val savedPass = savedInstanceState.getString("pass", "")
            emailEditText.setText(savedEmail)
            passEditText.setText(savedPass)
        }

        loginBtn.setOnClickListener {
            val isEmailValid = checkEmail()
            val isPasswordValid = checkPass()

            if (isEmailValid && isPasswordValid) {
                findNavController().navigate(R.id.listFragment)
            }
        }
    }

    private fun checkEmail(): Boolean {
        val inputText = emailEditText.text.toString()

        if (inputText.isEmpty()) {
            Toast.makeText(requireContext(), getString(R.string.enterEmailText), Toast.LENGTH_LONG)
                .show()
            return false
        } else {
            if (Patterns.EMAIL_ADDRESS.matcher(inputText).matches()) {
                Toast.makeText(requireContext(), getString(R.string.emailValid), Toast.LENGTH_LONG)
                    .show()
                return true
            } else {
                Toast.makeText(
                    requireContext(), getString(R.string.emailInvalid),
                    Toast.LENGTH_LONG
                ).show()
                return false
            }
        }
    }

    private fun checkPass(): Boolean {
        val inputText = passEditText.text.toString()

        if (inputText.isEmpty()) {
            Toast.makeText(requireContext(), getString(R.string.passwordEmpty), Toast.LENGTH_LONG)
                .show()
            return false
        } else {
            if (inputText.length > 6) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.passwordValid), Toast.LENGTH_SHORT
                ).show()
                return true
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.passwordTooShort),
                    Toast.LENGTH_LONG
                ).show()
                return false
            }
        }
    }
}
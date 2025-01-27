package com.example.nit3213final

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nit3213final.databinding.ActivityLoginBinding
import com.example.nit3213final.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username.isNotBlank() && password.isNotBlank()) {
                authViewModel.login(username, password)
            } else {
                Toast.makeText(this, "Please enter the details in this field", Toast.LENGTH_SHORT).show()
            }
        }

        authViewModel.loginResult.observe(this) { result ->
            result.onSuccess {

                val intent = Intent(this, DashboardActivity::class.java).apply {
                    putExtra("keypass", it.keypass)
                }
                startActivity(intent)
                finish()
            }
            result.onFailure {
                Toast.makeText(this, "Login failed: ${it.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}


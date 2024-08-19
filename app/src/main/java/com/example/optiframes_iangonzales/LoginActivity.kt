package com.example.optiframes_iangonzales

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        // Referencias a los elementos del layout
        val userNameEditText: EditText = findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val loginButton: Button = findViewById(R.id.loginButton)
        val registerTextView: TextView = findViewById(R.id.registerTextView)
        val backButton: ImageButton = findViewById(R.id.button_back)

        // Acción para el botón de Ingresar
        loginButton.setOnClickListener {
            // Lógica para validar el nombre de usuario y la contraseña
            val username = userNameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Si el login es exitoso, navega al menú principal
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Aquí podrías mostrar un mensaje de error o hacer otra acción
            }
        }

        // Acción para el botón de Regresar
        backButton.setOnClickListener {
            // Navega de regreso al menú principal
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Acción para el texto de registro
        registerTextView.setOnClickListener {
            // Navega a la pantalla de registro
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }
}


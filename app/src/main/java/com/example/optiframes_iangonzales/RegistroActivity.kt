package com.example.optiframes_iangonzales

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        // Referencias a los elementos del layout
        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val newPasswordEditText: EditText = findViewById(R.id.newPasswordEditText)
        val reenterPasswordEditText: EditText = findViewById(R.id.reenterPasswordEditText)
        val registerButton: Button = findViewById(R.id.registerButton)
        val loginTextView: TextView = findViewById(R.id.loginTextView)
        val backButton: ImageButton = findViewById(R.id.button_back)

        // Acción para el botón de Registrarse
        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val newPassword = newPasswordEditText.text.toString()
            val reenteredPassword = reenterPasswordEditText.text.toString()

            if (username.isNotEmpty() && newPassword.isNotEmpty() && reenteredPassword.isNotEmpty()) {
                if (newPassword == reenteredPassword) {
                    // Aquí iría la lógica para registrar el usuario en la base de datos
                    // Por ahora, solo mostramos un mensaje de éxito y navegamos al menú principal

                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Acción para el botón de Regresar
        backButton.setOnClickListener {
            // Navega de regreso al menú principal
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Acción para el texto de Ingreso
        loginTextView.setOnClickListener {
            // Navega a la pantalla de login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}

package com.example.optiframes_iangonzales

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.producto)

        // Referencias a los elementos del layout
        val productImageView: ImageView = findViewById(R.id.productImageView)
        val productTitleTextView: TextView = findViewById(R.id.productTitleTextView)
        val productNameTextView: TextView = findViewById(R.id.productNameTextView)
        val productPriceTextView: TextView = findViewById(R.id.productPriceTextView)
        val productDescriptionTextView: TextView = findViewById(R.id.productDescriptionTextView)
        val addToCartButton: Button = findViewById(R.id.addToCartButton)
        val backButton: ImageButton = findViewById(R.id.button_back)

        // Setea la información del producto (ejemplo con datos estáticos)
        productImageView.setImageResource(R.drawable.arnette1) // Cambia "sunglasses_example" por el nombre de tu imagen en drawable
        productTitleTextView.text = "Lente de sol"
        productNameTextView.text = "Arnette - Modelo B10EC"
        productPriceTextView.text = "S/1,200.00"
        productDescriptionTextView.text = "Los lentes de sol protegen tus ojos de los rayos UV, reducen el deslumbramiento y mejoran la visión en condiciones de luz brillante."

        // Acción del botón "Agregar al carrito"
        addToCartButton.setOnClickListener {
            // Aquí iría la lógica para agregar el producto al carrito
            // Actualmente, se puede mostrar un mensaje o actualizar una lista de productos en el carrito
        }

        // Acción para el botón de Regresar
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

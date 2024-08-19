package com.example.optiframes_iangonzales

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CarritoActivity : AppCompatActivity() {

        //private lateinit var productListLayout: LinearLayout
        //private lateinit var totalAmountTextView: TextView
    //private var totalAmount: Double = 2400.00 // Ejemplo de un total inicial

    //override fun onCreate(savedInstanceState: Bundle?) {
    //super.onCreate(savedInstanceState)
    //setContentView(R.layout.carrito)

        // Referencias a los elementos del layout
        //val backButton: ImageButton = findViewById(R.id.button_back)
    //val payButton: Button = findViewById(R.id.payButton)
    //productListLayout = findViewById(R.id.productListLayout)
    //totalAmountTextView = findViewById(R.id.totalAmountTextView)

        // Acción para el botón de Regresar
        //backButton.setOnClickListener {
    //val intent = Intent(this, MainActivity::class.java)
    //startActivity(intent)
    //}

        // Acción para el botón de Pagar
        //payButton.setOnClickListener {
        //    val intent = Intent(this, PagoActivity::class.java)
        //    startActivity(intent)
        //}

        // Actualizar el total
    //updateTotalAmount()

        // Acción para eliminar productos
    //setDeleteButtonActions()
    }

//private fun addProductToCart(name: String, price: Double, imageResId: Int) {
//val productView = layoutInflater.inflate(R.layout.carrito, productListLayout, false)

//val productImageView: ImageView = productView.findViewById(R.id.productImageView)
//val productNameTextView: TextView = productView.findViewById(R.id.productNameTextView)
//val productPriceTextView: TextView = productView.findViewById(R.id.productPriceTextView)
//val deleteButton: ImageButton = productView.findViewById(R.id.deleteButton)

// productImageView.setImageResource(imageResId)
//productNameTextView.text = name
//productPriceTextView.text = "S/$price"
//deleteButton.tag = price

//productListLayout.addView(productView)
//}

//private fun updateTotalAmount() {
//totalAmountTextView.text = "S/$totalAmount"
//}
//private fun setDeleteButtonActions() {
//for (i in 0 until productListLayout.childCount) {
//val productView = productListLayout.getChildAt(i)
//val deleteButton: ImageButton = productView.findViewById(R.id.deleteButton)
//deleteButton.setOnClickListener {
//val price = it.tag as Double
//productListLayout.removeView(productView)
//totalAmount -= price
//updateTotalAmount()
//}
//}
//}
//}

package com.example.optiframes_iangonzales

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.optiframes_iangonzales.api.RetrofitClient
import com.example.optiframes_iangonzales.model.Producto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var productContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_principal)

        // Log para verificar que onCreate está siendo llamado
        Log.d("MainActivity", "onCreate ejecutado")

        // Referencias a los elementos del layout
        val textViewWelcome: TextView = findViewById(R.id.textView_bienvenida)
        val imageViewCarrito: ImageView = findViewById(R.id.carritoImageView)
        val imageViewUsuario: ImageView = findViewById(R.id.usuarioImageView)

        // Referencia al contenedor de productos
        productContainer = findViewById(R.id.productContainer)

        // Obtener el nombre del usuario que inició sesión
        val userName = intent.getStringExtra("USER_NAME") ?: "Inicie sesión"

        // Actualizar el texto de bienvenida
        textViewWelcome.text = if (userName != "Inicie sesión") {
            "Bienvenido, $userName"
        } else {
            "Inicie sesión"
        }

        // Configurar el botón de carrito para redirigir a la actividad de carrito
        imageViewCarrito.setOnClickListener {
            val intent = Intent(this, CarritoActivity::class.java)
            startActivity(intent)
        }

        // Configurar el botón de usuario para redirigir a la actividad de login
        imageViewUsuario.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Llamada para obtener los productos desde la API
        getProductsFromApi()
    }

    private fun getProductsFromApi() {
        val apiService = RetrofitClient.apiService
        Log.d("MainActivity", "Llamando a la API para obtener productos")

        apiService.getProductos().enqueue(object : Callback<List<Producto>> {
            override fun onResponse(call: Call<List<Producto>>, response: Response<List<Producto>>) {
                if (response.isSuccessful) {
                    val productos = response.body()
                    Log.d("API Response", productos.toString())
                    if (productos != null && productos.isNotEmpty()) {
                        displayProducts(productos.filter { it.tipo == "solar" }.take(4))
                    }
                } else {
                    Log.e("API Error", "Error en la respuesta: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Producto>>, t: Throwable) {
                // Manejo del error
                Log.e("MainActivity", "Error al obtener los productos", t)
            }
        })
    }

    private fun displayProducts(products: List<Producto>) {
        Log.d("DisplayProducts", "Mostrando productos: ${products.size}")

        var row: LinearLayout? = null
        for ((index, producto) in products.withIndex()) {
            if (index % 2 == 0) {
                row = LinearLayout(this).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        setMargins(10, 10, 10, 10)
                    }
                    orientation = LinearLayout.HORIZONTAL
                }
                productContainer.addView(row)
            }

            val productView: View = LayoutInflater.from(this).inflate(R.layout.product_item, row, false)

            val productImageView: ImageView = productView.findViewById(R.id.imageView_producto)
            val productNameTextView: TextView = productView.findViewById(R.id.textView_producto_nombre)
            val productMarcaTextView: TextView = productView.findViewById(R.id.textView_producto_marca)
            val productPrecioTextView: TextView = productView.findViewById(R.id.textView_producto_precio)

            Log.d("ProductData", "Producto: ${producto.nombre_producto}, ${producto.marca}, S/${producto.precio}")

            // Carga los datos en los TextViews
            productNameTextView.text = producto.nombre_producto
            productMarcaTextView.text = producto.marca
            productPrecioTextView.text = "S/${producto.precio}"

            // Para las imágenes, verifica si tienes un recurso o si las estás cargando desde un blob o URL.
            // Usa Glide o Picasso si es necesario.
            productImageView.setImageResource(R.drawable.ic_launcher_foreground)  // Temporal para probar

            row?.addView(productView)
        }
    }

}

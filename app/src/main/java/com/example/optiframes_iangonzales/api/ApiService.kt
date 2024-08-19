package com.example.optiframes_iangonzales.api

import com.example.optiframes_iangonzales.model.Usuario
import com.example.optiframes_iangonzales.model.Carrito
import com.example.optiframes_iangonzales.model.Producto
import com.example.optiframes_iangonzales.model.HistorialCompra
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("obtener_productos.php")
    fun getProductos(): Call<List<Producto>>

    @POST("agregar_carrito.php")
    fun addProductoAlCarrito(@Body carrito: Carrito): Call<Void>

    @GET("historial_compras.php")
    fun getHistorialCompras(@Query("usuario_id") usuarioId: Int): Call<List<HistorialCompra>>

    @POST("registrar_usuario.php")
    fun registrarUsuario(@Body usuario: Usuario): Call<Void>

    @POST("login_usuario.php")
    fun loginUsuario(@Body usuario: Usuario): Call<Boolean>
}

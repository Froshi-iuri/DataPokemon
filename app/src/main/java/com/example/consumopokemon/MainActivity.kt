package com.example.consumopokemon

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {

            // 3. Llamar a la API (Retrofit hace todo el trabajo)
            val response = RetrofitClient.api.getPokemonList(limit = 20)


            val nombres = response.results.joinToString(", ") { it.name }
            Toast.makeText(this@MainActivity, nombres, Toast.LENGTH_LONG).show()
        }

    }
}
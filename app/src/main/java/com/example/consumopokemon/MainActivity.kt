package com.example.consumopokemon

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.consumopokemon.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {

            // 3. Llamar a la API (Retrofit hace todo el trabajo)
            val response = RetrofitClient.api.getPokemonList(limit = 20)


            val nombres = response.results.joinToString(", ") { it.name }
            Toast.makeText(this@MainActivity, nombres, Toast.LENGTH_LONG).show()
        }

        val nombres = response.results.map { it.name }

        val adapter = ArrayAdapter(
            this@MainActivity,
            R.layout.simple_list_item_1,
            nombres
        )


        binding.listPokemon.adapter = adapter
    }
}
}
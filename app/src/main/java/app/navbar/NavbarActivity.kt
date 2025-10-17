package app.navbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.android_inicializacion.R
import com.example.android_inicializacion.databinding.ActivityNavbarBinding

class NavbarActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNavbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.nav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> replaceFragment(Home())
                R.id.settings -> replaceFragment(Settings())
                R.id.profile -> replaceFragment(Profile())
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.contenedor,fragment)
        fragmentTransaction.commit()
    }
}
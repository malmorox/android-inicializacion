package app.navbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.android_inicializacion.R
import com.example.android_inicializacion.databinding.ActivityNavbarBinding

class NavbarActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNavbarBinding
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home(), 0)

        binding.nav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> replaceFragment(Home(), 0)
                R.id.settings -> replaceFragment(Settings(), 1)
                R.id.profile -> replaceFragment(Profile(), 2)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment, newIndex: Int) {
        val transaction = supportFragmentManager.beginTransaction()

        if (newIndex > currentIndex) {
            transaction.setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
        } else if (newIndex < currentIndex) {
            transaction.setCustomAnimations(
                R.anim.slide_in_left,
                R.anim.slide_out_right,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
        }

        transaction.replace(R.id.contenedor, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

        currentIndex = newIndex
    }
}
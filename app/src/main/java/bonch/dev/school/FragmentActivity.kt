package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FragmentActivity : AppCompatActivity() {
val fm = supportFragmentManager
    private var firstFragment=FirstFragment()
    private var secondFragment=SecondFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        fm.beginTransaction().add(R.id.fg,firstFragment).commit()
    }
    fun replaceFragment(){
            fm.beginTransaction().replace(R.id.fg,secondFragment).addToBackStack("fragment_first").commit()

    }

}

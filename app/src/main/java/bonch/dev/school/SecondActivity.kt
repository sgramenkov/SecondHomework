package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var textView:TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textView = findViewById(R.id.text_view)
        var getBool = intent.getBooleanExtra("enabling",false)
        var getCount = intent.getIntExtra("count",0)
        var getText =  intent.getStringExtra("text")
        textView.setText("Кнопка была нажата?\n$getBool\nКоличество нажатий на кнопку:\n$getCount\nВведенный текст:\n$getText")

    }
}

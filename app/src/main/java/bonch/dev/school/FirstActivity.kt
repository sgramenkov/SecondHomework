package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FirstActivity : AppCompatActivity() {
    private lateinit var indicatorButton:Button
    private lateinit var counterButton:Button
    private lateinit var textField:EditText
    private lateinit var nextActivityButton:Button
    private var counter=Counter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        indicatorButton=findViewById(R.id.indicator_button)
        counterButton=findViewById(R.id.counter_button)
        textField=findViewById(R.id.text_field)
        nextActivityButton=findViewById(R.id.next_activity_button)

        val tapAmount: Int = savedInstanceState?.getInt("TAP_AMOUNT") ?: 0

        Log.e("COUNT", tapAmount.toString())

        counterButton.text = ("$tapAmount taps")

        counter = Counter(tapAmount)

        indicatorButton.setOnClickListener{
            it.isEnabled=false
        }

        counterButton.setOnClickListener{
            counter.increment()
            counterButton.text = ("${counter.currentCount} taps")
        }
        nextActivityButton.setOnClickListener{
            val intent=Intent(this,SecondActivity::class.java)
            intent.putExtra("enabling",!indicatorButton.isEnabled)
            intent.putExtra("count",counter.currentCount)
            intent.putExtra("text",textField.text.toString())
            startActivity(intent)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("TAP_AMOUNT",counter.currentCount)
    }
}

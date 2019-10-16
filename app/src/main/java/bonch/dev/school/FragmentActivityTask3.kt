package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FragmentActivityTask3 : AppCompatActivity() {

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var textField: EditText
    private lateinit var nextActivityButton: Button
    private lateinit var attachFragmentButton:TextView
    private var counter=Counter()
    val fm=supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_task3)

        indicatorButton=findViewById(R.id.indicator_button)
        counterButton=findViewById(R.id.counter_button)
        textField=findViewById(R.id.text_field)
        nextActivityButton=findViewById(R.id.next_activity_button)
        attachFragmentButton=findViewById(R.id.attach_fragment_button)

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
            val intent= Intent(this,MyFragment::class.java)
            intent.putExtra("enabling",!indicatorButton.isEnabled)
            intent.putExtra("count",counter.currentCount)
            intent.putExtra("text",textField.text.toString())
            startActivity(intent)
        }
        attachFragmentButton.setOnClickListener(){
            addFragment()
        }
    }
    fun addFragment(){
        val myFragment=MyFragment()
        fm.beginTransaction().replace(R.id.fragment_container,myFragment).commit()
    }
    fun getintent():String{
        var getBool=!indicatorButton.isEnabled
        var getCount = counter.currentCount
        var getText = textField.text.toString()
        return ("Кнопка была нажата?\n$getBool\nКоличество нажатий на кнопку:\n$getCount\nВведенный текст:\n$getText")
    }
}

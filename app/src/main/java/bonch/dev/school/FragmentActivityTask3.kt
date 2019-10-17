package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
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
        initializeViews()
        setListeners()

        val tapAmount: Int = savedInstanceState?.getInt("TAP_AMOUNT") ?: 0
        setInstanceState(savedInstanceState)

        Log.e("COUNT", tapAmount.toString())

        counterButton.text = ("$tapAmount taps")

        counter = Counter(tapAmount)


    }
    fun addFragment(){
        val myFragment=MyFragment()
        fm.beginTransaction().replace(R.id.fragment_container,myFragment).commit()
    }
    fun getintent(): String {
        val getBool=!indicatorButton.isEnabled
        val getCount = counter.currentCount
        val getText = textField.text.toString()
        return ("Кнопка была нажата?\n$getBool\nКоличество нажатий на кнопку:\n$getCount\nВведенный текст:\n$getText")
    }
    private fun setInstanceState(savedInstanceState: Bundle?){
        if (savedInstanceState == null) {
            counter = Counter()
        } else {
            counter = Counter(savedInstanceState.getInt("TAP_AMOUNT"))
            indicatorButton.isEnabled = savedInstanceState.getBoolean("enabling")
            //Data type of <EditText> is "editable", not String
            textField.text = Editable.Factory.getInstance().newEditable(savedInstanceState.getString("text"))
        }
        counterButton.text = "${counter.currentCount}"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("TAP_AMOUNT", counter.currentCount)
        outState.putBoolean("enabling", !indicatorButton.isEnabled)
        outState.putString("text", textField.text.toString())
    }
    fun initializeViews(){
        indicatorButton=findViewById(R.id.indicator_button)
        counterButton=findViewById(R.id.counter_button)
        textField=findViewById(R.id.text_field)
        nextActivityButton=findViewById(R.id.next_activity_button)
        attachFragmentButton=findViewById(R.id.attach_fragment_button)
    }
    fun setListeners(){
        indicatorButton.setOnClickListener{
            it.isEnabled=false
        }

        counterButton.setOnClickListener{
            counter.increment()
            counterButton.text = ("${counter.currentCount} taps")
        }
        nextActivityButton.setOnClickListener{
            val intent= Intent(this,SecondActivity::class.java)
            intent.putExtra("enabling",!indicatorButton.isEnabled)
            intent.putExtra("count",counter.currentCount)
            intent.putExtra("text",textField.text.toString())
            startActivity(intent)
        }
        attachFragmentButton.setOnClickListener(){
            addFragment()
        }
    }
}

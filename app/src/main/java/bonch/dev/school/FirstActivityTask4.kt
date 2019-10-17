package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class FirstActivityTask4 : AppCompatActivity() {
private lateinit var SecondActivityButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_task4)
        initializeViews()
        setListener()
    }
    fun initializeViews(){
        SecondActivityButton=findViewById(R.id.second_activity_button)
    }
    fun setListener(){
        SecondActivityButton.setOnClickListener(){
            val intent=Intent(this,SecondActivityTask4::class.java)
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var text=data?.getStringExtra("data")
        Toast.makeText(this,intent.getStringExtra("data"),Toast.LENGTH_LONG).show()
        if (text!=null){
            Toast.makeText(this, "Кнопка была нажата", Toast.LENGTH_LONG).show()

        }

         else Toast.makeText(this,"Кнопка не была нажата",Toast.LENGTH_LONG).show()
    }
    }


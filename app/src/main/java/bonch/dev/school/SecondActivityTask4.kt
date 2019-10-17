package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivityTask4 : AppCompatActivity() {
private lateinit var finishButton:Button
    var isClicked:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_task4)
        initializeViews()
        setListener()

    }
    fun initializeViews(){
        finishButton=findViewById(R.id.finish_button)
    }
    fun setListener(){
        finishButton.setOnClickListener(){
            isClicked=1
            val intent=Intent(this,FirstActivityTask4::class.java)
            val a:String="kdsjhflsdhjfl"
            intent.putExtra("data",isClicked.toString())
            setResult(RESULT_OK, intent)

            finish()
        }
    }


}

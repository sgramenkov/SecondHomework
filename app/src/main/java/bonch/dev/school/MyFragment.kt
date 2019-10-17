package bonch.dev.school

import android.content.Intent
import android.content.Intent.getIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.*

class MyFragment() : Fragment() {
private lateinit var textView:TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_my_fragment,container,false)
        textView=view.findViewById(R.id.text_viewfg)

        textView.setText((activity as FragmentActivityTask3).getintent())

        return view
    }
}

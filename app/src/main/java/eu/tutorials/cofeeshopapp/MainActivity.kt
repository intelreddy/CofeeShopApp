package eu.tutorials.cofeeshopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        var qty:Int = 0;
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val qtySold: TextView = findViewById(R.id.qtySold)
        val increButton = findViewById<Button>(R.id.btnPlus)
        increButton.setOnClickListener {
            qty += 1
            qtySold.text = qty.toString()
        }
    }

}
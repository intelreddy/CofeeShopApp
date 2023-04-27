package eu.tutorials.cofeeshopapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var qty:Int = 0;
        var price:Int = 0;
        val qtySold: TextView = findViewById(R.id.qtySelected)
        val bookPrice: TextView = findViewById(R.id.bookPrice)
        val resName: TextView = findViewById(R.id.lblName)
        val name: TextView = findViewById(R.id.txtName)
        val resCategory: TextView = findViewById(R.id.lblCategorySelected)
        val resQty: TextView = findViewById(R.id.lblQtySelected)
        val resPrice: TextView = findViewById(R.id.lblPriceSelected)
        val resThanks: TextView = findViewById(R.id.lblThanks)

        val plusButton = findViewById<Button>(R.id.btnPlus)
        val minusButton = findViewById<Button>(R.id.btnMinus)
        val order = findViewById<Button>(R.id.btnOrder)
        val cancel = findViewById<Button>(R.id.btnCancel)

        val fantasyCheck = findViewById<CheckBox>(R.id.fantasy_checkbox)
        val thrillerCheck = findViewById<CheckBox>(R.id.thriller_checkbox)

        val editTextName = findViewById<EditText>(R.id.editTextName)

        qtySold.text = "0"
        plusButton.setOnClickListener {
            if (editTextName.text.isEmpty()){
                Toast.makeText(applicationContext,"Please enter your name",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

           if(fantasyCheck.isChecked || thrillerCheck.isChecked){
               qty += 1
               qtySold.text = qty.toString()
               price = if(fantasyCheck.isChecked) 10*qty
               else 5*qty
               bookPrice.text = "$$price"
           }else{
               Toast.makeText(applicationContext,"Please select Category",Toast.LENGTH_SHORT).show()
               return@setOnClickListener
           }
        }

        minusButton.setOnClickListener {
            if(fantasyCheck.isChecked || thrillerCheck.isChecked){
                if (qty != 0) qty-=1
                qtySold.text = qty.toString()
                price = if(fantasyCheck.isChecked) 10*qty
                else 5*qty
                bookPrice.text = "$$price"
            }
        }
        fantasyCheck.setOnClickListener {
            if (fantasyCheck.isChecked){
                thrillerCheck.isChecked = false
                bookPrice.text = ""
                price = 0
            }else if(!thrillerCheck.isChecked) {
                qty  = 0
            }
            qtySold.text = ""
        }
        thrillerCheck.setOnClickListener{
            if (thrillerCheck.isChecked){
                fantasyCheck.isChecked = false
                bookPrice.text = ""
                price = 0
            }else if(!fantasyCheck.isChecked) {
                qty = 0
            }
            qtySold.text = ""
        }
        order.setOnClickListener {
            if (qty == 0){
                Toast.makeText(applicationContext,"Please select the quantity",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            resName.text = "Name: " + editTextName.text
            when {
                fantasyCheck.isChecked -> resCategory.text = "Category: " + fantasyCheck.text.toString()
                else -> resCategory.text = "Category: " + thrillerCheck.text.toString()
            }
            resPrice.text = "Price: " + bookPrice.text
            resQty.text = "Qty: " + " " + qtySold.text
            resThanks.text = "Thanks for your order"
        }
        cancel.setOnClickListener {
            resName.text = ""
            resPrice.text = ""
            resQty.text = ""
            resCategory.text = ""
            resCategory.text = ""
            price = 0
            qty = 0
            bookPrice.text = ""
            qtySold.text = ""
            resThanks.text = ""
        }
    }

}
package com.example.budgettrackerapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class AddTransactionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_transaction)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val addTransactionBtn=findViewById<Button>(R.id.addTransactionBtn)
        val labelInput=findViewById<TextInputEditText>(R.id.labelInput)
        val amountInput=findViewById<TextInputEditText>(R.id.amountInput)
        val descriptionInput=findViewById<TextInputEditText>(R.id.descriptionInput)


        val labelLayout=findViewById<TextInputLayout>(R.id.labellayout)
        val amountLayout=findViewById<TextInputLayout>(R.id.amountlayout)
        val descriptionLayout=findViewById<TextInputLayout>(R.id.descriptionlayout)

        val closeBtn=findViewById<ImageButton>(R.id.closebtn)

        labelInput.addTextChangedListener {
            if (it!!.count()>0)
                labelLayout.error=null
        }

        amountInput.addTextChangedListener {
            if (it!!.count()>0)
                amountLayout.error=null
        }
        addTransactionBtn.setOnClickListener {
            val label=labelInput.text.toString()
            val ammount=amountInput.text.toString().toDoubleOrNull()

            if(label.isEmpty()){
                labelLayout.error="Please Enter a valid Label"
            }
            if (ammount==null){
                amountLayout.error="Please Enter a valid Amount"
            }

        }
        closeBtn.setOnClickListener {
            finish()
        }
    }

}
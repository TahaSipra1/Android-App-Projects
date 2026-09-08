package com.example.budgettrackerapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
            val amount=amountInput.text.toString().toDoubleOrNull()
            val description=descriptionInput.text.toString()

            if(label.isEmpty()){
                labelLayout.error="Please Enter a valid Label"
            }
            else if(amount==null){
                amountLayout.error="Please Enter a valid Amount"
            }
            else{
                val transaction= Transaction(0,label,amount,description)
                insert(transaction)
            }

        }
        closeBtn.setOnClickListener {
            finish()
        }
    }
    private fun insert(transaction: Transaction){
        val db= Room.databaseBuilder(this,
            AppDatebase::class.java,"transactions").build()

        GlobalScope.launch {
            db.transactionDao().insertAll(transaction)
            finish()        }
    }

}
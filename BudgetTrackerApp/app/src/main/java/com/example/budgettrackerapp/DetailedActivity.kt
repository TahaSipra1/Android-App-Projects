package com.example.budgettrackerapp

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailedActivity : AppCompatActivity() {
    private lateinit var transaction: Transaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootview)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val updateTransactionBtn=findViewById<Button>(R.id.updateTransactionbtn)
        val labelInput=findViewById<TextInputEditText>(R.id.labelInput)
        val amountInput=findViewById<TextInputEditText>(R.id.amountInput)
        val descriptionInput=findViewById<TextInputEditText>(R.id.descriptionInput)


        val labelLayout=findViewById<TextInputLayout>(R.id.labellayout)
        val amountLayout=findViewById<TextInputLayout>(R.id.amountlayout)
        val descriptionLayout=findViewById<TextInputLayout>(R.id.descriptionlayout)

        val closeBtn=findViewById<ImageButton>(R.id.closebtn)

        transaction=intent.getSerializableExtra("transaction") as Transaction
        labelInput.setText(transaction.label)
        amountInput.setText(transaction.amount.toString())
        descriptionInput.setText(transaction.descriptioon)


        val rootView=findViewById<ConstraintLayout>(R.id.rootview)

        rootView.setOnClickListener {
            this.window.decorView.clearFocus()

            val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken,0)
        }

        labelInput.addTextChangedListener {
            updateTransactionBtn.visibility= View.VISIBLE
            if (it!!.count()>0)
                labelLayout.error=null
        }

        amountInput.addTextChangedListener {
            updateTransactionBtn.visibility= View.VISIBLE

            if (it!!.count()>0)
                amountLayout.error=null
        }
        descriptionInput.addTextChangedListener {
            updateTransactionBtn.visibility= View.VISIBLE

        }
        updateTransactionBtn.setOnClickListener {
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
                val transaction= Transaction(transaction.id,label,amount,description)
                update(transaction)
            }

        }
        closeBtn.setOnClickListener {
            finish()
        }
    }
    private fun update(transaction: Transaction){
        val db= Room.databaseBuilder(this,
            AppDatebase::class.java,"transactions").build()

        GlobalScope.launch {
            db.transactionDao().update(transaction)
            finish()        }
    }

}
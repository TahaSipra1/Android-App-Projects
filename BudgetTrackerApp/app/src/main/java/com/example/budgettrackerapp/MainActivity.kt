package com.example.budgettrackerapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recycleview: RecyclerView
    private lateinit var transactions: List<Transaction>
    private lateinit var transactionAdapter: TransactionAdapter
    private lateinit var LinearLayoutManager: LinearLayoutManager
    private lateinit var db: AppDatebase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        transactions=arrayListOf()

        val addBtn=findViewById<FloatingActionButton>(R.id.addBtn)

        transactionAdapter= TransactionAdapter(transactions)
        LinearLayoutManager= LinearLayoutManager(this)

        db= Room.databaseBuilder(this,
            AppDatebase::class.java,"transactions").build()

        recycleview=findViewById(R.id.RecyclerView)

        recycleview.apply{
            adapter=transactionAdapter
            layoutManager=LinearLayoutManager
        }

       
        addBtn.setOnClickListener {
            val intent= Intent(this, AddTransactionActivity::class.java)
            startActivity(intent)
        }
    }
    private fun fetchAll(){
        GlobalScope.launch {

            transactions=db.transactionDao().getAll()

            runOnUiThread {
                updateDashBoard()
                transactionAdapter.setData(transactions)
            }
        }

    }
    private fun updateDashBoard(){
        val totalAmount=transactions.map { it.amount }.sum()
        val budgetAmount=transactions.filter { it.amount>0 }.map { it.amount }.sum()
        val expenseAmount=totalAmount-budgetAmount

        val balance=findViewById<TextView>(R.id.tvbalance)
        val budget=findViewById<TextView>(R.id.budget)
        val expenses=findViewById<TextView>(R.id.tvexpense)
        balance.text="$ %.2f".format(totalAmount)
        budget.text="$ %.2f".format(budgetAmount)
        expenses.text="$ %.2f".format(expenseAmount)
    }

    override fun onResume() {
        super.onResume()
        fetchAll()
    }
}
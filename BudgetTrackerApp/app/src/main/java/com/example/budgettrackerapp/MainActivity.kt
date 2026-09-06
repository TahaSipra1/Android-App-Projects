package com.example.budgettrackerapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recycleview: RecyclerView
    private lateinit var transactions: ArrayList<Transaction>
    private lateinit var transactionAdapter: TransactionAdapter
    private lateinit var LinearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        transactions=arrayListOf(
            Transaction("weekend budget",400.00),
            Transaction("Bananas",-4.00),
            Transaction("Gasolinet",-40.90),
            Transaction("Breakfast",-9.99),
            Transaction("water bottles",-4.00),
            Transaction("sncream",-8.00),
            Transaction("car Park",-15.00),


        )

        transactionAdapter= TransactionAdapter(transactions)
        LinearLayoutManager= LinearLayoutManager(this)

        recycleview=findViewById(R.id.RecyclerView)

        recycleview.apply{
            adapter=transactionAdapter
            layoutManager=LinearLayoutManager
        }
        updateDashBoard()
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
}
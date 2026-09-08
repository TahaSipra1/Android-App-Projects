package com.example.budgettrackerapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Transaction::class), version = 1)
abstract class AppDatebase: RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
}
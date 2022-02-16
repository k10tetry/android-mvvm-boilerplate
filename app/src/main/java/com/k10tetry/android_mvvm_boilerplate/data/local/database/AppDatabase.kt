package com.k10tetry.android_mvvm_boilerplate.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.k10tetry.android_mvvm_boilerplate.data.local.database.dao.UserDao
import com.k10tetry.android_mvvm_boilerplate.data.local.database.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
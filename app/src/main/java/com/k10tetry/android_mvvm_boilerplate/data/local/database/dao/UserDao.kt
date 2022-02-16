package com.k10tetry.android_mvvm_boilerplate.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.k10tetry.android_mvvm_boilerplate.data.local.database.entity.User
import io.reactivex.rxjava3.core.Single

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User): Single<Unit>

    @Query("SELECT * FROM user")
    fun getAll(): Single<List<User>>

}
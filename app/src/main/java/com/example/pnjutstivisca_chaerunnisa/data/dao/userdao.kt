package com.example.pnjutstivisca_chaerunnisa.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.pnjutstimuhammad_arifandi1.data.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Query("SELECT * FROM User WHERE nim IN (:nims)")
    fun loadAllByNim(nims: IntArray): List<User>

    @Query("SELECT * FROM User WHERE nim = :nim")
    fun get(nim: Int): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

    @Update
    fun update(user: User)
}
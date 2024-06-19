package com.example.bottomnav.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(event: NewEvent)

    @Update
    suspend fun update(event: NewEvent)

    @Delete
    suspend fun delete(event: NewEvent)

    @Query("SELECT * from events WHERE id = :id")
    fun getEvent(id: Int): Flow<NewEvent>

    @Query("SELECT * from events")
    fun getAllEvents(): Flow<List<NewEvent>>

}
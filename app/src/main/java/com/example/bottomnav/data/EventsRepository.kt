package com.example.bottomnav.data

import kotlinx.coroutines.flow.Flow

interface EventsRepository {

    fun getAllEventsStream(): Flow<List<NewEvent>>

    fun getEventStream(id: Int): Flow<NewEvent?>

    suspend fun addEvent(event: NewEvent)

    suspend fun deleteEvent(event: NewEvent)

    suspend fun updateEvent(event: NewEvent)


}
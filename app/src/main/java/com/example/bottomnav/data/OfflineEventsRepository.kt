package com.example.bottomnav.data

import kotlinx.coroutines.flow.Flow

class OfflineEventsRepository(private val eventDao: EventDao) : EventsRepository {
    override fun getAllEventsStream(): Flow<List<NewEvent>> = eventDao.getAllEvents()

    override fun getEventStream(id: Int): Flow<NewEvent?> = eventDao.getEvent(id)
    override suspend fun addEvent(event: NewEvent) = eventDao.insert(event)

    override suspend fun deleteEvent(event: NewEvent) = eventDao.delete(event)

    override suspend fun updateEvent(event: NewEvent) = eventDao.update(event)


}
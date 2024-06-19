package com.example.bottomnav.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val eventsRepository: EventsRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineEventsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [EventsRepository]
     */
    override val eventsRepository: EventsRepository by lazy {
        OfflineEventsRepository(EventDatabase.getDatabase(context).eventDao())
    }
}
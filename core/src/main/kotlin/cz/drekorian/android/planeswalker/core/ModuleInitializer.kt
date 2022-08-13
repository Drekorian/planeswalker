package cz.drekorian.android.planeswalker.core

import android.app.Application

/**
 * This interface defines the common API for module initializers.
 */
interface ModuleInitializer {

    /**
     * Initializes a module eagerly.
     *
     * All initialization that need to be done ASAP should be implemented here. Use sparingly.
     *
     * @param application Planeswalker's Assistant application instance
     */
    fun initializeEager(application: Application) {
    }

    /**
     * Initializes a module lazily.
     *
     * All initializations that can be postponed should be implemented here.
     *
     * @param application Planeswalker's Assistant application instance.
     */
    fun initializeLazy(application: Application) {
    }
}

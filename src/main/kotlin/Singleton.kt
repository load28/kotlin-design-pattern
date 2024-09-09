package org.example

class Singleton private constructor() {
    companion object {
        @Volatile
        private var instance: Singleton? = null

        fun createInstance() = instance ?: synchronized(this) {
            instance ?: Singleton().also { instance = it }
        }
    }

    fun print() {
        println("Singleton")
    }
}


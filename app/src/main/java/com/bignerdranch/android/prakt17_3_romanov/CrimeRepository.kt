package com.bignerdranch.android.prakt17_3_romanov

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.util.UUID

private const val DATABASE_NAME = "crimedatabase"
class CrimeRepository private constructor(context: Context) {
    private val database: CrimeDatabase = Room.databaseBuilder(
        context.applicationContext,
        CrimeDatabase::class.java,
        DATABASE_NAME
    ).addMigrations(migration_1_2, migration_2_3).build()

    private val crimeDao = database.crimeDao()


    fun getCrimes(): List<Crime> = crimeDao.getCrimes()
    fun getCrime(id: UUID): Crime = crimeDao.getCrime(id)
    fun addCrime(crime: Crime) = crimeDao.addCrime(crime)
    fun updateCrime(crime: Crime) = crimeDao.updateCrime(crime)


    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null)
            {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository {
            return INSTANCE ?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}
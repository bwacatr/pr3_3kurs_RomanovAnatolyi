package com.bignerdranch.android.prakt17_3_romanov

import android.app.Application

class CriminalIntentApplication: Application() {
    override fun onCreate(){
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}
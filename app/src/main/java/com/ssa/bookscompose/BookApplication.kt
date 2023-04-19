package com.ssa.bookscompose

import android.app.Application
import com.ssa.bookscompose.data.AppContainer
import com.ssa.bookscompose.data.DefaultAppContainer

class BookApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
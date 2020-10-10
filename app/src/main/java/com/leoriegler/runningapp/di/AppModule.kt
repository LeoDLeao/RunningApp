package com.leoriegler.runningapp.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.leoriegler.runningapp.db.RunningDatabase
import com.leoriegler.runningapp.other.Constants.KEY_FIRST_TIME_TOOGLE
import com.leoriegler.runningapp.other.Constants.KEY_NAME
import com.leoriegler.runningapp.other.Constants.KEY_WEIGHT
import com.leoriegler.runningapp.other.Constants.RUNNING_DATABASE_NAME
import com.leoriegler.runningapp.other.Constants.SHARED_PREFERENCES_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(db: RunningDatabase) = db.getRunDao()

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext app: Context) =
        app.getSharedPreferences(SHARED_PREFERENCES_NAME,MODE_PRIVATE)


    @Singleton
    @Provides
    fun provideName(sharedPrefs: SharedPreferences) = sharedPrefs.getString(KEY_NAME,"") ?: ""

    @Singleton
    @Provides
    fun provideWeight(sharedPrefs: SharedPreferences) = sharedPrefs.getFloat(KEY_WEIGHT,70f)

    @Singleton
    @Provides
    fun providesFirstTimeToogle(sharedPrefs: SharedPreferences) = sharedPrefs.getBoolean(
        KEY_FIRST_TIME_TOOGLE,true)


}
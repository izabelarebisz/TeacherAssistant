package com.example.asystentnauczyciela.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.asystentnauczyciela.studentsToSubjects.StudentToSubjectDao
import com.example.asystentnauczyciela.studentsToSubjects.StudentsToSubjects

@Database(entities = [Student::class,Subject::class,StudentsToSubjects::class], version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun studentDao(): StudentDao
    abstract fun subjectDao(): SubjectDao
    abstract val studentToSubjectDao: StudentToSubjectDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "assistant_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}



package com.example.module1



import android.content.Context
import android.preference.PreferenceManager

object SharedPreferencesManager {

    private const val VIEW_COUNT_KEY = "view_count"

    fun getViewCount(context: Context): Int {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getInt(VIEW_COUNT_KEY, 0)
    }

    fun incrementViewCount(context: Context) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val currentCount = getViewCount(context)
        preferences.edit().putInt(VIEW_COUNT_KEY, currentCount + 1).apply()
    }
}

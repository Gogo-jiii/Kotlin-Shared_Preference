package com.example.sharedpreference

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager private constructor() {

    private var context: Context? = null

    private var sharedPreferences: SharedPreferences? = null

    var prefString: String? = null
    var prefInt = 0
    var prefFloat = 0f
    var prefLong: Long = 0
    var isPrefBoolean = false
    var prefSet: Set<*>? = null

    override fun toString(): String {
        return "SharedPref{" +
                "context=" + context +
                ", sharedPreferences=" + sharedPreferences +
                ", prefString='" + prefString + '\'' +
                ", prefInt=" + prefInt +
                ", prefFloat=" + prefFloat +
                ", prefLong=" + prefLong +
                ", prefBoolean=" + isPrefBoolean +
                ", prefSet=" + prefSet +
                '}'
    }

    private fun init(context: Context) {
        this.context = context
        sharedPreferences = context.getSharedPreferences(
            "pref",
            Context.MODE_PRIVATE
        )
    }

    fun write(key: String?, data: Any, dataType: Int) {
        val editor = sharedPreferences!!.edit()
        when (dataType) {
            DATA_TYPE_STRING -> {
                editor.putString(key, data.toString())
                editor.apply()
            }
            DATA_TYPE_INT -> {
                editor.putInt(key, (data as Int))
                editor.apply()
            }
            DATA_TYPE_FLOAT -> {
                editor.putFloat(key, (data as Float))
                editor.apply()
            }
            DATA_TYPE_LONG -> {
                editor.putLong(key, (data as Long))
                editor.apply()
            }
            DATA_TYPE_BOOLEAN -> {
                editor.putBoolean(key, (data as Boolean))
                editor.apply()
            }
            DATA_TYPE_SET -> {
                editor.putStringSet(key, data as Set<String?>)
                editor.apply()
            }
        }
    }

    fun read(key: String?, dataType: Int): SharedPreferenceManager? {
        when (dataType) {
            DATA_TYPE_STRING -> {
                instance!!.prefString = sharedPreferences!!.getString(key, "")
                return instance
            }
            DATA_TYPE_INT -> {
                instance!!.prefInt = sharedPreferences!!.getInt(key, 0)
                return instance
            }
            DATA_TYPE_FLOAT -> {
                instance!!.prefFloat = sharedPreferences!!.getFloat(key, 0f)
                return instance
            }
            DATA_TYPE_LONG -> {
                instance!!.prefLong = sharedPreferences!!.getLong(key, 0)
                return instance
            }
            DATA_TYPE_BOOLEAN -> {
                instance!!.isPrefBoolean = sharedPreferences!!.getBoolean(key, false)
                return instance
            }
            DATA_TYPE_SET -> {
                instance!!.prefSet = sharedPreferences!!.getStringSet(key, null)
                return instance
            }
        }
        return null
    }

    companion object {
        private var instance: SharedPreferenceManager? = null
        const val DATA_TYPE_STRING = 1
        const val DATA_TYPE_INT = 2
        const val DATA_TYPE_FLOAT = 3
        const val DATA_TYPE_LONG = 4
        const val DATA_TYPE_BOOLEAN = 5
        const val DATA_TYPE_SET = 6
        fun getInstance(context: Context): SharedPreferenceManager? {
            if (instance == null) {
                instance = SharedPreferenceManager()
            }
            instance!!.init(context)
            return instance
        }
    }
}
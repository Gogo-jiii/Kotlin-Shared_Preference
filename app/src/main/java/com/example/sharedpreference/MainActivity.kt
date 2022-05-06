package com.example.sharedpreference

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferenceManager = SharedPreferenceManager.getInstance(this)
        sharedPreferenceManager!!.write("string", "a", SharedPreferenceManager.DATA_TYPE_STRING)
        sharedPreferenceManager.write("int", 1, SharedPreferenceManager.DATA_TYPE_INT)
        sharedPreferenceManager.write("float", 2.0f, SharedPreferenceManager.DATA_TYPE_FLOAT)
        sharedPreferenceManager.write("long", 3L, SharedPreferenceManager.DATA_TYPE_LONG)
        sharedPreferenceManager.write("boolean", true, SharedPreferenceManager.DATA_TYPE_BOOLEAN)

        Log.d(
            "TAG",
            sharedPreferenceManager.read(
                "string",
                SharedPreferenceManager.DATA_TYPE_STRING
            )!!.prefString.toString()
        )
        Log.d(
            "TAG",
            java.lang.String.valueOf(
                sharedPreferenceManager.read(
                    "int",
                    SharedPreferenceManager.DATA_TYPE_INT
                )!!.prefInt
            )
        )
        Log.d(
            "TAG",
            java.lang.String.valueOf(
                sharedPreferenceManager.read(
                    "float",
                    SharedPreferenceManager.DATA_TYPE_FLOAT
                )!!.prefFloat
            )
        )
        Log.d(
            "TAG",
            sharedPreferenceManager.read(
                "long",
                SharedPreferenceManager.DATA_TYPE_LONG
            )!!.prefLong.toString()
        )
        Log.d(
            "TAG",
            java.lang.String.valueOf(
                sharedPreferenceManager.read(
                    "boolean",
                    SharedPreferenceManager.DATA_TYPE_BOOLEAN
                )!!.isPrefBoolean
            )
        )
        val stringSet: MutableSet<String> = HashSet()
        stringSet.add("a")
        stringSet.add("b")
        stringSet.add("c")
        sharedPreferenceManager.write("set", stringSet, SharedPreferenceManager.DATA_TYPE_SET)
        Log.d(
            "TAG",
            sharedPreferenceManager.read(
                "set",
                SharedPreferenceManager.DATA_TYPE_SET
            )!!.prefSet.toString()
        )
    }
}
package com.example.topacademy_android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.topacademy_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    enum class FunctionLogs(val func_name: String) {
        ON_CREATE("ON_CREATE"),
        ON_START("ON_START"),
        ON_RESUME("ON_RESUME"),
        ON_PAUSE("ON_PAUSE"),
        ON_STOP("ON_STOP"),
        ON_RESTART("ON_RESTART"),
        ON_DESTROY("ON_DESTROY")
    }

    private lateinit var binding: ActivityMainBinding
    private val startMs = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i(FunctionLogs.ON_CREATE.func_name, "Активити создана!")
        Log.i("Elapsed time in ms", (System.currentTimeMillis() - startMs).toString());
    }

    override fun onStart() {
        super.onStart()
        Log.i(FunctionLogs.ON_START.func_name, "Activity started!")
        Log.i("Elapsed time in ms", (System.currentTimeMillis() - startMs).toString());
    }

    override fun onResume() {
        super.onResume()
        Log.i(FunctionLogs.ON_RESUME.func_name, "Activity resumed!")
        Log.i("Elapsed time in ms", (System.currentTimeMillis() - startMs).toString());
    }

    override fun onPause() {
        super.onPause()
        Log.i(FunctionLogs.ON_PAUSE.func_name, "Activity paused!")
    }

    override fun onStop() {
        super.onStop()
        Log.i(FunctionLogs.ON_STOP.func_name, "Activity stopped!")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(FunctionLogs.ON_RESTART.func_name, "Activity restarted!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(FunctionLogs.ON_DESTROY.func_name, "Activity destroyed!")
    }
}
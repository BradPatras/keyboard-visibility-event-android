package com.viniciusmo.sample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.viniciusmo.keyboardvisibility.keyboard

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        keyboard {
            onClosed { Toast.makeText(this@MainActivity, "onClosed", Toast.LENGTH_SHORT).show() }
            onOpened { Toast.makeText(this@MainActivity, "onOpened", Toast.LENGTH_SHORT).show() }
        }
    }
}

package com.hazem.tectactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.hazem.tectactoeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currPlayer: Boolean = true
    private var array = Array(3) { IntArray(3) { 2 } }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

       start()
    }
    private fun start(){
    binding.tv11.setOnClickListener {
        play(currPlayer, binding.tv11, 1, 1)
    }
    binding.tv12.setOnClickListener {
        play(currPlayer, binding.tv12, 1, 2)
    }
    binding.tv13.setOnClickListener {
        play(currPlayer, binding.tv13, 1, 3)
    }
    binding.tv21.setOnClickListener {
        play(currPlayer, binding.tv21, 2, 1)
    }
    binding.tv22.setOnClickListener {
        play(currPlayer, binding.tv22, 2, 2)
    }
    binding.tv23.setOnClickListener {
        play(currPlayer, binding.tv23, 2, 3)
    }
    binding.tv31.setOnClickListener {
        play(currPlayer, binding.tv31, 3, 1)
    }
    binding.tv32.setOnClickListener {
        play(currPlayer, binding.tv32, 3, 2)
    }
    binding.tv33.setOnClickListener {
        play(currPlayer, binding.tv33, 3, 3)
    }
}
    private fun play(status: Boolean, view: View, x: Int, y: Int) {
        val textView: TextView = view as TextView
        if (textView.text.toString().isEmpty() && status) {
            textView.text = "O"
            array[x - 1][y - 1] = 0
            currPlayer = !status
        } else if (textView.text.toString().isEmpty()) {
            textView.text = "X"
            array[x - 1][y - 1] = 1
            currPlayer = !status
        }

        if (isWin()) {

            Thread {
                    runOnUiThread {}
                    Thread.sleep(1000)
                reSet()
            }.start()
            //Toast.makeText(applicationContext,"win",Toast.LENGTH_LONG).show()
        }
    }


    private fun isWin(): Boolean {
        return if (array[0][0] == array[0][1] && array[0][0] == array[0][2] && array[0][0] != 2)
            true
        else if (array[1][0] == array[1][1] && array[1][0] == array[1][2] && array[1][0] != 2)
            true
        else if (array[2][0] == array[2][1] && array[2][0] == array[2][2] && array[2][0] != 2)
            true
        else if (array[0][0] == array[1][0] && array[0][0] == array[2][0] && array[0][0] != 2)
            true
        else if (array[0][1] == array[1][1] && array[0][1] == array[2][1] && array[0][1] != 2)
            true
        else if (array[0][2] == array[1][2] && array[0][2] == array[2][2] && array[0][2] != 2)
            true
        else if (array[0][0] == array[1][1] && array[0][0] == array[2][2] && array[0][0] != 2)
            true
        else array[0][2] == array[1][1] && array[0][2] == array[2][0] && array[0][2] != 2

    }

    private fun reSet() {
        array = Array(3) { IntArray(3) { 2 } }
        binding.tv11.text = ""
        binding.tv12.text = ""
        binding.tv13.text = ""
        binding.tv21.text = ""
        binding.tv22.text = ""
        binding.tv23.text = ""
        binding.tv31.text = ""
        binding.tv32.text = ""
        binding.tv33.text = ""
    }

}
package com.hazem.tectactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.hazem.tectactoeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
     private var currPlayer:Boolean=true
    private val array = Array(3) { IntArray(3) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        array[0][0]=1
        binding.tv11.setOnClickListener {
            play(currPlayer,binding.tv11,1,1)
          //  Toast.makeText(applicationContext,"${array[0][0]}",Toast.LENGTH_LONG).show()
        }


    }
   private fun play(status: Boolean, view: View, x: Int, y: Int){
          val textView:TextView= view as TextView
            if(textView.text.toString() == "T" && status){
                textView.text="O"
                array[x-1][y-1]=0
                currPlayer=!status
            }

            else if(textView.text.toString() == "T" ){
               textView.text="X"
                array[x-1][y-1]=1
                currPlayer=!status
            }

    }

}
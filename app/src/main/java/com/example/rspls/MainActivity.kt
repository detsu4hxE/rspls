package com.example.rspls

import android.R
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.rspls.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun getGameChoice(optionsParam: Array<String>) =
        optionsParam[(Math.random() * optionsParam.size).toInt()]

    fun getId1(a: Int): Int
    {
        var x = 0
        when(a){
            binding.imageButton1.id -> x = 0
            binding.imageButton2.id -> x = 1
            binding.imageButton3.id -> x = 2
            binding.imageButton4.id -> x = 3
            binding.imageButton5.id -> x = 4
        }
        return x
    }

    fun setImg(optionsParam: Array<String>, userChoice: String, gameChoice: String)
    {
        val bitmap1 = (binding.imageButton1.getDrawable() as BitmapDrawable).bitmap
        val bitmap2 = (binding.imageButton2.getDrawable() as BitmapDrawable).bitmap
        val bitmap3 = (binding.imageButton3.getDrawable() as BitmapDrawable).bitmap
        val bitmap4 = (binding.imageButton4.getDrawable() as BitmapDrawable).bitmap
        val bitmap5 = (binding.imageButton5.getDrawable() as BitmapDrawable).bitmap
        when(userChoice){
            optionsParam[0] -> binding.imageView1.setImageBitmap(bitmap1)
            optionsParam[1] -> binding.imageView1.setImageBitmap(bitmap2)
            optionsParam[2] -> binding.imageView1.setImageBitmap(bitmap3)
            optionsParam[3] -> binding.imageView1.setImageBitmap(bitmap4)
            optionsParam[4] -> binding.imageView1.setImageBitmap(bitmap5)
        }
        when(gameChoice){
            optionsParam[0] -> binding.imageView2.setImageBitmap(bitmap1)
            optionsParam[1] -> binding.imageView2.setImageBitmap(bitmap2)
            optionsParam[2] -> binding.imageView2.setImageBitmap(bitmap3)
            optionsParam[3] -> binding.imageView2.setImageBitmap(bitmap4)
            optionsParam[4] -> binding.imageView2.setImageBitmap(bitmap5)
        }
    }

    fun printResult(userChoice: String, gameChoice: String){
        val result: String = if (userChoice == gameChoice) {
            "Ничья"
        }
        else
        {
            if ((userChoice == "Камень" && ( (gameChoice == "Ножницы") || (gameChoice == "Ящерица") ) )||
                (userChoice == "Ножницы" && ( (gameChoice == "Бумага")||(gameChoice == "Ящерица") ) ) ||
                (userChoice == "Бумага" && ( (gameChoice == "Камень")||(gameChoice == "Спок") ) )||
                (userChoice == "Спок" && ( (gameChoice == "Ножницы")||(gameChoice == "Камень") ) )||
                (userChoice == "Ящерица" && ( (gameChoice == "Бумага")||(gameChoice == "Спок") ) ))
            {
                "Вы выиграли"
            }
            else
            {
                "Вы проиграли"
            }
        }
        binding.textView3.text = result
    }

    fun onClickCheck(view: View) {
        val options = arrayOf("Камень", "Ножницы", "Бумага", "Спок", "Ящерица")
        var a = view.getId()
        var x = getId1(a)
        val gameChoice = getGameChoice(options)
        val userChoice = options[x]
        printResult (userChoice, gameChoice)
        setImg(options, userChoice, gameChoice)
        binding.imageView1.visibility = View.VISIBLE
        binding.imageView2.visibility = View.VISIBLE
        binding.textView.visibility = View.VISIBLE
        binding.textView2.visibility = View.VISIBLE
        binding.textView3.visibility = View.VISIBLE
    }
}
package com.example.practical2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.webkit.RenderProcessGoneDetail
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it)
        }
        findViewById<TextView>(R.id.nickname_text).setOnClickListener{
            updateNickname(it)
        }

    }

    private fun addNickname(view:View){
        val editText:EditText=findViewById(R.id.nickname_edit)
        val nicknameTextView=findViewById<TextView>(R.id.nickname_text)

        nicknameTextView.text=editText.text
        editText.visibility=View.GONE
        view.visibility=View.GONE
        nicknameTextView.visibility= View.VISIBLE

        //hide the keywboard
        val inputMethodManager=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun updateNickname(view:View){
        val editText:EditText=findViewById(R.id.nickname_edit)
        val doneBUtton = findViewById<Button>(R.id.done_button)

        editText.visibility=View.VISIBLE
        doneBUtton.visibility=View.VISIBLE
        view.visibility=View.GONE
    }
}
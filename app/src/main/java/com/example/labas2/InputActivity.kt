package com.example.labas2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class InputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
    }

    fun saveData(view: View){
        val data = Intent();
//        data.putExtra(Intent.EXTRA_TEXT, findViewById<TextView>(R.id.inputText).text)
        data.data = Uri.parse(findViewById<TextView>(R.id.inputText).text.toString());
        setResult(RESULT_OK, data);
        finish();
    }
}
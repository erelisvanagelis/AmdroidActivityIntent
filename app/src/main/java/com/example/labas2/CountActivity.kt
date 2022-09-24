package com.example.labas2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count)

        val text = intent.getStringExtra(Intent.EXTRA_TEXT).toString()

        val showText = findViewById<TextView>(R.id.savedTextView)
        showText.text = text

        val wordCount = findViewById<TextView>(R.id.wordCountTextView)
        wordCount.text = text.split(' ').size.toString()
    }
}
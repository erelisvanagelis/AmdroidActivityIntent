package com.example.labas2
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    var savedText: String = "saved text";
    private val saveTextCallback =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == Activity.RESULT_OK){
                savedText = it.data?.data.toString()
                println(savedText)
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openInputActivity(view: View) {
        val intent = Intent(this, InputActivity::class.java)
        saveTextCallback.launch(intent)
    }

    fun openCountActivity(view: View) {
        intent = Intent(this, CountActivity::class.java)
        intent.putExtra(Intent.EXTRA_TEXT, savedText)
        startActivity(intent)
    }

    fun openSendActivity(view: View){
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, savedText)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }



}
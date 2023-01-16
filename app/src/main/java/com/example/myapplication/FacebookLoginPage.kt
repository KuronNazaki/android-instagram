package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import androidx.activity.result.ActivityResultLauncher
import android.content.Intent
import androidx.activity.result.ActivityResultCallback
import com.example.myapplication.MainActivity
import android.widget.TextView
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.graphics.Typeface
import android.text.Spanned
import com.example.myapplication.FacebookLoginSection
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.InstagramFooter

class FacebookLoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facebook_login_page)
        val loginButton = findViewById<View>(R.id.loginButton) as Button
        loginButton.setOnClickListener(object : View.OnClickListener {
            private val launcher =
                registerForActivityResult<Intent, ActivityResult>(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? -> }

            override fun onClick(v: View) {
                val intent = Intent(v.context, MainActivity::class.java)
                launcher.launch(intent)
            }
        })
        setLanguageTextView()
    }

    private fun setLanguageTextView() {
        val firstContent = "English • "
        val secondContent = "Change"
        val languageTextView = findViewById<View>(R.id.language_change) as TextView
        val spannableStringBuilder = SpannableStringBuilder(firstContent + secondContent)
        spannableStringBuilder.setSpan(
            StyleSpan(Typeface.BOLD),
            firstContent.length,
            spannableStringBuilder.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        languageTextView.setText(spannableStringBuilder, TextView.BufferType.EDITABLE)
    }
}
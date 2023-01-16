package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import androidx.constraintlayout.widget.ConstraintLayout
import android.graphics.drawable.AnimationDrawable
import android.widget.TextView
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.graphics.Typeface
import android.text.Spanned
import androidx.activity.result.ActivityResultLauncher
import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.FacebookLoginPage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Gradient
        val constraintLayout = findViewById<ConstraintLayout>(R.id.layout)
        val animationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(4000)
        animationDrawable.start()

        // Forgot password
        val firstContent = "Forgot your login detail? "
        val secondContent = "Get help signing in."
        val forgotPasswordTextView = findViewById<TextView>(R.id.forgot_password_text_view)
        val spannableStringBuilder = SpannableStringBuilder(firstContent + secondContent)
        spannableStringBuilder.setSpan(
            StyleSpan(Typeface.BOLD),
            firstContent.length,
            spannableStringBuilder.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        forgotPasswordTextView.setText(spannableStringBuilder, TextView.BufferType.EDITABLE)
        val loginButton = findViewById<View>(R.id.login_button) as Button
        loginButton.setOnClickListener(object : View.OnClickListener {
            private val startForResult =
                registerForActivityResult<Intent, ActivityResult>(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? -> }

            override fun onClick(v: View) {
                val intent = Intent(v.context, FacebookLoginPage::class.java)
                startForResult.launch(intent)
            }
        })
    }
}
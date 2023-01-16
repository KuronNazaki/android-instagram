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
import androidx.fragment.app.Fragment
import com.example.myapplication.InstagramFooter

/**
 * A simple [Fragment] subclass.
 * Use the [InstagramFooter.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstagramFooter : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inf = inflater.inflate(R.layout.fragment_instagram_login_footer, container, false)
        val firstContent = "Don't have an account? "
        val secondContent = "Sign up."
        val signUpTextView = inf.findViewById<TextView>(R.id.sign_up_text_view)
        val spannableStringBuilder = SpannableStringBuilder(firstContent + secondContent)
        spannableStringBuilder.setSpan(
            StyleSpan(Typeface.BOLD),
            firstContent.length,
            spannableStringBuilder.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        signUpTextView.setText(spannableStringBuilder, TextView.BufferType.EDITABLE)

        // Inflate the layout for this fragment
        return inf
    }

    companion object {

        fun newInstance(param1: String?, param2: String?): InstagramFooter {
            val fragment = InstagramFooter()
            return fragment
        }
    }
}
package com.example.a30daysofkotlinchallenge

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var doneButton: Button
    lateinit var nicknameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doneButton = findViewById<Button>(R.id.done_button)
        doneButton.setOnClickListener { addNickname(it) }

        editText = findViewById<EditText>(R.id.nickname_edit)
        nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        nicknameTextView.setOnClickListener {
            updateNickname(it)
        }

    }

    private fun addNickname(view: View) {

        nicknameTextView.text = editText.text

        // Disappear Text field
        editText.visibility = View.GONE

        // Show nickname button
        nicknameTextView.visibility = View.VISIBLE

        // Disaapear button
        view.visibility = View.GONE

        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        nicknameTextView.visibility = View.GONE

        // Set the focus to the edit text.
        editText.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)

    }
}

package com.example.a30daysofkotlinchallenge

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.a30daysofkotlinchallenge.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil as DataBindingUtil1

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private var myName: MyName = MyName("Aleks Heacky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil1.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener { addNickname() }

        binding.nicknameText.setOnClickListener {
            updateNickname()
        }

    }

    private fun addNickname() {
        binding.apply {
            myName?.nickname = binding.nicknameEdit.text.toString()

            // Disappear Text field
            binding.nicknameEdit.visibility = View.GONE

            // Show nickname button
            binding.nicknameText.visibility = View.VISIBLE

            // Disaapear button
            binding.doneButton.visibility = View.GONE

            invalidateAll()
        }



        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.doneButton.windowToken, 0)


    }

    private fun updateNickname() {

        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE
        binding.nicknameText.visibility = View.GONE

        // Set the focus to the edit text.
        binding.nicknameEdit.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)

    }
}

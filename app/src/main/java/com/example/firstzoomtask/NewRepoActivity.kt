package com.example.firstzoomtask

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.firstzoomtask.databinding.AddNewRepoBinding

class NewRepoActivity: AppCompatActivity() {
    private lateinit var binding: AddNewRepoBinding
    private lateinit var viewModel: NewRepoViewModel
    var ownerName : String = ""
    var repoName : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddNewRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val dao = RegisterDatabase.getDatabase(application).userDao
//
//        val repository = RegisterRepo(dao)
//
//        val factory = RegisterViewModelFactory(repository)
//        viewModel = ViewModelProvider(this, factory).get(NewRepoViewModel::class.java)

        getUserEnteredData()

//        buttonValidation()

    }


    private fun getUserEnteredData() {
        binding.ownerName.addTextChangedListener(textWatcher)
        binding.repoName.addTextChangedListener(textWatcher)

        binding.button.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("ownerName", ownerName)
            intent.putExtra("repoName", repoName)
            startActivity(intent)
//                val users = RegisterEntity(
//                    ownerName = binding.ownerName.text.toString(),
//                    repoName = binding.repoName.text.toString()
//                )
//
//                viewModel.insert(users)

        }
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            ownerName = binding.ownerName.text.toString().trim()
            repoName = binding.repoName.text.toString().trim()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

    }

    private fun formValidation(): Boolean {
        !ownerName.isNullOrEmpty() && !repoName.isNullOrEmpty()
        return true
    }
}
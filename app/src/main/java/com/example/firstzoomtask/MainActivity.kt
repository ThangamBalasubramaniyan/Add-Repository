package com.example.firstzoomtask

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstzoomtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), EmployeeAdapter.hospitalClickListener, EmployeeAdapter.shareClickListner {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ownerName = intent.getStringExtra("ownerName")
        val repoName = intent.getStringExtra("repoName")

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.getUser()
        viewModel.myResponseList.observe(this, Observer {
            binding.recyclerView.adapter = EmployeeAdapter(it, this, this)
        })
        binding.fabButton.setOnClickListener {
            val intent = Intent(this, NewRepoActivity::class.java)
            startActivity(intent)
        }

    }

    override fun getItem(position: Int) {
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.myResponseList.observe(this, {
            val url = it.get(position).html_url
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        })
    }

    override fun shareItem(position: Int) {
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.myResponseList.observe(this, {
            val name = it.get(position).name
            val url = it.get(position).html_url
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Repo Name: ${name} \nRepo URL : ${url}")
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        })
    }
}
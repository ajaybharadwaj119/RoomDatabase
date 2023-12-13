package com.akinfopark.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.akinfopark.roomdatabase.data.User
import com.akinfopark.roomdatabase.data.UserDatabase
import com.akinfopark.roomdatabase.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding
    var FirstName = ""
    var LastName = ""
    var age: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java, "user_database"
        ).build()

        binding.button.setOnClickListener {

            FirstName = binding.edtFstName.text.toString()
            LastName = binding.edtLastname.text.toString()
            try {
                age = binding.edtAge.text.toString().toInt()
            } catch (e: Exception) {
                age = 0
            }


            val user = User(firstName = FirstName, lastName = LastName, age = age)
            database.userDao().addUser(user)

            binding.edtFstName.setText("")
            binding.edtLastname.setText("")
            binding.edtAge.setText("")
        }


    }

}
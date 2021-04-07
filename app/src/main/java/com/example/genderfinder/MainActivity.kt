package com.example.genderfinder

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.genderfinder.repository.Repository
import java.io.ByteArrayOutputStream

class MainActivity : AppCompatActivity()
{
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun bt_onClick(view: View)
    {
        val name = findViewById<EditText>(R.id.et_name).text.toString()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost2(encoder())
        viewModel.myResponse2.observe(this, Observer {
            if (it.isSuccessful)
            {
                findViewById<TextView>(R.id.tv_res).text = it.body()?.name
            }
            else
            {
                Log.d("ERROR", it.errorBody()!!.string())
            }
        })
    }

    fun encoder(): String
    {
        val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.smoke)
        val baos = ByteArrayOutputStream()
        bitmap2.compress(Bitmap.CompressFormat.JPEG,
            70, baos)
        val b: ByteArray = baos.toByteArray()
        Log.d("Lööööööööööööö", Base64.encodeToString(b, Base64.DEFAULT))
        return Base64.encodeToString(b, Base64.DEFAULT)
    }
}
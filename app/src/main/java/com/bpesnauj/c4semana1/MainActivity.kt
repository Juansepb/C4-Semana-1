package com.bpesnauj.c4semana1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private var edtUsername: EditText? = null
    private var edtPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.my_toolbar))

        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
    }

    fun onLogin(botonLogin: View) {
        var username: String = edtUsername!!.text.toString()
        var password: String = edtPassword!!.text.toString()
        if (username == "pbjuanse7@gmail.com" && password == "1234"){
            val positiveButton = {dialog: DialogInterface,which: Int ->
                val intento = Intent(this,WelcomeActivity::class.java)
                startActivity(intento)
                fun onIntro(view: View ) {
                    Toast.makeText(applicationContext,getResources().getString(R.string.dlog_title2), Toast.LENGTH_LONG).show()
                }
            }
            val negativeButton = {_: DialogInterface,_: Int -> }
            val dialog = AlertDialog.Builder(this).setTitle(getResources().getString(R.string.dlog_title2)).setMessage(getResources().getString(R.string.dlog_message2)+ edtUsername!!.text.toString()).setPositiveButton(getResources().getString(R.string.dlog_bp),positiveButton).setNegativeButton(getResources().getString(R.string.dlog_bn),negativeButton).create().show()
        }
        else{
            val dialog = AlertDialog.Builder(this).setTitle(getResources().getString(R.string.dlog_title)).setMessage(getResources().getString(R.string.dlog_message)).create().show()
            Toast.makeText(this,getResources().getString(R.string.dlog_message),Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId){
        R.id.action_search -> {
            Toast.makeText(this,R.string.txt_action_search,Toast.LENGTH_LONG).show()
            true
        }

        R.id.action_settings -> {
            Toast.makeText(this,R.string.txt_action_settings,Toast.LENGTH_LONG).show()
            true
        }

        R.id.action_logout -> {
            Toast.makeText(this,R.string.txt_action_logout,Toast.LENGTH_LONG).show()
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    fun onRegister(view: View) {
        val intentoRegistro = Intent(this,RegisterActivity::class.java)
        startActivity(intentoRegistro)
    }
}
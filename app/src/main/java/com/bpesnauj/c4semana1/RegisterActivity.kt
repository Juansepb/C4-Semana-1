package com.bpesnauj.c4semana1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import android.util.Patterns
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
    private var edt_Name : EditText?=null
    private var edt_LastName : EditText?=null
    private var edt_Nit : EditText?=null
    private var edt_Email : EditText?=null
    private var edt_Phone : EditText?=null
    private var edt_PasswordR : EditText?=null
    private var chk_Policies : CheckBox?=null
    private val NAME_PATTERN : Pattern = Pattern.compile(
        "[a-zA-Z]*"
    )
    private val PASSWORD_PATTERN : Pattern = Pattern.compile(
        "^"+
                "(?=.*[0-9])"+
                "(?=.*[a-z])"+
                "(?=.*[A-Z])"+
                "(?=.*[#$%&/!=^.,])"+
                "(?=\\S+$)"+
                ".{8,}"+
                "$"
    )
    private val EMAIL_PATTERN : Pattern = Patterns.EMAIL_ADDRESS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        edt_Name = findViewById(R.id.edt_Name)
        edt_LastName = findViewById(R.id.edt_LastName)
        edt_Nit = findViewById(R.id.edt_Nit)
        edt_Email = findViewById(R.id.edt_Email)
        edt_Phone = findViewById(R.id.edt_Phone)
        edt_PasswordR = findViewById(R.id.edt_PasswordR)
        chk_Policies = findViewById(R.id.chk_Policies)
    }

    fun onRegisterR(view: View) {
        if (formValidate()){
            Toast.makeText(this,"Validacion correcta", Toast.LENGTH_LONG).show()
            val endValidationRegistro = Intent(this,MainActivity::class.java)
            startActivity(endValidationRegistro)
        }else {
            Toast.makeText(this,"Error en la validacion", Toast.LENGTH_LONG).show()
        }
    }
    fun formValidate() : Boolean {
        var onVlidate = true
        var NameInput : String = edt_Name!!.text.toString()
        var LastNameInput : String = edt_LastName!!.text.toString()
        var PasswordRInput : String = edt_PasswordR!!.text.toString()
        var EmailInput : String = edt_Email!!.text.toString()

        if (TextUtils.isEmpty(NameInput))
        {
            edt_Name!!.error= "Required"
            onVlidate = false
        }else if (!NAME_PATTERN.matcher(NameInput.replace(" ","")).matches())
        {
            edt_Name!!.error= "Name error"
            onVlidate = false
        }else {
            edt_Name!!.error= null
        }

        if (TextUtils.isEmpty(LastNameInput))
        {
            edt_LastName!!.error= "Required"
            onVlidate = false
        }else if (!NAME_PATTERN.matcher(LastNameInput.replace(" ","")).matches())
        {
            edt_LastName!!.error= "Required"
            onVlidate = false
        }else {
            edt_LastName!!.error= null
        }

        if (TextUtils.isEmpty(edt_Nit!!.text.toString()))
        {
            edt_Nit!!.error= "Required"
            onVlidate = false
        }else {
            edt_Nit!!.error= null
        }

        if (TextUtils.isEmpty(EmailInput))
        {
            edt_Email!!.error= "Invalid Email"
            onVlidate = false
        }else if (!EMAIL_PATTERN.matcher(EmailInput).matches())
        {
            edt_Email!!.error= "Required"
            onVlidate = false
        }else {
            edt_Email!!.error= null
        }

        if (TextUtils.isEmpty(edt_Phone!!.text.toString()))
        {
            edt_Phone!!.error= "Required"
            onVlidate = false
        }else {
            edt_Phone!!.error= null
        }

        if (TextUtils.isEmpty(PasswordRInput))
        {
            edt_PasswordR!!.error= "Required"
            onVlidate = false
        }else if (!PASSWORD_PATTERN.matcher(PasswordRInput).matches())
        {
            edt_PasswordR!!.error= "Invalid password"
            onVlidate = false
        }else {
            edt_PasswordR!!.error= null
        }

        if (! chk_Policies!!.isChecked){
            onVlidate = false
        }

        return onVlidate
    }
}
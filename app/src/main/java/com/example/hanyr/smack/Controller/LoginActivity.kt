package com.example.hanyr.smack.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hanyr.smack.R
import com.example.hanyr.smack.Services.AuthServices
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginCreateUserBtnClicked(view: View){
        val createUserIntent = Intent(this, CreateUserActivity::class.java)
        startActivity(createUserIntent)
        finish()
    }

    fun logingLoginBtnClicked (view: View){
        val email = loginEmailTxt.text.toString()
        val password = loginPasswordTxt.text.toString()

        AuthServices.loginUser(this, email, password){loginSuccess ->
            if (loginSuccess){
                AuthServices.findUserByEmail(this){findSuccess ->
                    if (findSuccess){
                        finish()
                    }
                }
            }
        }
    }
}

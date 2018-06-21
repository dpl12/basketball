package com.example.dpl.basketball.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dpl.basketball.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        getStartedBtn.setOnClickListener {
            val leagueIntent=Intent(this, LeagueActivity::class.java)//::符号:得到类的Class对象
            startActivity(leagueIntent)
        }
    }
}

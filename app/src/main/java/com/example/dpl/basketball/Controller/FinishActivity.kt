package com.example.dpl.basketball.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dpl.basketball.Model.Player
import com.example.dpl.basketball.R
import com.example.dpl.basketball.Utillties.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val player=intent.getParcelableExtra<Player>(EXTRA_PLAYER)
        searchLeagueSkillText.text="Looking for a ${player.league} ${player.skill} league near you..."
    }
}

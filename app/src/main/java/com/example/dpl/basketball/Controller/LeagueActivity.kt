package com.example.dpl.basketball.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.dpl.basketball.Model.Player
import com.example.dpl.basketball.R
import com.example.dpl.basketball.Utillties.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : AppCompatActivity() {

    var player=Player("","")    //定义空数据对象
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER,player)   //解决屏幕旋转带来的数据销毁，用于保存及时数据
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState!=null){
            player=savedInstanceState.getParcelable(EXTRA_PLAYER)  //屏幕旋转后，用于恢复数据
        }
    }

    fun onMensClicked(view: View){
        womensLeagueBtn.isChecked=false
        coedLeagueBtn.isChecked=false
        player.league="Mens"
    }

    fun onWomensClicked(view: View){
        mensLeagueBtn.isChecked=false
        coedLeagueBtn.isChecked=false
        player.league="Womens"
    }

    fun onCoedClicked(view: View){
        womensLeagueBtn.isChecked=false
        mensLeagueBtn.isChecked=false
        player.league="Co-ed"
    }

    fun leagueNextClicked(view:View){
        if(player.league!="") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER,player)
            startActivity(skillActivity)
        }else{
            Toast.makeText(this,"请选择一个选项",Toast.LENGTH_SHORT).show()
        }
    }
}

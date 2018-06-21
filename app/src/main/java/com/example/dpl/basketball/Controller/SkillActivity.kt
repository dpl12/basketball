package com.example.dpl.basketball.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.dpl.basketball.Model.Player
import com.example.dpl.basketball.R
import com.example.dpl.basketball.Utillties.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {

    lateinit var player: Player     //延迟初始化变量
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER,player)   //解决屏幕旋转带来的数据销毁，用于保存及时数据
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player=intent.getParcelableExtra(EXTRA_PLAYER)
        //Toast.makeText(this,"您选择的是${league}",Toast.LENGTH_SHORT).show()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState!=null){
            player=savedInstanceState.getParcelable(EXTRA_PLAYER)  //屏幕旋转后，用于恢复数据
        }
    }

    fun onBeginnerClicked(view:View){
        ballerSkillBtn.isChecked=false
        player.skill="beginner"
    }

    fun onBallerClicked(view: View){
        beginnerSkillBtn.isChecked=false
        player.skill="baller"
    }

    fun onFinishClicked(view: View){
        if(player.skill!=""){
            val finishActivity=Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER,player)
            startActivity(finishActivity)
        }else{
            Toast.makeText(this,"请选择一个选项！",Toast.LENGTH_SHORT).show()
        }
    }
}

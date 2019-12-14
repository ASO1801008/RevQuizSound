package jp.ac.asojuku.revquizsound

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_quest.*

class QuestActivity : AppCompatActivity() {

    private lateinit var soundPool: SoundPool;
    private var soundResId1 = 0;
    private var soundResId2 = 0;
    private var soundResId3 = 0;
    private var soundResId4 = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)

        change_button2.setOnClickListener{
        finish();
        }

        seikai_button.setOnClickListener{
            soundPool.play(soundResId1,1.0f,1.0f,0,0,1.0f);
        }

        matigai_button.setOnClickListener{
            soundPool.play(soundResId2,1.0f,1.0f,0,0,1.0f);
        }

        hakusyu_button.setOnClickListener{
            soundPool.play(soundResId3,1.0f,1.0f,0,0,1.0f);
        }

        syutudai_button.setOnClickListener{
            soundPool.play(soundResId4,1.0f,1.0f,0,0,1.0f);
        }

    }
    override fun onResume() {
        super.onResume();
        soundPool = SoundPool(2, AudioManager.STREAM_MUSIC,0);
        soundResId1 = soundPool.load(this,R.raw.seikai,1);
        soundResId2 = soundPool.load(this,R.raw.matigai,1);
        soundResId3 = soundPool.load(this,R.raw.hakusyu,1);
        soundResId4 = soundPool.load(this,R.raw.syutudai,1);


    }

    override fun onPause() {
        super.onPause();
        soundPool.release();
    }
}

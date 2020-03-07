package club.zhuol.writenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //设置音乐播放状态变量
    static boolean isPlay = true;
    //定义上下文菜单
    Activity context = MainActivity.this;
    //定义音乐播放器对象
    MediaPlayer mediaPlayer;
    Button btn_play, btn_about, btn_music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_music = findViewById(R.id.btn_music);
        //播放音乐方法
        playMusic();
        //当Activity跳转时自动停止播放音乐
        onStopMusic();
    }

    /**
     * 当Activity跳转时自动停止播放音乐
     */
    private void onStopMusic() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer!=null){ //音乐播放器不为空时
            mediaPlayer.stop(); //停止音乐播放

        }
    }

    /**
     * 播放音乐方法
     * 加载音乐文件
     */
    private void playMusic() {
        mediaPlayer = MediaPlayer.create(context, R.raw.main_music);
        //设置循环播放
        mediaPlayer.setLooping(true);
        //启动播放音乐
        mediaPlayer.start();
    }

    public void onPlay(View view) {
        startActivity(new Intent(MainActivity.this, SelectActivity.class));
    }

    public void onAbout(View view) {
        startActivity(new Intent(MainActivity.this, AboutActivity.class));
    }

    /**
     * 播放音乐按钮绑定事件
     *
     * @param view
     */
    public void onMusic(View view) {
        if (isPlay == true) {    //如果音乐正在播放
            if (mediaPlayer != null) {   //音乐播放器不为空时
                mediaPlayer.pause();
                //设置停止播放时图标
                btn_music.setBackgroundResource(R.drawable.btn_music2);
                //设置音乐为停止状态
                isPlay = false;
            }
        } else {  //如果音乐为停止状态
            playMusic();    //调用播放音乐方法播放音乐
            //设置播放时的图标
            btn_music.setBackgroundResource(R.drawable.btn_music1);
            isPlay = true;  //设置音乐为播放状态
        }
    }
}

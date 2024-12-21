package tf.iitb.abhangyatra;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TeerthVittala extends AppCompatActivity implements View.OnClickListener {
    Button home3,play3,pause3,stop3;
    MediaPlayer mp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teerth_vittala);
        home3=findViewById(R.id.home3_btn);
        play3=findViewById(R.id.play3_btn);
        pause3=findViewById(R.id.pause3_btn);
        stop3=findViewById(R.id.stop3_btn);
        home3.setOnClickListener(view -> {
            Intent in =new Intent(getApplicationContext(), MainActivity.class);
            startActivity(in);
            mp3.stop();
        });
        play3.setOnClickListener(this);
        pause3.setOnClickListener(this);
        stop3.setOnClickListener(this);
        mp3=MediaPlayer.create(this,R.raw.tirth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play3_btn:
                if (mp3.isPlaying()){
                    mp3.stop();
                }
                mp3.start();
                break;
            case R.id.pause3_btn:
                mp3.pause();
                break;
            case R.id.stop3_btn:
                mp3.stop();
                break;
        }
    }
}
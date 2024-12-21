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

public class AataMe extends AppCompatActivity implements View.OnClickListener {
    Button home4,play4,pause4,stop4;
    MediaPlayer mp4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_aata_me);
        home4=findViewById(R.id.home4_btn);
        play4=findViewById(R.id.play4_btn);
        pause4=findViewById(R.id.pause4_btn);
        stop4=findViewById(R.id.stop4_btn);
        home4.setOnClickListener(view -> {
            Intent in =new Intent(getApplicationContext(), MainActivity.class);
            startActivity(in);
            mp4.stop();
        });
        play4.setOnClickListener(this);
        pause4.setOnClickListener(this);
        stop4.setOnClickListener(this);
        mp4=MediaPlayer.create(this,R.raw.aatame);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play4_btn:
                if (mp4.isPlaying()){
                    mp4.stop();
                }
                mp4.start();
                break;
            case R.id.pause4_btn:
                mp4.pause();
                break;
            case R.id.stop4_btn:
                mp4.stop();
                break;
        }
    }
}
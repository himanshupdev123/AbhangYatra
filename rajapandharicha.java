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

public class rajapandharicha extends AppCompatActivity implements View.OnClickListener {
    Button home2,play2,pause2,stop2;
    MediaPlayer mp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rajapandharicha);
        home2=findViewById(R.id.home2_btn);
        play2=findViewById(R.id.play2_btn);
        pause2=findViewById(R.id.pause2_btn);
        stop2=findViewById(R.id.stop2_btn);
        home2.setOnClickListener(view -> {
            Intent in =new Intent(getApplicationContext(), MainActivity.class);
            startActivity(in);
            mp2.stop();
        });
        play2.setOnClickListener(this);
        pause2.setOnClickListener(this);
        stop2.setOnClickListener(this);
        mp2=MediaPlayer.create(this,R.raw.raja);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play2_btn:
                if (mp2.isPlaying()){
                    mp2.stop();
                }
                mp2.start();
                break;
            case R.id.pause2_btn:
                mp2.pause();
                break;
            case R.id.stop2_btn:
                mp2.stop();
                break;
        }
    }
}
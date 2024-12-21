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

public class GoadTuzeRoop extends AppCompatActivity implements View.OnClickListener {
    Button home1,play1,pause1,stop1;
    MediaPlayer mp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_goad_tuze_roop);
        home1=findViewById(R.id.home1_btn);
        play1=findViewById(R.id.play1_btn);
        pause1=findViewById(R.id.pause1_btn);
        stop1=findViewById(R.id.stop1_btn);
        home1.setOnClickListener(view -> {
            Intent in =new Intent(getApplicationContext(), MainActivity.class);
            startActivity(in);
            mp1.stop();
        });
        play1.setOnClickListener(this);
        pause1.setOnClickListener(this);
        stop1.setOnClickListener(this);
         mp1=MediaPlayer.create(this,R.raw.goad);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.play1_btn:
                if (mp1.isPlaying()){
                    mp1.stop();
                }
                mp1.start();
                break;
            case R.id.pause1_btn:
                mp1.pause();
                break;
            case R.id.stop1_btn:
                mp1.stop();
                break;
        }
    }
}
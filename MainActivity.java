package tf.iitb.abhangyatra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button goadbtn,rajabtn,teerthbtn,atamehbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        goadbtn=findViewById(R.id.goad_btn);
        goadbtn.setOnClickListener(this);
        rajabtn=findViewById(R.id.kanada_btn);
        rajabtn.setOnClickListener(this);
        teerthbtn=findViewById(R.id.teerth_btn);
        teerthbtn.setOnClickListener(this);
        atamehbtn=findViewById(R.id.aatame_btn);
        atamehbtn.setOnClickListener(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.goad_btn:
                Intent in1 =new Intent(getApplicationContext(), GoadTuzeRoop.class);
                startActivity(in1);
                break;
            case R.id.kanada_btn:
                Intent in2 =new Intent(getApplicationContext(), rajapandharicha.class);
                startActivity(in2);
                break;
            case R.id.teerth_btn:
                Intent in3=new Intent(getApplicationContext(), TeerthVittala.class);
                startActivity(in3);
                break;
            case R.id.aatame_btn:
                Intent in4=new Intent(getApplicationContext(), AataMe.class);
                startActivity(in4);
                break;
        }
    }
}
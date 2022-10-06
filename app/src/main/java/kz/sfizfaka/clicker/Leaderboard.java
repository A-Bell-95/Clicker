package kz.sfizfaka.clicker;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;



public class Leaderboard extends AppCompatActivity {
    TextView ti1;
    TextView ti2;
    TextView ti3;
    TextView ti4;
    TextView ti5;
    TextView pl1;
    TextView pl2;
    TextView pl3;
    TextView pl4;
    TextView pl5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lb);

       // ti1 = findViewById(R.id.ti1);
        pl1 = findViewById(R.id.pl);
        pl2 = findViewById(R.id.pl1);
        ti1 = findViewById(R.id.ti1);
        ti2 = findViewById(R.id.ti2);
        Intent intent = getIntent();

        //String time1 = intent.getStringExtra("time1");
        String name1 = intent.getStringExtra("etname1");
        String name2 = intent.getStringExtra("etname2");
        String time1 = intent.getStringExtra("time1");
        String time2 = intent.getStringExtra("time2");
        pl1.setText(""+name1+ "");
        pl2.setText(""+name2+"");
        ti1.setText(""+time1+"ms");
        ti2.setText(""+time2+"ms");

    }
}
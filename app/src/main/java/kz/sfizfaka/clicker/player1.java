package kz.sfizfaka.clicker;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;



public class player1 extends AppCompatActivity {
    TextView tvView;
    TextView tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pl1);

        tvView = findViewById(R.id.time2);
        tv6 = findViewById(R.id.tv8);
        Intent intent = getIntent();

        String time1 = intent.getStringExtra("time1");
        String name1 = intent.getStringExtra("etname1");
        tv6.setText("Player " + name1 + " WIN !!!");
        tvView.setText("Your time is:" + time1 + " Milisec");

        Intent intent1 = new Intent(this, Leaderboard.class);
        intent1.putExtra("time1",time1);
        intent1.putExtra("etname1",name1);
//
    }
}

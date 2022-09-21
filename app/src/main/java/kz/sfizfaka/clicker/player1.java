package kz.sfizfaka.clicker;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;



public class player1 extends AppCompatActivity {
    TextView tvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pl1);

        tvView = findViewById(R.id.time2);
        Intent intent = getIntent();

        String time1 = intent.getStringExtra("time1");

        tvView.setText("Your time is:" + time1 + " sec");
    }
}

package kz.sfizfaka.clicker;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class player2 extends AppCompatActivity {
    TextView tvView;
    TextView tv8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pl2);

    tvView = findViewById(R.id.time2);
    tv8 = findViewById(R.id.tv8);
    Intent intent = getIntent();

    String time2 = intent.getStringExtra("time2");
    String name2 = intent.getStringExtra("etname2");

    tv8.setText("Player " + name2 + " WIN !!!");
    tvView.setText("Your time is:" + time2 + " Milisec");

    }
}

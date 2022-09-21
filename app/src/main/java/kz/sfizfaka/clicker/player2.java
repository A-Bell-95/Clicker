package kz.sfizfaka.clicker;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class player2 extends AppCompatActivity {
    TextView tvView;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pl2);

    tvView = findViewById(R.id.time2);
    //tv2 = findViewById(R.id.time3);
    Intent intent = getIntent();

    String time2 = intent.getStringExtra("time2");
    //String time3 = intent.getStringExtra("time3");
    tvView.setText("Your time is:" + time2 + " sec");
    //tv2.setText("Your time is:" + time3 + " sec");
    }
}

package kz.sfizfaka.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    String clicknumber = "Ready?";
    String clicknumber1 = "Ready?";
    String sf;
    String sf2;
    int clickcount = 0;
    int clickcount1 = 0;
    Button btn3;
    Button btn4;
    long firstclick;
    long hundclick;
    long finaltime;
    long finaltime1;
    long firstclick1;
    long hundclick1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Button btn = findViewById(R.id.btn);
    btn.setOnClickListener(this);

    Button btn2 = findViewById(R.id.btn2);
    btn2.setOnClickListener(this);

    Button btn5 = findViewById(R.id.btn5);
    btn5.setOnClickListener(this);

    btn3 = findViewById(R.id.btn3);
    btn3.setText(clicknumber);

    btn4 = findViewById(R.id.btn4);
    btn4.setText(clicknumber1);

//    TextView timer = findViewById(R.id.timer);
//    timer.setText("");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
            firstclick = System.currentTimeMillis();
            clickcount = clickcount + 1;
            clicknumber = String.valueOf(clickcount);
            btn4.setText(clicknumber);

                if(clickcount == 100) {
                    hundclick = System.currentTimeMillis();
                    finaltime = (hundclick - firstclick)*100;
                    sf = String.valueOf(finaltime);
                    Intent intent = new Intent(this, player1.class);
                    intent.putExtra("time1",sf);
                    startActivity(intent);
                }
            break;

            case R.id.btn2:
            firstclick1 = System.currentTimeMillis()*100;
            clickcount1 = clickcount1 + 1;
            clicknumber1 = String.valueOf(clickcount1);
            btn3.setText(clicknumber1);
                if(clickcount1 == 100) {
                    hundclick1 = System.currentTimeMillis()*100;
                    finaltime1 = (hundclick1 - firstclick1);
                    sf2 = String.valueOf(finaltime1);
                    Intent intent = new Intent(this, player2.class);
                    intent.putExtra("time2",sf2);
                    startActivity(intent);
                }
            break;

            case R.id.btn5:
            clickcount = 0;
            clickcount1 = 0;
            clicknumber = "Ready?";
            clicknumber1 = "Ready?";
            btn4.setText(clicknumber);
            btn3.setText(clicknumber);
        }
    }
}
package kz.sfizfaka.clicker;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    String clicknumber = "Ready?";
    String clicknumber1 = "Ready?";
    String sf = "";
    String sf1 = "";
    int clickcount = 0;
    int clickcount1 = 0;
    Button btn3,btn4;
    long firstclick,hundclick,finaltime,finaltime1,hundclick1;
    long firstclick1 = 0;
    EditText etn1,etn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    etn1 = findViewById(R.id.etpn1);
    etn2 = findViewById(R.id.etpn2);

    Button btn = findViewById(R.id.btn);
    btn.setOnClickListener(this);

    Button btn2 = findViewById(R.id.btn2);
    btn2.setOnClickListener(this);

    Button btn5 = findViewById(R.id.btn5);
    btn5.setOnClickListener(this);

    Button btnAdv = findViewById(R.id.btnAdv);
    btnAdv.setOnClickListener(this);

    btn3 = findViewById(R.id.btn3);
    btn3.setText(clicknumber);

    btn4 = findViewById(R.id.btn4);
    btn4.setText(clicknumber1);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Leaderboard");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == 1 ){
            Intent intent = new Intent(this, Leaderboard.class);
            intent.putExtra("time1",sf);
            intent.putExtra("etname1",etn1.getText().toString());
            intent.putExtra("time2",sf1);
            intent.putExtra("etname2",etn2.getText().toString());
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

        @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
            clickcount = clickcount + 1;
            clicknumber = String.valueOf(clickcount);
            btn4.setText(clicknumber);
                if(clickcount == 1)
                    firstclick = System.currentTimeMillis();
                if(clickcount == 100) {
                    hundclick = System.currentTimeMillis();
                    finaltime = (hundclick - firstclick);
                    sf = String.valueOf(finaltime);
                    Intent intent = new Intent(this, player1.class);
                    intent.putExtra("time1",sf);
                    intent.putExtra("etname1",etn1.getText().toString());
                    startActivity(intent);
                }
            break;

            case R.id.btn2:
            clickcount1 = clickcount1 + 1;
            clicknumber1 = String.valueOf(clickcount1);
            btn3.setText(clicknumber1);
                if(clickcount1 == 1)
                    firstclick1 = System.currentTimeMillis();
                if(clickcount1 == 100) {
                    hundclick1 = System.currentTimeMillis();
                    finaltime1 = (hundclick1 - firstclick1);
                    sf1 = String.valueOf(finaltime1);
                    //sf3 = String.valueOf(firstclick1);
                    Intent intent = new Intent(this, player2.class);
                    intent.putExtra("time2",sf1);
                    intent.putExtra("etname2",etn2.getText().toString());
                   // intent.putExtra("time3",sf3);
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
            break;

            case R.id.btnAdv:
                Intent intent3;
                intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://lite-1x923400.top/ru"));
                startActivity(intent3);
                break;
        }
    }
}
package kz.sfizfaka.clicker;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Leaderboard extends AppCompatActivity  {
    final String LOG_TAG = "mylogs";

    TextView ti1,ti2,ti3,ti4;
    TextView pl1,pl2,pl3,pl4;

    String name1,name2,time1,time2;

    int itime1,itime2,itime3, itime4 = 0;

    SharedPreferences sPref;

    final String SAVED_NAME1 = "saved_name1";
    final String SAVED_NAME2 = "saved_name2";
    final String SAVED_TIME1 = "saved_time1";
    final String SAVED_TIME2 = "saved_time2";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lb);

        pl1 = findViewById(R.id.pl);
        pl2 = findViewById(R.id.pl1);
        ti1 = findViewById(R.id.ti1);
        ti2 = findViewById(R.id.ti2);
        pl3 = findViewById(R.id.pl3);
        pl4 = findViewById(R.id.pl4);
        ti3 = findViewById(R.id.ti3);
        ti4 = findViewById(R.id.ti4);


        Intent intent = getIntent();

        name1 = intent.getStringExtra("etname1");
        name2 = intent.getStringExtra("etname2");
        time1 = intent.getStringExtra("time1");
        time2 = intent.getStringExtra("time2");

        if(time1.isEmpty())
            time1 = "0";
        if(name1.isEmpty())
            name1 = "No name";
        if(time2.isEmpty())
            time2 = "0";
        if(name2.isEmpty())
        name2 = "No name";
        itime1 = Integer.parseInt(time1);
        itime2 = Integer.parseInt(time2);

        if(itime1 < itime2){
            pl1.setText(""+name1+"");
            ti1.setText(""+time1+ "ms");
            pl2.setText(""+name2+"");
            ti2.setText(""+time2+" ms");
        } else {
            pl1.setText(""+name2+"");
            ti1.setText(""+time2+ " ms");
            pl2.setText(""+name1+"");
            ti2.setText(""+time1+ " ms");
        }
        loadResult();

        String time3 = ti3.getText().toString();
        String tme3 = time3.substring(0,(time3.length()-2));
        itime3 = Integer.parseInt(tme3);

        String time4= ti4.getText().toString();
        String tme4 = time4.substring(0,(time4.length()-2));
        itime4 = Integer.parseInt(tme4);


        //Если время первого игрока меньше время 3 в лидерборде
        if(itime1 < itime3 && itime1 != 0){
            saveResult1();
            loadResult();
        }
        if(itime1 < itime4 && itime1 != 0){
            saveResult1();
            loadResult1_4();
        }

        if(itime2 < itime3 && itime2 != 0){
            saveResult2();
            loadResult2_3();
        }
        if(itime2 < itime4 && itime2 != 0){
            saveResult2();
            loadResult();
        }

    }

    @Override
    public void onDestroy() {

        Toast.makeText(this,"Leaderboard was closed",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
    void saveResult1(){
        sPref = getPreferences(MODE_PRIVATE);
        Editor ed = sPref.edit();

        ed.putString(SAVED_NAME1,pl1.getText().toString());
        ed.putString(SAVED_TIME1,ti1.getText().toString());
        ed.apply();

        Toast.makeText(this, "Gratz, New record!!", Toast.LENGTH_SHORT).show();
    }
    void saveResult2(){
        sPref = getPreferences(MODE_PRIVATE);
        Editor ed = sPref.edit();

        ed.putString(SAVED_NAME2,pl2.getText().toString());
        ed.putString(SAVED_TIME2,ti2.getText().toString());

        ed.apply();

        Toast.makeText(this, "Gratz, New record!!", Toast.LENGTH_SHORT).show();
    }

    void loadResult(){
        sPref = getPreferences(MODE_PRIVATE);

        String savedName1 = sPref.getString(SAVED_NAME1,"");
        pl3.setText(savedName1);
        String savedName2 = sPref.getString(SAVED_NAME2,"");
        pl4.setText(savedName2);
        String savedTime1 = sPref.getString(SAVED_TIME1,"");
        ti3.setText(savedTime1);
        String savedTime2 = sPref.getString(SAVED_TIME2,"");
        ti4.setText(savedTime2);

    }
    void loadResult2_3(){
        sPref = getPreferences(MODE_PRIVATE);

        String savedName2 = sPref.getString(SAVED_NAME2,"");
        pl3.setText(savedName2);

        String savedTime2 = sPref.getString(SAVED_TIME2,"");
        ti3.setText(savedTime2);
    }

    void loadResult1_4(){
        sPref = getPreferences(MODE_PRIVATE);

        String savedName1 = sPref.getString(SAVED_NAME1,"");
        pl4.setText(savedName1);

        String savedTime1 = sPref.getString(SAVED_TIME1,"");
        ti4.setText(savedTime1);
    }

}
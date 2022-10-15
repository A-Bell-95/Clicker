package kz.sfizfaka.clicker;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class Leaderboard extends AppCompatActivity implements OnClickListener {
    TextView ti1;
    TextView ti2;
    TextView ti3;
    TextView ti4;

    TextView pl1;
    TextView pl2;
    TextView pl3;
    TextView pl4;


    String name1;
    String name2;
    String time1;
    String time2;

    Button btnSave;


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


        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);


        Intent intent = getIntent();

        //String time1 = intent.getStringExtra("time1");
        name1 = intent.getStringExtra("etname1");
        name2 = intent.getStringExtra("etname2");
        time1 = intent.getStringExtra("time1");
        time2 = intent.getStringExtra("time2");
        pl1.setText(""+name1+ "");
        pl2.setText(""+name2+"");
        ti1.setText(""+time1+"ms");
        ti2.setText(""+time2+"ms");
        loadResult();

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                saveResult();
                loadResult();
                break;

        }
    }
    @Override
    public void onDestroy() {

        Toast.makeText(this,"Leaderboard was closed",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
    void saveResult(){
        sPref = getPreferences(MODE_PRIVATE);

        // Получение обьекта sPref класса шаред преференс
        // Mode private для настройки доступа
        Editor ed = sPref.edit();


        //Для редактирвоания данных нужен обьект эдитор вызываем его из сПреф
        ed.putString(SAVED_NAME1,pl1.getText().toString());
        ed.putString(SAVED_NAME2,pl2.getText().toString());
        ed.putString(SAVED_TIME1,ti1.getText().toString());
        ed.putString(SAVED_TIME2,ti2.getText().toString());

        ed.apply();

        Toast.makeText(this, "Result saved", Toast.LENGTH_SHORT).show();
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
}
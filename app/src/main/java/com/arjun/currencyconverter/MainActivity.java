package com.arjun.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String currency[]={"Rupees","Euros","Dollars"};
    double convert[][]={{1.0,0.013,0.014},{79.37,1.0,1.11},{71.71,0.90,1.0}};

    public void convertCur(View view) {
        String from,to;
        int f=0,t=0;
        double converted;
        EditText fromCur = (EditText) findViewById(R.id.fromCur);
        EditText toCur = (EditText) findViewById(R.id.toCur);
        EditText amount = (EditText) findViewById(R.id.amount);

        converted= Double.parseDouble(amount.getText().toString());

        from=fromCur.getText().toString();
        to=toCur.getText().toString();

        for(int i=0;i<3;i++) {
            if (from.equalsIgnoreCase(currency[i]))
                f = i;
            if (to.equalsIgnoreCase(currency[i]))
                t = i;
        }
        converted=converted*convert[f][t];


        Log.i("From:",from);
        Log.i("To:",to);
        Log.i("From index:",Integer.toString(f));
        Log.i("To index:",Integer.toString(t));

        String finalCur = String.format("%.02f", converted);

        Toast.makeText(MainActivity.this, finalCur+" "+currency[t], Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

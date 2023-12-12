package com.example.ryba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button pies, ryba, kaczka, swinia, reset;
    ImageView img, ser1, ser2, ser3;
    TextView wynik, end;
    int zycie=3,im = 1, points = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pies = findViewById(R.id.pies);
        ryba = findViewById(R.id.ryba);
        kaczka = findViewById(R.id.kaczka);
        swinia = findViewById(R.id.swinia);
        img = findViewById(R.id.image);
        wynik = findViewById(R.id.wynik);
        end = findViewById(R.id.kon);

        reset = findViewById(R.id.reset);
        ser1 = findViewById(R.id.ser1);
        ser2 = findViewById(R.id.ser2);
        ser3 = findViewById(R.id.ser3);


        pies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (im == 2) {
                    im = 3;
                    img.setImageResource(R.drawable.ryba);
                    plus();
                } else {
                    im = 3;
                    img.setImageResource(R.drawable.ryba);
                    minus();
                    if(zycie==0) ko();
                }
            }
        });
        ryba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (im == 3) {
                    im = 4;
                    img.setImageResource(R.drawable.swinia);
                    plus();
                } else {
                    im = 4;
                    img.setImageResource(R.drawable.swinia);
                    minus();
                    if(zycie==0) ko();
                }
            }
        });
        swinia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (im == 4) {
                    im = 1;
                    img.setImageResource(R.drawable.kaczka);
                    plus();
                } else {
                    im = 1;
                    img.setImageResource(R.drawable.kaczka);
                    minus();
                    if(zycie==0) ko();
                }
            }
        });
        kaczka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (im == 1) {
                    im = 2;
                    img.setImageResource(R.drawable.pies);
                    plus();

                } else {
                    im = 2;
                    img.setImageResource(R.drawable.pies);
                    minus();
                    if(zycie==0) ko();

                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zycie = 3;

                points = 0;
                wynik.setText(Integer.toString(points));
                end.setText("");
                pies.setEnabled(true);
                ryba.setEnabled(true);
                kaczka.setEnabled(true);
                swinia.setEnabled(true);
                ser1.setVisibility(View.VISIBLE);
                ser2.setVisibility(View.VISIBLE);
                ser3.setVisibility(View.VISIBLE);

            }
        });


    }
    void ko(){
        end.setText("Koniec");
        pies.setEnabled(false);
        ryba.setEnabled(false);
        kaczka.setEnabled(false);
        swinia.setEnabled(false);
    }
    void minus(){
        zycie--;

        if(zycie==2){
            ser3.setVisibility(View.INVISIBLE);
        }
        else if(zycie == 1){
            ser2.setVisibility(View.INVISIBLE);
        }
        else if(zycie==0){
            ser1.setVisibility(View.INVISIBLE);
        }
    }
    void plus(){
        points++;
        wynik.setText(Integer.toString(points));
    }
}
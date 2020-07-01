package com.example.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout bulb1, bulb2, bulb3;
    private Button button;
    private boolean startStop = false;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.buttonStart);
        bulb1 = findViewById(R.id.bulb1);
        bulb2 = findViewById(R.id.bulb2);
        bulb3 = findViewById(R.id.bulb3);

    }

    public void onClickStart(View view) {
        //bulb1.setBackgroundColor(Color.BLUE);
        if (!startStop) {
            startStop = true;
            button.setText("Stop");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (startStop) {
                        counter++;
                        switch (counter) {
                            case 1:
                                bulb1.setBackgroundColor(Color.RED);
                                bulb2.setBackgroundColor(Color.GRAY);
                                bulb3.setBackgroundColor(Color.GRAY);
                                break;
                            case 2:
                                bulb1.setBackgroundColor(Color.GRAY);
                                bulb2.setBackgroundColor(Color.YELLOW);
                                bulb3.setBackgroundColor(Color.GRAY);
                                break;
                            case 3:
                                bulb1.setBackgroundColor(Color.GRAY);
                                bulb2.setBackgroundColor(Color.GRAY);
                                bulb3.setBackgroundColor(Color.GREEN);
                                counter=0;
                                break;
                        }

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } else {
            startStop = false;
            button.setText("Start");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startStop = false;
    }
}
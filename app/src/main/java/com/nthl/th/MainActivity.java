package com.nthl.th;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;
    private Button btnFalse;
    private Button btnTrue;
    private Button btnBack;
    private Button btnNext;

    private Question questionArray[] = {
            new Question("1+2=3", true),
            new Question("3*5=14", false),
            new Question("5/5=1", true)
    };
    private int current = 0;
    private int maxOfQues = Array.getLength(questionArray);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txtView);
        btnFalse = findViewById(R.id.btnFalse);
        btnTrue = findViewById(R.id.btnTrue);
        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);

        txtView.setText(questionArray[current].getQuestion());
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "clicked False",
                        Toast.LENGTH_SHORT).show();

            }
        });
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "clicked True",
                        Toast.LENGTH_SHORT).show();

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtView.setText(questionArray[current].getQuestion());
                if (current < maxOfQues - 1)
                    current++;
                else
                    current = 0;
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtView.setText(questionArray[current].getQuestion());
                if (current > 0)
                    current--;
                else
                    current = maxOfQues - 1;
            }
        });

    }

}
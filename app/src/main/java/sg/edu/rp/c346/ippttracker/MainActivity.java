package sg.edu.rp.c346.ippttracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnPU;
    Button btnSU;
    Button btnChart;
    Button btnHowTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPU = (Button)findViewById(R.id. buttonPU);
        btnSU = (Button)findViewById(R.id. buttonSU);
        btnChart = (Button)findViewById(R.id. buttonChart);
        btnHowTo = (Button)findViewById(R.id. buttonRequirement);

        btnHowTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IPPT_Requirement.class);
                startActivity(intent);
            }
        });

        btnPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StartCount.class);
                intent.putExtra("header","Push Up Counter");
                startActivity(intent);
            }
        });

        btnSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StartCount.class);
                intent.putExtra("header","Sit Up Counter");
                startActivity(intent);
            }
        });

        btnChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChartImage.class);
                startActivity(intent);
            }
        });
    }
}

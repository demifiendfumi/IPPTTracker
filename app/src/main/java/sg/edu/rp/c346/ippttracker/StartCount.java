package sg.edu.rp.c346.ippttracker;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class StartCount extends Activity {
    TextView txHeader;
    Button btnBack;
    TextView txTime;
    TextView txtnum;
    Button btnClick;
    Button btnMinus;
    ToggleButton tgbtnStartStop;
    Button btnRestart;
    CountDownTimer myCountDownTimerObject;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start_count);
        txHeader = (TextView)findViewById(R.id. textViewTitle);
        btnBack = (Button)findViewById(R.id. buttonBack);
        txtnum = (TextView)findViewById(R.id. textView);
        txTime = (TextView)findViewById(R.id. textViewTimer);
        btnClick = (Button)findViewById(R.id. buttonClick);
        btnMinus = (Button)findViewById(R.id. buttonMinus);
        tgbtnStartStop = (ToggleButton)findViewById(R.id. toggleButtonStartStop);
        btnRestart = (Button)findViewById(R.id. buttonRestart);

        txtnum.setText(String.valueOf(count));
        Intent intentReceived = getIntent();
        String value = intentReceived.getStringExtra("header");
        txHeader.setText(value);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(StartCount.this, MainActivity.class);
                startActivity(back);
            }
        });

        tgbtnStartStop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myCountDownTimerObject = new CountDownTimer(61000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            txTime.setText("" + millisUntilFinished / 1000);
                        }

                        public void onFinish() {
                            Intent intent = new Intent(getBaseContext(), Count_Number.class);
                            intent.putExtra("count",count);
                            startActivity(intent);
                        }
                    }.start();
                } else {
                    myCountDownTimerObject.cancel();
                }
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txTime.setText("60");
                txtnum.setText("0");
            }
        });

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tgbtnStartStop.isChecked()){
                    count += 1;
                    txtnum.setText(String.valueOf(count));
                }

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count == 0){
                    count = 0;
                }else{
                    if(tgbtnStartStop.isChecked()) {
                        count -= 1;
                        txtnum.setText(String.valueOf(count));
                    }
                }
            }
        });
    }
}

package sg.edu.rp.c346.ippttracker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Count_Number extends Activity {
    TextView title;
    TextView message;
    TextView countNum;
    Button homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count__number);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        title = (TextView)findViewById(R.id. textViewHeader);
        message = (TextView)findViewById(R.id. textViewMsg);
        countNum = (TextView)findViewById(R.id. textViewCount);
        homeBtn = (Button)findViewById(R.id. buttonHome);

        message.setText("Your total push up/sit-up is:");
        int value = getIntent().getIntExtra("count", 0);
        countNum.setText(String.valueOf(value));

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Count_Number.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

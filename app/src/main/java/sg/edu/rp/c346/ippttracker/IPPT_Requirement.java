package sg.edu.rp.c346.ippttracker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class IPPT_Requirement extends AppCompatActivity {
    TextView howTo;
    Button back;
    TextView requirements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ippt__requirement);

        howTo = (TextView)findViewById(R.id. textViewHowTo);
        back = (Button)findViewById(R.id. button_home);
        requirements = (TextView)findViewById(R.id. textViewRequirement);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(IPPT_Requirement.this, MainActivity.class);
                startActivity(back);
            }
        });

    }
}

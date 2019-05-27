package com.example.death;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText user,tray;
    Button submit;
    int no,tr;
    TextView warn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submit);
        warn=(TextView)   findViewById(R.id.warn);
        user=(EditText)   findViewById(R.id.user);
        tray=(EditText)   findViewById(R.id.tray);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                no=Integer.parseInt(user.getText().toString());
                tr=Integer.parseInt(tray.getText().toString());
                if((no>0&&no<=100)&&(tr>0&&tr<=100))
                openactivity2();
                else
                    warn.setText("age and no of tries should be btw 1-100");
            }
        });

}
    public void openactivity2()

    {
    Bundle bundle=new Bundle();
    bundle.putInt("key",no);
    bundle.putInt("key2",tr);
    Intent intent=new Intent(this,Death2.class);
    intent.putExtras(bundle);
    startActivity(intent);
    }
}


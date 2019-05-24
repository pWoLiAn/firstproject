package com.example.death;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText user,tray;
    Button submit;
    int no,tr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openactivity2();
            }
        });

}
    public void openactivity2()

    {
    user=(EditText) findViewById(R.id.user);
    tray=(EditText) findViewById(R.id.tray);
    no=Integer.parseInt(user.getText().toString());
    tr=Integer.parseInt(tray.getText().toString());
    Bundle bundle=new Bundle();
    bundle.putInt("key",no);
    bundle.putInt("key2",tr);
    Intent intent=new Intent(this,Death2.class);
    intent.putExtras(bundle);
    startActivity(intent);
    }
}


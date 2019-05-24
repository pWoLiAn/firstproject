package com.example.death;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




     EditText user;
     Button submit;
     int no;




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
    no=Integer.parseInt(user.getText().toString());
    Bundle bundle=new Bundle();
    bundle.putInt("key",no);
    Intent intent=new Intent(this,Death2.class);
    intent.putExtras(bundle);
    startActivity(intent);

}
}


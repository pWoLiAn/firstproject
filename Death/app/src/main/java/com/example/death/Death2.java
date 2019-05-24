package com.example.death;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class Death2 extends AppCompatActivity {




    int no,g,counter=5;
   Button check;
   TextView Info;
   EditText guess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death2);


       Intent intent=getIntent();
       Bundle bundle=intent.getExtras();
       if(bundle==null){
           return;
       }
       no=bundle.getInt("key");


        Info=(TextView)  findViewById(R.id.result);
        check= (Button)  findViewById(R.id.check);

        guess=(EditText)  findViewById(R.id.guess);
        g=Integer.parseInt(guess.getText().toString());



        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate();
            }
        });
    }
             public void validate() {


                 if (counter > 0) {
                     if (g > no) {
                         Info.setText("higher");
                         counter--;
                     } else if (g < no) {
                         Info.setText("lower");
                         counter--;
                     } else if (g == no) {
                         Info.setText("Correct guess.Please go back to Main activity.");
                     }
                 } else
                     Info.setText("You lost.Go back to Main activity");

             }
}

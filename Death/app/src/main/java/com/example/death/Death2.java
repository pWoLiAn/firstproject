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

   int no,g,tr;
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
        tr=bundle.getInt("key2");

        Info=(TextView)  findViewById(R.id.result);
        check= (Button)  findViewById(R.id.check);
        guess=(EditText) findViewById(R.id.guess);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g = Integer.parseInt(guess.getText().toString());
                validate();
            }

        });
    }
             public void validate() {

                 if (tr > 0) {
                     if (g > no) {
                         Info.setText("Your guess is greater");
                         tr--;
                     } else if (g < no) {
                         Info.setText("Your guess is lower");
                         tr--;
                     } else if (g == no) {
                         Info.setText("Correct guess.Go back & enter age of next person.");
                     }
                 } else
                     Info.setText("You lost.Go back & enter age of next person.");

             }
}

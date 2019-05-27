package com.example.death;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Death2 extends AppCompatActivity {

    int no, g, tr, won, loss;
    Button check;
    TextView Info, total;
    EditText guess;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        no = bundle.getInt("key");
        tr = bundle.getInt("key2");

        view=this.getWindow().getDecorView();
        Info = (TextView) findViewById(R.id.result);
        total = (TextView) findViewById(R.id.total);
        check = (Button) findViewById(R.id.check);
        guess = (EditText) findViewById(R.id.guess);
        prefs = getPreferences(Context.MODE_PRIVATE);
        editor = prefs.edit();
        won = prefs.getInt("won", 0);
        loss = prefs.getInt("loss", 0);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g = Integer.parseInt(guess.getText().toString());
                if(g>0&&g<=100)
                validate();
                else
                    Info.setText("guess should be btw 1-100");
            }

        });
    }

    public void validate() {

           if (tr > 0) process: {
            if (g > no) {
                view.setBackgroundResource(R.color.red);
                Info.setText("Your guess is greater");
                --tr;
                if (tr<1) break process;
            } else if (g < no) {
                view.setBackgroundResource(R.color.red);
                Info.setText("Your guess is lower");
                --tr;
                if (tr<1) break process;
            } else if (g == no) {
                view.setBackgroundResource(R.color.green);
                Info.setText("Correct guess.Go back & enter age of next person.");
                won++;
                total.setText("You have won a total of " + won + " times");
                editor.putInt("won", won);
                editor.commit();
            }
        } if(tr<1) {
            Info.setText("You lost.Go back & enter age of next person.");
            loss++;
            total.setText("You have lost a total of " + loss + " times");
            editor.putInt("loss", loss);
            editor.commit();

        }
    }
}

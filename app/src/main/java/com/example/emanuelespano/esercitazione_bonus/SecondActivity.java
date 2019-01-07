package com.example.emanuelespano.esercitazione_bonus;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class SecondActivity extends AppCompatActivity {

    User user;
    TextView welcome;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_welcome);
        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(MainActivity.USER_EXTRA);
        welcome = (TextView) findViewById(R.id.msg);
        back = (Button) findViewById(R.id.back);

        if (obj instanceof User)
            user = (User) obj;
        else
            user = new User();

        if (!boolMatch(user)) {
            welcome.setText("Credenziali"+"\n"+"non valide");
            welcome.setTextColor(Color.parseColor("red"));
        }
        else
            welcome.setText("Benvenuto " +user.getUsername());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(mainActivity);
            }
        });
    }
    private boolean boolMatch (User usr) {
        UserFactory users = UserFactory.getInstance();

        for (User item : users.getUsers())
            if (item.equals(usr))
                return true;

        return false;
    }




}




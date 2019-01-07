package com.example.emanuelespano.esercitazione_bonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    User user = new User();
    EditText username, password;
    Button login;
    TextView error;
    public static final String USER_EXTRA = "com.example.emanuelespano.esercitazione_bonus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValues()) {
                    updateUser();
                    Intent welcomeActivity = new Intent(MainActivity.this,SecondActivity.class);
                    welcomeActivity.putExtra(USER_EXTRA, user);
                    startActivity(welcomeActivity);
                }
            }
        });
    }
        private boolean checkValues() {
            int errors = 0;
            User user = new User(new String (String.valueOf(username.getText())),
                       new String(String.valueOf(password.getText())));

            if (username.getText() == null || username.getText().length() == 0) {
                username.setError("Inserire il proprio username");
                errors++;
            }
            else
                username.setError(null);

            if (password.getText() == null || password.getText().length() == 0) {
                password.setError("Inserire la password");
                errors++;
            }

            else
                password.setError(null);

            return errors == 0;
        }

        private void updateUser() {
            user.setUsername(username.getText().toString());
            user.setPassword(password.getText().toString());
        }

    public void sendMessage(View view) {

    }
}


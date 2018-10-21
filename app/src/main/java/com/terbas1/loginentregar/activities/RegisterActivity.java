package com.terbas1.loginentregar.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.terbas1.loginentregar.R;

import com.terbas1.loginentregar.repository.UserRepository;


public class RegisterActivity extends AppCompatActivity {
    private EditText fullnameInput;
    private EditText emailInput;
    private EditText passwordInput;
    private EditText usernameInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usernameInput = (EditText)findViewById(R.id.username_input);
        fullnameInput = (EditText)findViewById(R.id.fullname_input);
        emailInput = (EditText)findViewById(R.id.email_input);
        passwordInput = (EditText)findViewById(R.id.password_input);


    }

    public void callRegister(View view){
        String username = usernameInput.getText().toString();
        String fullname = fullnameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(username.isEmpty() || fullname.isEmpty() || email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Comple todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        UserRepository.create(username,fullname, email, password);

        startActivity(new Intent(this, MainActivity.class));

    }

    public void cancelar(View view){

        startActivity(new Intent(this, MainActivity.class));
    }

}

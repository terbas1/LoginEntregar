package com.terbas1.loginentregar.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.terbas1.loginentregar.R;
import com.terbas1.loginentregar.models.User;
import com.terbas1.loginentregar.repository.UserRepository;


public class MainActivity extends AppCompatActivity {

    private static final String TAG="Pruebas";
    private SharedPreferences sharedPreferences;
    private EditText usernameInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameInput = (EditText)findViewById(R.id.username_input);
        passwordInput = (EditText)findViewById(R.id.password_input);
        // init SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);



        // username remember
        String username = sharedPreferences.getString("username", null);
        if(username != null){
            usernameInput.setText(username);
            passwordInput.requestFocus();
        }

        // islogged remember
        if(sharedPreferences.getBoolean("islogged", false)){
            // Go to Dashboard
            goDashboard();
        }


    }

    public void callLogin(View view){
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();



        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Completa todso lso campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Login logic
        User user = UserRepository.login(username, password);

        if(user == null){
            Toast.makeText(this, "Usuario Invalido", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Bienvenido " + user.getFullname(), Toast.LENGTH_SHORT).show();

        // Save to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean success = editor
                .putString("username", user.getUsername())
                .putBoolean("islogged", true)
                .commit();

        // Go to Dashboard
        goDashboard();
    }


    private void goDashboard(){
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }

    public void goRegister(View view){
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

}

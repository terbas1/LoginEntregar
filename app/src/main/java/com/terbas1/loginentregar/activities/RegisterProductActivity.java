package com.terbas1.loginentregar.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.terbas1.loginentregar.R;
import com.terbas1.loginentregar.models.User;
import com.terbas1.loginentregar.repository.ProductRepository;
import com.terbas1.loginentregar.repository.UserRepository;

public class RegisterProductActivity extends AppCompatActivity {
    private EditText product_name_Input;
    private EditText product_price_Input;
    private EditText product_desc_Input;

    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);
        product_name_Input  = findViewById(R.id.product_name_input);
        product_price_Input = findViewById(R.id.product_price_input);
        product_desc_Input  = findViewById(R.id.product_description_input);

    }

    public void callRegister(View view){

        // init SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        // get username from SharedPreferences
        String username = sharedPreferences.getString("username", null);

        //Get Parameters from Current USER
        User user = UserRepository.getUser(username);
        assert user != null;

        String product_name = product_name_Input.getText().toString();
        String product_price = product_price_Input.getText().toString();
        String product_desc = product_desc_Input.getText().toString();
        String product_state = "";
        Long id_user = user.getId();





        if(product_name.isEmpty() ||product_price.isEmpty() || product_desc.isEmpty()){
            Toast.makeText(this, "You must complete all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        ProductRepository.create( product_name, product_price, product_desc, product_state, id_user);
        startActivity(new Intent(this, DashboardActivity.class));
        finish();

    }

    public void cancelar(View view) {
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }



}

package com.example.hoangduy.demoview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FacebookLogin extends AppCompatActivity {

    EditText txtemail;
    EditText txtpassword;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login);
        txtemail = (EditText) findViewById(R.id.email);
        txtpassword = (EditText) findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("email", txtemail.getText().toString());
                intent.putExtra("password", txtpassword.getText().toString());
                Log.i("abc", txtemail.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}

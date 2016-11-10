package com.example.hoangduy.demoview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FacebookLogin extends AppCompatActivity {

    private EditText mEtemail;
    private EditText mEtpassword;
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    Button mBtnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login);
        mEtemail = (EditText) findViewById(R.id.etemail);
        mEtpassword = (EditText) findViewById(R.id.etpassword);
        mBtnlogin = (Button) findViewById(R.id.btnlogin);
        mBtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(KEY_EMAIL, mEtemail.getText().toString());
                intent.putExtra(KEY_PASSWORD, mEtpassword.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

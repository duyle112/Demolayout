package com.example.hoangduy.demoview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImgregister;
    private ImageView mImgfblogin;
    private EditText mEtusername;
    private EditText mEtpassword;
    public static final int REQUEST_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init() {
        mEtusername = (EditText) findViewById(R.id.etusername);
        mEtpassword = (EditText) findViewById(R.id.etpassword);
        mImgregister = (ImageView) findViewById(R.id.imgreg);
        mImgfblogin = (ImageView) findViewById(R.id.imgfb);
        mImgfblogin.setOnClickListener(this);
        mImgregister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgfb:
                loginByFb();
                break;
            case R.id.imgreg:
                signUp();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK && data != null) {
                Log.i("inline","aa");
                mEtusername.setText(data.getStringExtra(FacebookLogin.KEY_EMAIL));
                mEtpassword.setText(data.getStringExtra(FacebookLogin.KEY_PASSWORD));
            }
        }
    }

    public void loginByFb() {
        Intent intent = new Intent(Login.this, FacebookLogin.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void signUp() {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
}

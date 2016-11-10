package com.example.hoangduy.demoview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener{

    ImageView imgreg;
    ImageView imgfblogin;
    TextView txtusername;
    TextView txtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init() {
        txtusername = (TextView) findViewById(R.id.txtusername);
        txtpassword = (TextView) findViewById(R.id.txtpassword);
        imgreg = (ImageView) findViewById(R.id.imgreg);
        imgfblogin = (ImageView) findViewById(R.id.imgfb);
        imgfblogin.setOnClickListener(this);
        imgreg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgfb:  loginByFb();
                 break;
            case R.id.imgreg: signUp();
                 break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK && data != null) {
                txtusername.setText(data.getStringExtra("email"));
                txtpassword.setText(data.getStringExtra("password"));
            }
        }
    }

    public void loginByFb()
    {
        Intent intent=new Intent(Login.this, FacebookLogin.class);
        startActivityForResult(intent,1);
    }

    public void signUp()
    {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
}

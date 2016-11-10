package com.example.hoangduy.demoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    TextView txtusername;
    TextView txtemail;
    TextView txtpassword;
    TextView txtgender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        txtusername = (TextView) findViewById(R.id.username);
        txtemail = (TextView) findViewById(R.id.email);
        txtpassword = (TextView) findViewById(R.id.password);
        txtgender = (TextView) findViewById(R.id.gend);
        Bundle bundle=getIntent().getBundleExtra("bundle");
        txtemail.setText(bundle.getString("email"));
        txtusername.setText(bundle.getString("username"));
        txtpassword.setText(bundle.getString("password"));
        txtgender.setText(bundle.getString("gender"));

    }
}

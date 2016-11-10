package com.example.hoangduy.demoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    private TextView mTvusername;
    private TextView mTvemail;
    private TextView mTvpassword;
    private TextView mTvgender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        mTvusername = (TextView) findViewById(R.id.tvusernamedisplay);
        mTvemail = (TextView) findViewById(R.id.tvemaildisplay);
        mTvpassword = (TextView) findViewById(R.id.tvpassworddisplay);
        mTvgender = (TextView) findViewById(R.id.tvgenddislay);
        Bundle bundle = getIntent().getBundleExtra(Register.KEY_BUNDLE);
        mTvemail.setText(bundle.getString(FacebookLogin.KEY_EMAIL));
        mTvusername.setText(bundle.getString(Register.KEY_USER));
        mTvpassword.setText(bundle.getString(FacebookLogin.KEY_PASSWORD));
        mTvgender.setText(bundle.getString(Register.KEY_GENDER));

    }
}

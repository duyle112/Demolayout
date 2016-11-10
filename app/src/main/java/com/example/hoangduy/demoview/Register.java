package com.example.hoangduy.demoview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class Register extends AppCompatActivity {

    private EditText mEtemail;
    private EditText mEtusername;
    private EditText mEpassword;
    private Switch maSwitch;
    private RadioGroup mRadioGroup;
    private RadioButton mRdbMale;
    private RadioButton mRdbFemale;
    private Button mBtnstart;
    public static final String KEY_GENDER = "gender";
    public static final String KEY_USER = "username";
    public static final String KEY_BUNDLE = "bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        mBtnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(FacebookLogin.KEY_EMAIL, mEtemail.getText().toString());
                bundle.putString(KEY_USER, mEtusername.getText().toString());
                bundle.putString(FacebookLogin.KEY_PASSWORD, mEpassword.getText().toString());
                if (mRdbMale.isChecked()) {
                    bundle.putString(KEY_GENDER, mRdbMale.getText().toString());
                } else {
                    bundle.putString(KEY_GENDER, mRdbFemale.getText().toString());
                }
                Intent intent = new Intent(Register.this, Display.class);
                intent.putExtra(KEY_BUNDLE, bundle);
                startActivity(intent);
            }
        });

        maSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    mEpassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                } else {
                    mEpassword.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });
    }


    public void init() {
        mBtnstart = (Button) findViewById(R.id.btnsignup);
        mEtemail = (EditText) findViewById(R.id.etemail);
        mEpassword = (EditText) findViewById(R.id.etpassword);
        mEtusername = (EditText) findViewById(R.id.etusername);
        maSwitch = (Switch) findViewById(R.id.swpass);
        mRadioGroup = (RadioGroup) findViewById(R.id.rdgroup);
        mRdbMale = (RadioButton) findViewById(R.id.rdbmale);
        mRdbFemale = (RadioButton) findViewById(R.id.rdbfemale);
    }
}

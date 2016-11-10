package com.example.hoangduy.demoview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class Register extends AppCompatActivity {

    EditText edtemail;
    EditText edtusername;
    EditText edtpassword;
    Switch aSwitch;
    RadioGroup radioGroup;
    RadioButton rdbMale;
    RadioButton rdbFemale;
    Button btnstart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("email", edtemail.getText().toString());
                bundle.putString("username", edtusername.getText().toString());
                bundle.putString("password", edtpassword.getText().toString());
                if (rdbMale.isChecked()) {
                    bundle.putString("gender", rdbMale.getText().toString());
                }
                else {
                    bundle.putString("gender", rdbFemale.getText().toString());
                }
                Intent intent = new Intent(Register.this, Display.class);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    edtpassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD|InputType.TYPE_CLASS_TEXT);
                    Log.i("abc","off");
                }
                else {
                    edtpassword.setInputType(InputType.TYPE_CLASS_TEXT);
                    Log.i("abc","on");
                }
            }
        });
    }


    public void init() {
        btnstart = (Button) findViewById(R.id.btnsignup);
        edtemail = (EditText) findViewById(R.id.txtemail);
        edtpassword = (EditText) findViewById(R.id.txtpassword);
        edtusername = (EditText) findViewById(R.id.txtusername);
        aSwitch = (Switch) findViewById(R.id.swpass);
        radioGroup = (RadioGroup) findViewById(R.id.rdgroup);
        rdbMale = (RadioButton) findViewById(R.id.rdbmale);
        rdbFemale = (RadioButton) findViewById(R.id.rdbfemale);
    }
}

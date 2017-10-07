package com.example.ayush.sharedprefapplication;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_save = (Button) findViewById(R.id.button);
        final EditText et_name = (EditText) findViewById(R.id.editText);
        final EditText et_email = (EditText) findViewById(R.id.editText2);
        final EditText et_phoneNumber = (EditText) findViewById(R.id.editText3);
        final EditText et_city = (EditText) findViewById(R.id.editText4);
        final String[] name = new String[1];
        final String[] email = new String[1];
        final String[] phoneNumber = new String[1];
        final String[] city = new String[1];
        final SharedPreferences sp = getSharedPreferences("pref", MODE_PRIVATE);
        //Intializes all the objects as well as the SharedPreference

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!sp.equals(null)){
                    SharedPreferences.Editor pfEdit = sp.edit();
                    name[0]= et_name.getText().toString();
                    email[0] = et_email.getText().toString();
                    phoneNumber[0] = et_phoneNumber.getText().toString();
                    city[0] = et_city.getText().toString();
                    //gets info from the edittexts
                    pfEdit.putString("name", name[0]);
                    pfEdit.putString("email",email[0]);
                    pfEdit.putString("phoneNumber",phoneNumber[0]);
                    pfEdit.putString("city",city[0]);
                    pfEdit.commit();
                    //puts it into the sharedPreference
                    Toast.makeText(MainActivity.this, "Information saved!", Toast.LENGTH_LONG).show();
                    //displays toast to confirm
                }
            }
        });

        Button bt_displayInfo = (Button) findViewById(R.id.button2);
        bt_displayInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv_name =(TextView) findViewById(R.id.tv_name);
                TextView tv_email =(TextView) findViewById(R.id.tv_email);
                TextView tv_phoneNumber =(TextView) findViewById(R.id.tv_phoneNumber);
                TextView tv_city = (TextView) findViewById(R.id.tv_city);

                String name = sp.getString("name",null);
                String email = sp.getString("email", null);
                String phoneNumber = sp.getString("phoneNumber", null);
                String city = sp.getString("city",null);
                //gets info from sharedPref and stores it in a string

                Toast.makeText(MainActivity.this, "Name: " + name + ", Email Address: " + email + ", Phone Number: " + phoneNumber
                        + ", City:" + city, Toast.LENGTH_LONG).show();
                //finally displays the data

            }
        });
    }



}

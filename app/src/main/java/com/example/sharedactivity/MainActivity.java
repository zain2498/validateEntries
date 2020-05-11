package com.example.sharedactivity;

import android.content.DialogInterface;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sharedactivity.R;

public class MainActivity extends AppCompatActivity {

    EditText firstName,lastName,pass,email,repass;
    Button signUp, ext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText)findViewById(R.id.Edt_frstName);
        lastName = (EditText)findViewById(R.id.Edt_lstName);
        pass = (EditText) findViewById(R.id.Edt_pass);
        repass = (EditText) findViewById(R.id.Edt_repass);
        email = findViewById(R.id.Edt_email);


        signUp = findViewById(R.id.Btn_SignUp);
        ext = findViewById(R.id.Btn_Exit);

        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure You wants to Exit");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                    AlertDialog alert = builder.create();
                    alert.show();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
       
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(firstName)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
        }

       else if (isEmpty(lastName)) {
            lastName.setError("Last name is required!");
        }

       else if (isEmail(email) == false) {
            email.setError("Enter valid email!");
        }

       else if (isEmpty(pass)){
            Toast.makeText(this, "You must enter password to register!", Toast.LENGTH_SHORT).show();
        }
       else if(isEmpty(repass))
        {
            repass.setError("Re enter the password ");
        }
        else{
                  Toast.makeText( getApplicationContext(), " Register successfully ", Toast.LENGTH_SHORT).show();
        }
    }
}

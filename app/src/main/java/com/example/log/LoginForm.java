package com.example.log;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginForm extends AppCompatActivity {

    TextInputEditText loginuser, loginpassword;
    Button btnlogin;
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        loginuser= findViewById(R.id.login_user);
        loginpassword= findViewById(R.id.login_password);
        btnlogin= findViewById(R.id.btn_login);
        dBmain= new DBmain(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = loginuser.getText().toString();
                String pass = loginpassword.getText().toString();
                if(user.equals("")||pass.equals("")){
                    Toast.makeText(LoginForm.this,"Empty field not allow", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkuserpass = checkuserpassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginForm.this,"Login successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Welcome.class));

                    }else{
                        AlertDialog.Builder builder= new AlertDialog.Builder(LoginForm.this);
                        builder.setTitle("Error message");
                        builder.setMessage("Password and username are wrong");
                        builder.setIcon(R.drawable.ic_baseline_error_24);
                        builder.setPositiveButton("OK",null);
                        builder.setCancelable(true);

                        final AlertDialog alertDialog= builder.create();
                        alertDialog.show();

                        alertDialog.getWindow().setGravity(Gravity.TOP);
                    }
                }

            }
        });
    }

    private Boolean checkuserpassword(String user, String pass) {
        sqLiteDatabase=dBmain.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select *from users where username=? and password=?",new String[]{user,pass});

        if (cursor.getCount()>0){
            return  true;
        }else{
            return false;
        }
    }

    public void Regi(View view){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
package com.example.log;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText username, password, repassword;
    Button registration;
    TextView loginform;
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(TextInputEditText)findViewById(R.id.username);
        password=(TextInputEditText)findViewById(R.id.password);
        repassword=(TextInputEditText)findViewById(R.id.repassword);
        loginform=(TextView)findViewById(R.id.login_form);
        registration=(Button)findViewById(R.id.btnregi);

        dBmain= new DBmain(this);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= username.getText().toString();
                String pass= password.getText().toString();
                String repass= repassword.getText().toString();

                if(username.getText().toString().length()<=0){
                    username.setError("Please set username");
                }else if (password.getText().toString().length()<=0){
                    password.setError("Please set Password");
                }else if (repassword.getText().toString().length()<=0){
                    repassword.setError("Please set Repassword");
                }else if (username.equals("")||password.equals("")||repassword.equals("")){
                    Toast.makeText(MainActivity.this, "Empty field not allow", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(repass)){
                        Boolean checkuser = checkusername(user);
                        if(checkuser==false){
                            Boolean insert = insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(MainActivity.this, "Registration successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),LoginForm.class));
                            }else{
                                Toast.makeText(MainActivity.this, "Registration failure", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "User name already exists", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Try Again");
                        builder.setIcon(R.drawable.ic_baseline_error_24);
                        builder.setMessage("Password not Match");
                        builder.show();
                    }
                }

            }
        });
        loginform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginForm.class));

            }
        });
    }

    private Boolean insertData(String user, String pass) {
        sqLiteDatabase=dBmain.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",pass);

        long rec= sqLiteDatabase.insert("users",null, contentValues);
        if(rec==-1){
            return false;
        }else {
            return true;
        }



    }

    private Boolean checkusername(String user) {
        sqLiteDatabase=dBmain.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select *from users where username=?",new String[]{user});
          if(cursor.getCount()>0) {
              return true;
          } else{
                  return false;

              }
          }
    }

package com.mtmi.listview;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginPage extends AppCompatActivity  {

    EditText userName;
    EditText password;
    TextView view;
    Button signIn;
    Button facebook;
    Button google;
    String admin = "1";
    private FirebaseAuth mAuth ;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mAuth=FirebaseAuth.getInstance();



        userName = (EditText) findViewById(R.id.UserName);
        password = (EditText) findViewById(R.id.Password);
        signIn = (Button) findViewById(R.id.signIn);
        view = (TextView) findViewById(R.id.textView);

    }

    public void tikla(View v) {
      String mail=userName.getText().toString();
        String sifre=password.getText().toString();
        if(TextUtils.isEmpty(mail) || TextUtils.isEmpty(sifre)){
            Toast.makeText(getApplicationContext(),"boş alan bırakmayınız", Toast.LENGTH_SHORT).show();
            return;
        }
        if(sifre.length()<=5){
            Toast.makeText(getApplicationContext(),"Şifre 5 karakterdn fazla olmalı", Toast.LENGTH_SHORT).show();
            return;
        }



        mAuth.signInWithEmailAndPassword(mail,sifre).addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(LoginPage.this,AnaEkran.class));
                }else{
                    Toast.makeText(getApplicationContext(),"abi senin şifren yanlış", Toast.LENGTH_SHORT).show();

                }
            }
        });










    }
    public void goToLink(View view) {


        Intent intentt = new Intent(this, Kaydol.class);
        startActivity(intentt);
    }

}
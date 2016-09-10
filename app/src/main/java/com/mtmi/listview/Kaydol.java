package com.mtmi.listview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Kaydol extends AppCompatActivity {
    private FirebaseAuth mAuth ;
    private FirebaseAuth.AuthStateListener mAuthListener;

    EditText ePosta;
    EditText parola;
    Button kaydol;
    ImageButton facebook;
    ImageButton gplus;
    String admin = "1";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol);

        //Intent intentt = getIntent();

        mAuth=FirebaseAuth.getInstance();
        ePosta = (EditText) findViewById(R.id.ePosta_k);
        parola = (EditText) findViewById(R.id.Password_k);
        kaydol = (Button) findViewById(R.id.signIn_k);
        facebook = (ImageButton) findViewById(R.id.facebook_k);
        gplus = (ImageButton) findViewById(R.id.gPlus_k);


    }

    public void tikla1(View v1) {
        String mail=ePosta.getText().toString();
        String sifre=parola.getText().toString();
        if(TextUtils.isEmpty(mail) || TextUtils.isEmpty(sifre)){
            Toast.makeText(getApplicationContext(),"boş alan bırakmayınız", Toast.LENGTH_SHORT).show();
            return;
        }
        if(sifre.length()<=5){
            Toast.makeText(getApplicationContext(),"Şifre 5 karakterdn fazla olmalı", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(mail,sifre).addOnCompleteListener(Kaydol.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(getApplicationContext(),"Kaydınız tamamlandı giriş yapabilirsiniz....", Toast.LENGTH_SHORT).show();
                if (task.isSuccessful()){
                    startActivity(new Intent(Kaydol.this,LoginPage.class));
                }
            }
        });

    }

    public void facebookButton(View v2) {

        Intent intent = new Intent(Kaydol.this, MainActivity.class);
        startActivity(intent);


    }

    public void gPlusButton(View v3) {

        Intent intent = new Intent(Kaydol.this, MainActivity.class);
        startActivity(intent);


    }
}
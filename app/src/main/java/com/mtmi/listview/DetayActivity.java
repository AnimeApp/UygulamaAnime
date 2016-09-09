package com.mtmi.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;



public class DetayActivity extends AppCompatActivity {
    private FirebaseDatabase mDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference mRef=mDatabase.getReference();
    String filmid;
    ImageView image;
    TextView txtGosterim,txtFilmTuru,textadi,txtKonu,txtSure,yonetmen,FilmAciklama;
    String ad,konu,sure,resim,gosterim,FilmTuru,yonetmenad,filmTuruD,yonetmenid,aciklama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        Intent intent=getIntent();
        filmid=intent.getStringExtra("FILMID");


        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot data) {
                   DataSnapshot ds=data.child("filmler/"+filmid);

                    textadi = (TextView) findViewById(R.id.FilmAd);
                    txtKonu = (TextView) findViewById(R.id.FilmKonusu);
                    txtSure = (TextView) findViewById(R.id.FilmSuresi);
                    image = (ImageView) findViewById(R.id.FilmResim);
                    txtGosterim = (TextView) findViewById(R.id.FilmGosterim);
                    txtFilmTuru = (TextView) findViewById(R.id.FilmTuru);
                    yonetmen=(TextView)findViewById(R.id.Yonetmen);
                    FilmAciklama= (TextView) findViewById(R.id.FilmAciklama);

                    ad = ds.child("filmAd").getValue().toString();
                    konu = ds.child("filmKonusu").getValue().toString();
                    sure = ds.child("filmSuresi").getValue().toString();
                    resim = ds.child("resim").getValue().toString();
                    gosterim = ds.child("gosterimTarihi").getValue().toString();
                    filmTuruD=ds.child("filmTuru").getValue().toString();
                    aciklama=ds.child("filmAciklama").getValue().toString();
                    yonetmenid=ds.child("Yonetmen").getValue().toString();
                    yonetmenad=data.child("yonetmen").child(yonetmenid).child("YonetmenAd").getValue().toString();
                    FilmTuru = data.child("filmTuru").child(filmTuruD).getValue().toString();



                    Picasso.with(getApplicationContext()).load(resim).into(image);
                    textadi.setText(ad);
                    txtKonu.setText(konu);
                    txtSure.setText(sure);
                    txtGosterim.setText(gosterim);
                    txtFilmTuru.setText(FilmTuru);
                    yonetmen.setText(yonetmenad);
                    FilmAciklama.setText(aciklama);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(),"Hata! = "+databaseError.getMessage().toString(),Toast.LENGTH_SHORT).show();
            }
        });



    }
}

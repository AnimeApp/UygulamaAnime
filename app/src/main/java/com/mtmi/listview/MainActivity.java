package com.mtmi.listview;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRef=mDatabase.getReference("");

    String simge,filmad,filmid,filmTURU,tur,yil;

    List<listeSinif> dizi = new ArrayList<listeSinif>();
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst = (ListView)findViewById(R.id.listView);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listeSinif l = dizi.get(position);
                Intent intent = new Intent(getApplicationContext(),DetayActivity.class);
                intent.putExtra("FILMID",l.getFilmID());


                startActivity(intent);
            }
        });

            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    try {
                        dizi.clear();
                        for (DataSnapshot film : dataSnapshot.child("filmler").getChildren()) {
                            simge = film.child("resim").getValue().toString();
                            filmad = film.child("filmAd").getValue().toString();
                            yil = film.child("gosterimTarihi").getValue().toString();
                            filmid = film.getKey().toString();
                            tur = film.child("filmTuru").getValue().toString();
                            filmTURU = dataSnapshot.child("filmTuru").child(tur).getValue().toString();

                            dizi.add(new listeSinif(simge, filmad, yil, filmid, filmTURU));
                        }
                        populateList();
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Hata Oluştu!Daha sonra deneyiniz....:(",Toast.LENGTH_SHORT);
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(), "Hata" + databaseError.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            });

    }


    public void populateList(){
        OzelAdapter ozel= new OzelAdapter(this,dizi);
        ListView listview=(ListView)findViewById(R.id.listView);
        listview.setAdapter(ozel);
        listview.setDivider(null);
    }

}

package com.mtmi.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {
    private FirebaseDatabase firebase = FirebaseDatabase.getInstance();
    private DatabaseReference referenceF=firebase.getReference("");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        referenceF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {

                for (DataSnapshot post : ds.child("filmler").getChildren()){


                    for (DataSnapshot oyuncular : post.child("oyuncular").getChildren()) {
                        String oyuncu=oyuncular.getValue().toString();

                        Toast.makeText(getApplicationContext(),post.child("filmAd").getValue().toString()+ "---" +ds.child("oyuncular").child(oyuncu).child("OyuncuAd").getValue().toString(), Toast.LENGTH_SHORT).show();
                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Hata" + databaseError.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });

    }
}

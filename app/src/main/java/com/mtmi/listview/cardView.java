package com.mtmi.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class cardView extends AppCompatActivity {

    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRef=mDatabase.getReference("");
    private RecyclerView recyclerView;
    private List<cardListe> dizi;

    String simge,filmad,filmid,filmTURU,tur,yil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        dizi=new ArrayList<cardListe>();


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

                        dizi.add(new cardListe(simge, filmad ,filmTURU));
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
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

    }

    private void populateList() {
        cardviewAdapter adapter=new cardviewAdapter(this,dizi);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}

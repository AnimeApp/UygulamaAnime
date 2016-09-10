package com.mtmi.listview;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class OneFragment extends Fragment{
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRef=mDatabase.getReference("");
    public OneFragment() {
        // Required empty public constructor
    }
    String simge,filmad,filmid,filmTURU,tur,yil;

    List<listeSinif> dizi = new ArrayList<listeSinif>();
    ListView lst;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View root= inflater.inflate(R.layout.fragment_one, container, false);
        lst=(ListView)root.findViewById(R.id.listView22);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listeSinif l = dizi.get(position);
                Intent intent = new Intent(getActivity(),DetayActivity.class);
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
                    Toast.makeText(getActivity().getApplicationContext(),"Hata Oluştu!Daha sonra deneyiniz....:(",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getActivity().getApplicationContext(), "Hata" + databaseError.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });


        return root;
    }
    public void populateList(){
        OzelAdapter ozel= new OzelAdapter(getActivity(),dizi);
        //lst=(ListView)getActivity().findViewById(R.id.listView22);
        lst.setAdapter(ozel);
        lst.setDivider(null);
    }

}
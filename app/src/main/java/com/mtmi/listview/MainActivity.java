package com.mtmi.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final List<listeSinif> dizi = new ArrayList<listeSinif>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         dizi.add(new listeSinif("asdasd", "İstanbul"));
        dizi.add(new listeSinif("http://lorempixel.com/output/business-q-c-50-50-5.jpg", "Yarının Sınırında"));
        dizi.add(new listeSinif("http://lorempixel.com/output/business-q-c-50-50-5.jpg","Jason Borne"));
        dizi.add(new listeSinif("http://lorempixel.com/output/business-q-c-50-50-5.jpg","Suç Şehri"));
        dizi.add(new listeSinif("http://lorempixel.com/output/business-q-c-50-50-5.jpg","Kardeşim İçin"));
        dizi.add(new listeSinif("http://lorempixel.com/output/business-q-c-50-50-5.jpg","Aşkta Yanlış Yoktur"));
        OzelAdapter ozel= new OzelAdapter(this,dizi);
        ListView listview = (ListView)findViewById(R.id.listView);
        listview.setAdapter(ozel);
        listview.setDivider(null);

    }
}

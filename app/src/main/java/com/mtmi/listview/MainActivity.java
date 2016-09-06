package com.mtmi.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final List<listeSinif> dizi = new ArrayList<listeSinif>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dizi.add(new listeSinif("asdasd", "İstanbul",2016));
        dizi.add(new listeSinif("http://lorempixel.com/output/business-q-c-50-50-5.jpg", "Yarının Sınırında",2015));
        dizi.add(new listeSinif("http://lorempixel.com/output/business-q-c-50-50-5.jpg","Jason Borne",2016));
        dizi.add(new listeSinif("http://lorempixel.com/output/business-q-c-50-50-5.jpg","Suç Şehri",2010));
        dizi.add(new listeSinif("http://lorempixel.com/output/business-q-c-50-50-5.jpg","Kardeşim İçin",2011));
        dizi.add(new listeSinif("http://lorempixel.com/output/business-q-c-50-50-5.jpg","Aşkta Yanlış Yoktur",2012));
        OzelAdapter ozel= new OzelAdapter(this,dizi);
        ListView listview = (ListView)findViewById(R.id.listView);
        listview.setAdapter(ozel);
        listview.setDivider(null);

    }

}

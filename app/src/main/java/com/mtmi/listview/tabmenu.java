package com.mtmi.listview;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TabHost;

public class tabmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabmenu);
        TabHost tabHost=(TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpec1=tabHost.newTabSpec("tab1");
        tabSpec1.setContent(R.id.tab1);
        tabSpec1.setIndicator("anasayfa",null);
        tabHost.addTab(tabSpec1);

        tabHost.addTab(tabSpec1);
        TabHost.TabSpec tabSpec2=tabHost.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("favoriler",null);
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec arama=tabHost.newTabSpec("arama");
        arama.setContent(R.id.arama);
        arama.setIndicator("arama",null);
        tabHost.addTab(arama);

        TabHost.TabSpec tabSpec3=tabHost.newTabSpec("tab3");
        tabSpec3.setContent(R.id.tab3);
        tabSpec3.setIndicator("profil",null);
        tabHost.addTab(tabSpec3);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

}

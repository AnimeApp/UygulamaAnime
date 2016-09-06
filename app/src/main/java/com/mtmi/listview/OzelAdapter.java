package com.mtmi.listview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class OzelAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<listeSinif> liste;
Context mContext;
    public OzelAdapter(Activity activity,List<listeSinif> listes){
        mContext = activity.getApplicationContext();
        mInflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        liste=listes;
    }

    @Override
    public int getCount(){
            return liste.size();
    }
    @Override
    public listeSinif getItem(int position){
        return liste.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position,View convertview,ViewGroup parent){
            View satir;

        satir=mInflater.inflate(R.layout.liste,null);
        TextView txtView=(TextView)satir.findViewById(R.id.isimsoyisim);
        TextView txtGosterim=(TextView)satir.findViewById(R.id.txtgosterim);
        ImageView image = (ImageView)satir.findViewById(R.id.simge);
        listeSinif satirListe = liste.get(position);
        txtView.setText(satirListe.getIsım());
        txtGosterim.setText("Gösterim Tarihi " + satirListe.getGosterimTarhi());
       // image.setImageResource(R.drawable.photo);

        Picasso.with(mContext).load("http://lorempixel.com/output/nature-q-c-60-60-7.jpg").into(image);
        if(position%2==0){
            satir.setBackgroundColor(Color.parseColor("#19283c"));
        }else{
            satir.setBackgroundColor(Color.parseColor("#25405b"));
        }
        return satir;
    }
}

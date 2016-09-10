package com.mtmi.listview;


import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.util.List;

public class cardviewAdapter extends RecyclerView.Adapter<cardviewAdapter.ViewHolder> {
    Context mContext;
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView filmAd;
        public TextView FilmTur;
        public ImageView Resim;
        public CardView cardView;
        public ViewHolder(View view){
         super(view);
            cardView= (CardView) view.findViewById(R.id.card_view);
            filmAd=(TextView)view.findViewById(R.id.cFilmAd);
            FilmTur= (TextView) view.findViewById(R.id.cFilmTur);
            Resim = (ImageView) view.findViewById(R.id.cfilmResim);

        }
    }
    List<cardListe> dizi;
    public cardviewAdapter(Activity act,List<cardListe> l){
        this.dizi=l;
        mContext=act.getApplicationContext();
    }
    public cardviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout,parent, false);
        ViewHolder view_Holder=new ViewHolder(v);
        return  view_Holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.filmAd.setText(dizi.get(position).getIsım());
        holder.FilmTur.setText(dizi.get(position).getTur());

        Picasso.with(mContext).load(dizi.get(position).getSimge()).into(holder.Resim);
    }
    public int getItemCount(){
        return dizi.size();
    }
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}

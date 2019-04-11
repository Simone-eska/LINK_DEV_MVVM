package com.example.viewmodeltest.home.view.navDrawer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.viewmodeltest.R;

public class NavRecyclerAdapter extends  RecyclerView.Adapter<NavRecyclerAdapter.NavItemViewHolder> {

    private int selectedPosition=0;
    private LayoutInflater inflater;
    private final int[] drawableResources={
            R.drawable.explore,R.drawable.live, R.drawable.gallery, R.drawable.wishlist, R.drawable.e_magazine
    };
    private final int[] stringResources={
            R.string.explore,
            R.string.live,
            R.string.gallery,
            R.string.wish_list,
            R.string.e_magazine
    };

    public NavRecyclerAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }


    public class NavItemViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
         TextView titleTextView;
         ImageView img;
         View view;
        NavItemViewHolder(View v) {
            super(v);
            this.view=v;
            titleTextView = (TextView)v.findViewById(R.id.nav_title_tv);
            img = (ImageView)v.findViewById(R.id.nav_img);
            v.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            selectedPosition=getAdapterPosition();
            Toast.makeText(inflater.getContext(),stringResources[selectedPosition],Toast.LENGTH_SHORT).show();
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public NavItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.nav_item, viewGroup, false);
        return new NavItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NavItemViewHolder myViewHolder, final int i) {

            myViewHolder.titleTextView.setText(stringResources[i]);
            myViewHolder.img.setImageResource(drawableResources[i]);
            myViewHolder.view.setBackgroundResource((selectedPosition==i)?
                    R.drawable.selected_row_bg:android.R.color.white);
    }


    @Override
    public int getItemCount() {
        return 5;
    }
}

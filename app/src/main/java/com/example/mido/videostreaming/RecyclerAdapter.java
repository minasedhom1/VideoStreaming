package com.example.mido.videostreaming;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mina on 8/20/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


     List<Item> list;
    Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
       //  VideoView videoView;
        ViewPager viewPager;
        TextView textView;

        public MyViewHolder(View view) {
            super(view);
            viewPager  = (ViewPager) view.findViewById(R.id.viewpager_list);
            textView= (TextView) view.findViewById(R.id.video_uri_tv);
        }
    }

    public RecyclerAdapter(List<Item> list,Context context )
    {
        this.context=context;
        this.list=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getName());
        holder.viewPager.setAdapter(new CustomPagerAdapter(context,list.get(position).getUrls()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}

package com.example.mido.videostreaming;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
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


     List<String> list;
    Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
         VideoView videoView;
        TextView textView;

        public MyViewHolder(View view) {
            super(view);
            videoView  = (VideoView) view.findViewById(R.id.myVideo);
            textView= (TextView) view.findViewById(R.id.video_uri_tv);
        }
    }

    public RecyclerAdapter(List<String> list,Context context )
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
        String vidAddress=list.get(position);
      //  holder.textView.setText(vidAddress);
         Uri vidUri = Uri.parse(vidAddress);
        holder.videoView.setVideoURI(vidUri);
     //   holder.videoView.start();

/*        holder.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.videoView.start();
            }
        });*/

        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // This is just to show image when loaded
                mp.start();
                mp.pause();
            }
        });



       MediaController vidControl = new MediaController(context);
        vidControl.setAnchorView(holder.videoView);
        holder.videoView.setMediaController(vidControl);
      //  holder.videoView.start();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}

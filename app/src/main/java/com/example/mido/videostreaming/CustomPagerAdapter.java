package com.example.mido.videostreaming;

import android.app.Dialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.IntegerRes;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mina on 8/23/2017.
 */

public class CustomPagerAdapter extends PagerAdapter {

    private Context context;
    List<String> urls;
    private LayoutInflater layoutInflater;
 //   private Integer [] images={ R.layout.custom_view,R.layout.custom_view,R.layout.popup_video};


    public CustomPagerAdapter(Context context, List<String> urls) {
        this.urls=urls;
        this.context = context;
    }

    @Override
    public int getCount() {
        return urls.size();
    }



    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view;
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(position<urls.size()-1)
        {
            view=layoutInflater.inflate(R.layout.custom_view,null);
            ImageView imageView= (ImageView) view.findViewById(R.id.imageView);
            Picasso.with(context).load(urls.get(position)).into(imageView);
       //     imageView.setImageResource(urls.get(position));
        }

        else {
            view=layoutInflater.inflate(R.layout.popup_video,null);
            final VideoView videoView = (VideoView) view.findViewById(R.id.videoView);
            Uri vidUri = Uri.parse(urls.get(position));
            videoView.setVideoURI(vidUri);
            final MediaController vidControl = new MediaController(context);
            vidControl.setAnchorView(videoView);
            videoView.setMediaController(vidControl);

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    // This is just to show image when loaded
                    mp.start();
                    mp.pause();
                    mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                        @Override
                        public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                            // Re-Set the videoView that acts as the anchor for the MediaController
                            vidControl.setAnchorView(videoView);
                        }
                    });
                }
            });
        }
        container.addView(view,0);
        return view;




        /*ImageView imageView= (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        container.addView(view,0);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==images.length-1)
                {
                    Dialog dialog=new Dialog(context);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.popup_video);
                    VideoView videoView= (VideoView) dialog.findViewById(R.id.videoView);
                    Uri vidUri = Uri.parse("https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4");
                    videoView.setVideoURI(vidUri);
              *//*      MediaController vidControl = new MediaController(context);
                    vidControl.setAnchorView(videoView);
                    videoView.setMediaController(vidControl);*//*
                    videoView.start();
                    dialog.show();
                }
                Toast.makeText(context,position + "of length: "+images.length,Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager= (ViewPager) container;
        View view= (View) object;
        viewPager.removeView(view);

    }
}

package com.example.mido.videostreaming;

import android.app.Dialog;
import android.content.Context;
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

/**
 * Created by Mina on 8/23/2017.
 */

public class CustomPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images={ R.layout.custom_view,R.layout.custom_view,R.layout.popup_video};


    public CustomPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {

        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(images[position],null);

        if(images[position]== R.layout.custom_view)
        {
            ImageView imageView= (ImageView) view.findViewById(R.id.imageView);
            imageView.setImageResource(R.mipmap.ic_launcher_round);
        }
        else {
            VideoView videoView = (VideoView) view.findViewById(R.id.videoView);
            Uri vidUri = Uri.parse("https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4");
            videoView.setVideoURI(vidUri);
            MediaController vidControl = new MediaController(context);
            vidControl.setAnchorView(videoView);
            videoView.setMediaController(vidControl);
        }
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
        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager= (ViewPager) container;
        View view= (View) object;
        viewPager.removeView(view);

    }
}

package com.example.mido.videostreaming;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> list;
    VideoView videoView;
    MediaController vidControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  Button button= (Button) findViewById(R.id.swap_views_activity);
        Button button1= (Button) findViewById(R.id.media_palyer_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SlideViewsActivity.class));
            }
        });*/
        list=new ArrayList<>();
        String [] arr ={"http://www.papawestray.co.uk/images/shop-interior.jpg","http://1.bp.blogspot.com/-8IyeCL9AqMg/Uqn8pYLU_yI/AAAAAAAAhVw/l2mtyVx1sac/s1600/P1060905.JPG","http://westsomersetrailway.vticket.co.uk/shopimages/sections/extras/shop_20110408-IMG_2011.jpg","https://www.lsu.co.uk/pageassets/services/shops/20160621_133142.jpg","https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4"};
        ArrayList<String> urls=new ArrayList<>(Arrays.asList(arr));
        list.add(new Item("one",urls));
        list.add(new Item("two",urls));
        list.add(new Item("three",urls));
        list.add(new Item("four",urls));
        list.add(new Item("five",urls));


        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(new RecyclerAdapter(list,this));


    }
}

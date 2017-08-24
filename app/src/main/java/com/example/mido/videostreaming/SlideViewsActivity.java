package com.example.mido.videostreaming;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class SlideViewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_views);

        String [] arr ={"http://www.papawestray.co.uk/images/shop-interior.jpg","http://1.bp.blogspot.com/-8IyeCL9AqMg/Uqn8pYLU_yI/AAAAAAAAhVw/l2mtyVx1sac/s1600/P1060905.JPG","http://westsomersetrailway.vticket.co.uk/shopimages/sections/extras/shop_20110408-IMG_2011.jpg","https://www.lsu.co.uk/pageassets/services/shops/20160621_133142.jpg","https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4"};

        ArrayList<String> list=new ArrayList<>(Arrays.asList(arr));


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this,list));

    }
}

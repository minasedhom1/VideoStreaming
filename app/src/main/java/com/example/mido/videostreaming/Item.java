package com.example.mido.videostreaming;

import java.util.ArrayList;

/**
 * Created by Mina on 8/24/2017.
 */

public class Item {
   private String name;
   private ArrayList<String> urls;

    public Item(String name, ArrayList<String> urls) {
        this.name = name;
        this.urls = urls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<String> urls) {
        this.urls = urls;
    }
}

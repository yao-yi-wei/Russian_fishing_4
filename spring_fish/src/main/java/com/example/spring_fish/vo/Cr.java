package com.example.spring_fish.vo;

import java.awt.*;

public class Cr {
    public static final Color c1 = new Color(200, 214, 63);
    public static final Color c2 = new Color(237, 195, 0);
    public static final Color c3 = new Color(229, 188, 0);
    public static final Color c4 = new Color(206, 56, 21);
    public static final Color c5 = new Color(64, 64, 64);

    public static boolean isRed(int r,int g,int b){
        int max=Math.max(Math.max(r,g),b);
        if(max==r)return true;
        else{return false;}
    }
    public static boolean isGreen(int r,int g,int b){
        int max=Math.max(Math.max(r,g),b);
        if(max==g)return true;
        else{return false;}
    }
}

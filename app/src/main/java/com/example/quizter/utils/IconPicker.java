package com.example.quizter.utils;

import com.example.quizter.R;

public class IconPicker {
    public static int[] draws = {
            R.drawable.ic_icon_1_math,
            R.drawable.ic_icon_2_bell_school,
            R.drawable.ic_icon_3_letter,
            R.drawable.ic_icon_4_book,
            R.drawable.ic_icon_5_ruler,
            R.drawable.ic_icon_6_pencil,
    };

    static int currentIcon = 0;
    public static int getIcon(){

        currentIcon = (currentIcon+1) % draws.length;
        return draws[currentIcon];
    }
}
package com.sdacademy.slowinski.andrzej.mycv;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by RENT on 2017-04-04.
 */

public class CvRow extends LinearLayout {
    public CvRow(Context context, String text, int icon){
        super(context);
        this.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dpToPx(48)));
        this.setPadding(pxToDp(16),0,pxToDp(16),0);
        this.setOrientation(LinearLayout.HORIZONTAL);

        ImageView iconField=new ImageView(context);
        iconField.setImageResource(icon);
        LinearLayoutCompat.LayoutParams iconFIeldParams = new LinearLayoutCompat.LayoutParams(dpToPx(24), dpToPx(24));
        iconField.setLayoutParams(iconFIeldParams);
        iconFIeldParams.gravity=Gravity.CENTER_VERTICAL;


        TextView textField=new TextView(context);
        textField.setText(text);
        textField.setTextSize(16);
        textField.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dpToPx(48)));
        textField.setPadding(dpToPx(32),0,0,0);
        textField.setGravity(Gravity.CENTER_VERTICAL);

        this.addView(iconField);
        this.addView(textField);




    }

    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    private int pxToDp(int px) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }


    public static float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }
}

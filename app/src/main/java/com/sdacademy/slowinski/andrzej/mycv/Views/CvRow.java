package com.sdacademy.slowinski.andrzej.mycv.Views;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sdacademy.slowinski.andrzej.mycv.model.CvItem;

/**
 * Created by RENT on 2017-04-04.
 */

public class CvRow extends LinearLayout {
    public CvRow(final Context context, final CvItem cvItem) {
        super(context);
        setupLayout(context);
        ImageView iconField = setupIcon(context, cvItem);
        TextView textField = setupText(context, cvItem);
        addViews(iconField, textField);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cvItem.performanceAction(context);
            }
        });
        ;

    }

    private void setupLayout(Context context) {
        this.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, convertDpToPixel(48, context)));
        this.setPadding(convertPixelsToDp(16, context), 0, convertPixelsToDp(16, context), 0);
        this.setOrientation(LinearLayout.HORIZONTAL);
    }

    private void addViews(ImageView iconField, TextView textField) {
        this.addView(iconField);
        this.addView(textField);
    }

    @NonNull
    private TextView setupText(Context context, CvItem cvItem) {
        TextView textField = new TextView(context);
        textField.setText(cvItem.getCaption());
        textField.setTextSize(16);
        textField.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, convertDpToPixel(48, context)));
        textField.setPadding(convertDpToPixel(32, context), 0, 0, 0);
        textField.setGravity(Gravity.CENTER_VERTICAL);
        return textField;
    }

    @NonNull
    private ImageView setupIcon(Context context, CvItem cvItem) {
        ImageView iconField = new ImageView(context);
        iconField.setImageResource(cvItem.getIcon());
        LayoutParams iconFIeldParams = new LayoutParams(convertDpToPixel(24, context), convertDpToPixel(24, context));
        iconFIeldParams.gravity = Gravity.CENTER_VERTICAL;
        iconField.setLayoutParams(iconFIeldParams);
        return iconField;
    }

    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    private int pxToDp(int px) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int px = (int) (dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }


    public static int convertPixelsToDp(float px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int dp = (int) (px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }
}

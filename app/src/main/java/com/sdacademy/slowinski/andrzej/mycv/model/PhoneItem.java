package com.sdacademy.slowinski.andrzej.mycv.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by RENT on 2017-04-05.
 */

public class PhoneItem extends CvItem {

    private  final String phoneNumber="663076649";
    private Uri uri;

    public PhoneItem(String caption, int icon) {

        super(caption, icon);
        this.uri = Uri.parse("tel:"+phoneNumber);
    }


    @Override
    public void performanceAction(Context context) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        context.startActivity(intent);
    }
}

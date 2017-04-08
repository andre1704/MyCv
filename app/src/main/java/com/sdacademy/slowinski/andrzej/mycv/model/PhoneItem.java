package com.sdacademy.slowinski.andrzej.mycv.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.sdacademy.slowinski.andrzej.mycv.Constant;
import com.sdacademy.slowinski.andrzej.mycv.R;

/**
 * Created by RENT on 2017-04-05.
 */

public class PhoneItem extends CvItem {

    private Uri uri;

    public PhoneItem() {

        super(Constant.PHONE_NUMBER, R.drawable.ic_phone_black_24dp);
        this.uri = Uri.parse("tel:"+ Constant.PHONE_NUMBER);
    }


    @Override
    public void performanceAction(Context context) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        context.startActivity(intent);
    }
}

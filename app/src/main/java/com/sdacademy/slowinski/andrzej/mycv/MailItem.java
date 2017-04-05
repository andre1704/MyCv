package com.sdacademy.slowinski.andrzej.mycv;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * Created by RENT on 2017-04-05.
 */

public class MailItem extends CvItem {
    private static final String MAILTO = "mailto:";
    private static final String[] mailto={"andrzejslowinski@gmail.com"};
    private static final String message="witaj";


    public MailItem(String caption, int icon) {
        super(caption, icon);
    }


    @Override
    public void performanceAction(Context context) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse(MAILTO));
        intent.putExtra(Intent.EXTRA_EMAIL, mailto);
        intent.putExtra(Intent.EXTRA_SUBJECT, message);
        context.startActivity(intent);
    }
}

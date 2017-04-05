package com.sdacademy.slowinski.andrzej.mycv;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout=new CvRow(this,);
        setContentView(linearLayout);


        CvRow phoneView= new CvRow(this,new PhoneItem("phone",R.drawable.ic_phone_black_24dp ));
        CvRow webView= new CvRow(this,new WebItem("git",R.drawable.ic_cloud_black_24dp,"https://github.com/andre1704/MyCv"));
        CvRow mailView= new CvRow(this,new MailItem("mail",R.drawable.ic_contact_mail_black_24dp ));

        linearLayout.addView(phoneView);
        linearLayout.addView(webView);
        linearLayout.addView(mailView);



    }
}

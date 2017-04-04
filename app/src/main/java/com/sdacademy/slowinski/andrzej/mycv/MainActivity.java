package com.sdacademy.slowinski.andrzej.mycv;

import android.content.Intent;
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

        final View phoneView = findViewById(R.id.phoneNumberViev);
        View emailView = findViewById(R.id.emailView);
        View linkView = findViewById(R.id.linkedinView);
        View homeMapView = findViewById(R.id.homeView);
        View githubView=findViewById(R.id.githubView);


        phoneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewIntent(Intent.ACTION_DIAL, "tel:691653818");
            }
        });
        emailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
        linkView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewIntent(Intent.ACTION_VIEW, "https://www.linkedin.com/in/andrzej-s%C5%82owi%C5%84ski-765681131");
            }
        });
        homeMapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.google.pl/maps/place/Krzysztofa+Kolumba+5,+51-503+Wroc%C5%82aw/@51.112385,17.1167235,17z/data=!3m1!4b1!4m5!3m4!1s0x470fe80902774f13:0xe8f953eb03c77c8c!8m2!3d51.112385!4d17.1189122";
                startNewIntent(Intent.ACTION_VIEW, url);
            }
        });
        githubView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewIntent("Intent.ACTION_VIEW","https://github.com/andre1704/MyCv");
            }
        });
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.dataLayoutViev);
        linearLayout.addView(new CvRow(this, "Rzad testowy", R.drawable.ic_memory_black_24dp));

    }

    private void startNewIntent(String action, String uri) {
        Intent intent = new Intent(action);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }


    private void sendMail() {
        Log.d(TAG, "Mail emailView");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mail@wp.pl"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Wiadomosc z CV");
        startActivity(intent);
    }


}

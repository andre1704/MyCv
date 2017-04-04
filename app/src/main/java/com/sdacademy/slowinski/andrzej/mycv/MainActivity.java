package com.sdacademy.slowinski.andrzej.mycv;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View phoneView = findViewById(R.id.phoneNumberViev);
        phoneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:691653818"));
                startActivity(intent);
                Log.d(TAG,"Mail phoneNumberViev");
            }
        });
        View emailView=findViewById(R.id.emailView);
        emailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Mail emailView");
                Intent intent=new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL,"mail@wp.pl");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Wiadomosc z CV");
                startActivity(intent);
            }
        });
        View linkView=findViewById(R.id.linkedinView);
        linkView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent((Intent.ACTION_VIEW));
                intent.setData(Uri.parse("www.wp.pl"));
                startActivity(intent);
            }
        });
    }
}

package com.sdacademy.slowinski.andrzej.mycv;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sdacademy.slowinski.andrzej.mycv.Views.CvRow;
import com.sdacademy.slowinski.andrzej.mycv.model.MailItem;
import com.sdacademy.slowinski.andrzej.mycv.model.PhoneItem;
import com.sdacademy.slowinski.andrzej.mycv.model.WebItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.dataLayoutViev)
    LinearLayout rowHolder;

    @BindView(R.id.navigationViewww)
    NavigationView navigationView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navigationView.setNavigationItemSelectedListener(this);
        setupRows();


    }

    private void setupRows() {
        CvRow phoneView = new CvRow(this, new PhoneItem("phone", R.drawable.ic_phone_black_24dp));
        CvRow gitView = new CvRow(this, new WebItem("git", R.drawable.ic_cloud_black_24dp, "https://github.com/andre1704/MyCv"));
        CvRow mailView = new CvRow(this, new MailItem("mail", R.drawable.ic_contact_mail_black_24dp));
        CvRow locationView = new CvRow(this, new WebItem("adres domowy", R.drawable.ic_location_city_black_24dp, "https://www.google.pl/maps/place/Krzysztofa+Kolumba+5,+51-503+Wroc%C5%82aw/@51.112385,17.1167235,17z/data=!3m1!4b1!4m5!3m4!1s0x470fe80902774f13:0xe8f953eb03c77c8c!8m2!3d51.112385!4d17.1189122"));


        rowHolder.addView(phoneView);
        rowHolder.addView(gitView);
        rowHolder.addView(locationView);
        rowHolder.addView(mailView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        toolbar.setTitle(item.getTitle());
        switch (item.getItemId()) {
            case R.id.navigationMenuContact:
                Toast.makeText(this, "Kontakt", Toast.LENGTH_SHORT).show();
                toolbar.setTitle(item.getTitle());
                break;
            case R.id.navigationMenuEducation:
                Toast.makeText(this, "Wykształcenie", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigationMenuExperience:
                Toast.makeText(this, "Doświadczenie", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigationMenuHobby:
                Toast.makeText(this, "Hobby", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigationMenuSkills:
                Toast.makeText(this, "Umiejętności", Toast.LENGTH_SHORT).show();
                break;
        }

        return false;
    }
}

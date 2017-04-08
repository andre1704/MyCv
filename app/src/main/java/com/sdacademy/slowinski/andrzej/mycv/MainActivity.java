package com.sdacademy.slowinski.andrzej.mycv;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
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
//    @BindView(R.id.dataLayoutViev)
//    LinearLayout rowHolder;

    @BindView(R.id.mainActivityContainer)
    FrameLayout container;


    @BindView(R.id.navigationViewww)
    NavigationView navigationView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.navigationMenuContact);
        navigationView.getMenu().performIdentifierAction(R.id.navigationMenuContact, 0);

//        setupRows();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainActivityContainer,ContactFragment.newInstance())
                .commit();
        setSupportActionBar(toolbar);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(Gravity.LEFT);
        toolbar.setTitle(item.getTitle());

        for (int i = 0; i < navigationView.getMenu().size(); i++) {
            if (navigationView.getMenu().getItem(i).isChecked()) {
                navigationView.getMenu().getItem(i).setChecked(false);

            }
        }
        item.setChecked(true);


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

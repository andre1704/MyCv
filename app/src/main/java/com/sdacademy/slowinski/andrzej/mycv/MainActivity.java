package com.sdacademy.slowinski.andrzej.mycv;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main:
                InfoFragment.newInstance().show(getSupportFragmentManager(), "");
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(Gravity.LEFT);
        toolbar.setTitle(item.getTitle());
        Fragment fragment = null;

        uncheckedMenuItem();
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.navigationMenuContact:
                toolbar.setTitle(item.getTitle());
                fragment = ContactFragment.newInstance();
                break;
            case R.id.navigationMenuEducation:
                toolbar.setTitle(item.getTitle());
                fragment = SchoolFragment.newInstance();
                break;
            case R.id.navigationMenuExperience:
                toolbar.setTitle(item.getTitle());
                break;
            case R.id.navigationMenuHobby:
                toolbar.setTitle(item.getTitle());
                break;
            case R.id.navigationMenuSkills:
                toolbar.setTitle(item.getTitle());
                break;
            case R.id.navigationMenuFormula:
                toolbar.setTitle(item.getTitle());
                fragment = EmailSendFragment.newInstance();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainActivityContainer, fragment)
                .commit();

        return false;
    }

    private void uncheckedMenuItem() {
        for (int i = 0; i < navigationView.getMenu().size(); i++) {
            if (navigationView.getMenu().getItem(i).isChecked()) {
                navigationView.getMenu().getItem(i).setChecked(false);
            }
        }
    }
}

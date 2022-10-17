package com.example.androiduitemplates;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.zip.Inflater;

public class DashboardActivity extends AppCompatActivity  {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    MaterialToolbar toolbar;
    TabLayout tabLayout;
    TabItem homeTab,serviceTab,aboutTab;
    Fragment fragment=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tabLayout=findViewById(R.id.tabLayout);

        fragment = new HomeFragment();
       FragmentManager fragmentManager = getSupportFragmentManager();
       FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        fragment=new HomeFragment();
                       break;
                    case 1:
                         fragment=new ServiceFragment();
                        break;
                    case 2:
                         fragment=new AboutFragment();
                        break;
                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.framelayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Saving state of our app
        // using SharedPreferences
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            try{
                setTheme(R.style.Theme_Material3_Dark);

            }catch (Exception e){
                Log.e("catch","1 "+e.getMessage());

                e.printStackTrace();
            }
        }else {
            try{
                setTheme(R.style.Theme_AndroidUiTemplates);

            }catch (Exception e){
                Log.e("catch","2 "+e.getMessage());
                e.printStackTrace();
            }
        }
// When user reopens the app
        // after applying dark/light mode
        /*
        if (isDarkModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            //btnToggleDark.setText("Disable Dark Mode");
        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
           // btnToggleDark.setText("Enable Dark Mode");
        }



         */
        toolbar=findViewById(R.id.toolbar);
//------------toolbar--------------
setSupportActionBar(toolbar);

//------------Nav Drawer menu--------------
        drawerLayout=findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.nav_drawer_open,
                R.string.nav_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //change navigation default icon
       // getSupportActionBar().
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_horizontal_split_24);

        navigationView=findViewById(R.id.nav_view);
        setupDrawerContent(navigationView);

        //-----------------for  Nav header components--------------------
 //       View header = navigationView.getHeaderView(0);
//
//        preferenceManager=PreferenceManager.getINSTANCE(this);
//        profileImg=header.findViewById(R.id.profile_img);



//toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Toast.makeText(DashboardActivity.this, "Navigation icon clicked", Toast.LENGTH_SHORT).show();
//    }
//});

toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.mSearch:
                Toast.makeText(DashboardActivity.this, "Search clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.mMore:
                Toast.makeText(DashboardActivity.this, "more clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(DashboardActivity.this, "default clicked", Toast.LENGTH_SHORT).show();
                break;

        }

        return true;
    }
});

    }

    //set toolbar menus
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.app_bar_menu,menu);
        return true;
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.btnLayout:
                             //Toast.makeText(DashboardActivity.this, "menu1 is clicked", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(DashboardActivity.this,buttonLayActivity.class);
                        startActivity(i);
                        drawerLayout.closeDrawers();

                        break;
                    case R.id.bottomNav:
                        //Toast.makeText(DashboardActivity.this, "menu1 is clicked", Toast.LENGTH_SHORT).show();
                        Intent bottomintent=new Intent(DashboardActivity.this,BottomNavActivity.class);
                        startActivity(bottomintent);
                        drawerLayout.closeDrawers();

                        break;
                    case R.id.entryForm:
                        // Toast.makeText(MainActivity.this, "menu2 is clicked", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(DashboardActivity.this,MainActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();

                        break;
                    case R.id.slideUi:
                        SlideFragment slideFragment=new SlideFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.framelayout, slideFragment);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();

                        break;
                    case R.id.settings:
                         SettingsFragment fragment=new SettingsFragment();
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.framelayout, fragment);
                        ft.commit();
                        drawerLayout.closeDrawers();

                        break;
                    default:
                        Toast.makeText(DashboardActivity.this, "..", Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });
    }

}
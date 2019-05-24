package com.example.navigationdrawerapp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle mToggle;
    Fragment fragment;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolBar1);
        toolbar.setTitle("NavigationDemo");
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);
        mToggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView navigationView=findViewById(R.id.navigationView);
         imageView=navigationView.getHeaderView(0).findViewById(R.id.imageView);

        navigationView.setNavigationItemSelectedListener(this);


    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id= menuItem.getItemId();
        if(id==R.id.home)
        {
           // Toast.makeText(this,"This is home",Toast.LENGTH_SHORT).show();
           fragment= new Fragment1();
        }
        if(id==R.id.settings)
        {
          //  Toast.makeText(this,"This is setings",Toast.LENGTH_SHORT).show();
           fragment= new Fragment2();
        }
        if(id==R.id.contactus)
        {
            Toast.makeText(this,"This is Contact us",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.change)
        {
            imageView.setImageResource(R.drawable.ic_home_black_24dp);
        }
              if(fragment!=null)
        {
            FragmentManager manager=getSupportFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.replace(R.id.container_frag,fragment);
            transaction.commit();
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return false;
    }
}

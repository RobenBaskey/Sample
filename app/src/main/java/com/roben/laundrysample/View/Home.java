package com.roben.laundrysample.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.roben.laundrysample.Fragments.CartFrag;
import com.roben.laundrysample.Fragments.HistoryFrag;
import com.roben.laundrysample.Fragments.HomeFrag;
import com.roben.laundrysample.Fragments.SettingFrag;
import com.roben.laundrysample.R;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationView;
    private Menu menu;
    private FrameLayout frameLayout;

    /// for tab layout///
    private TabLayout tabLayout;
    private ViewPager viewPager;
    /// for tab layout///

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        menu = bottomNavigationView.getMenu();

        //for home bedge
        MenuItem itemCart = menu.findItem(R.id.bottom_cart);
        BadgeDrawable badgeCart = bottomNavigationView.getOrCreateBadge(itemCart.getItemId());
        badgeCart.setNumber(3);

        getSupportFragmentManager().beginTransaction().replace(R.id.framlayout , new HomeFrag()).commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFrag = null;
        switch (item.getItemId()) {
            case R.id.bottom_home:
                selectedFrag = new HomeFrag();
                break;
            case R.id.bottom_history:
                selectedFrag = new HistoryFrag();
                break;
            case R.id.bottom_cart:
                selectedFrag = new CartFrag();
                break;
            case R.id.bottom_setting:
                selectedFrag = new SettingFrag();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.framlayout , selectedFrag).commit();
        return true;
    }

}

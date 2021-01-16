package ve.com.abicelis.creditcardexpensemanager.app.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import ve.com.abicelis.creditcardexpensemanager.R;
import ve.com.abicelis.creditcardexpensemanager.app.fragments.NavigationDrawerFragment;
import ve.com.abicelis.creditcardexpensemanager.app.fragments.OverviewFragment;

public class HomeActivity extends AppCompatActivity {

    //UI
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setUpToolbar();

        //Load the default fragment (overview_fragment.java)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.home_content_frame, new OverviewFragment()).commit();
        }

    }


    private void setUpToolbar() {

        mToolbar = (Toolbar) findViewById(R.id.home_toolbar);
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Set toolbar as actionbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //Sync drawer-toolbar state
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,  mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_closed);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        //Load the NavigationDrawerFragment, pass the drawerLayout
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drawer_fragment);
        drawerFragment.setDrawerLayout(mDrawerLayout);
    }

}

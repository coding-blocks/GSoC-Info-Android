package codingblocks.com.gsocinfo.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

import codingblocks.com.gsocinfo.Constants;
import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.fragments.AboutFragment;
import codingblocks.com.gsocinfo.fragments.FaqFragment;
import codingblocks.com.gsocinfo.fragments.OrganizationFragment;
import codingblocks.com.gsocinfo.fragments.ProjectFragment;

public class AboutActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_about, AboutFragment.newInstance())
                .commit();

        try {
            String json;
            InputStream inputStream = getAssets().open("org.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            Constants.setOrganizations(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String json1;
        InputStream inputStream1 = null;
        try {
            inputStream1 = getAssets().open("projects.json");
            int size1 = inputStream1.available();
            byte[] buffer1 = new byte[size1];
            inputStream1.read(buffer1);
            inputStream1.close();
            json1 = new String(buffer1, "UTF-8");
            Constants.setProjects(json1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_about,AboutFragment.newInstance())
                    .commit();
        } else if (id == R.id.nav_organizations) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_about, OrganizationFragment.newInstance())
                    .commit();
        } else if (id == R.id.nav_projects) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_about, ProjectFragment.newInstance())
                    .commit();
        } else if (id == R.id.nav_faq) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_about, FaqFragment.newInstance())
                    .commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

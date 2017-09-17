package codingblocks.com.gsocinfo.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import codingblocks.com.gsocinfo.GSoCApp;
import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.fragments.AboutFragment;
import codingblocks.com.gsocinfo.fragments.FaqFragment;
import codingblocks.com.gsocinfo.fragments.OrganizationFragment;
import codingblocks.com.gsocinfo.fragments.ProjectFragment;
import codingblocks.com.gsocinfo.data.model.MainPage;
import codingblocks.com.gsocinfo.data.model.Organizations;
import codingblocks.com.gsocinfo.data.model.Projects;

public class AboutActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MainPage.Copy mainPageCopy;
    private List<Projects.Project> projects = new ArrayList<>();
    private List<Organizations.Organization> organizations = new ArrayList<>();
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
        final View view = LayoutInflater.from(this).inflate(R.layout.dialog_progress, null, false);
        ((TextView) view.findViewById(R.id.textViewDialog)).setText("Adding special sauce . . .");
        alertDialog = new AlertDialog.Builder(AboutActivity.this)
                .setMessage("Hold On")
                .setView(view)
                .setCancelable(false)
                .setView(view)
                .create();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                mainPageCopy = GSoCApp.getMainPageDao().getData();
                AboutFragment aboutFragment = AboutFragment.newInstance();
                aboutFragment.setData(mainPageCopy);
                if (savedInstanceState == null)
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_about, aboutFragment)
                            .commit();
            }
        }).start();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);
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

        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            AboutFragment aboutFragment = AboutFragment.newInstance();
            aboutFragment.setData(mainPageCopy);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_about, aboutFragment)
                    .commit();
        } else if (id == R.id.nav_organizations) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_about, OrganizationFragment.newInstance())
                    .commit();
        } else if (id == R.id.nav_projects) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_about, ProjectFragment.newInstance(""))
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

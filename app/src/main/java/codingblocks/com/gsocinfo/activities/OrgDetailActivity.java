package codingblocks.com.gsocinfo.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.data.model.Organization;
import codingblocks.com.gsocinfo.fragments.OrgDetailFragment;
import codingblocks.com.gsocinfo.fragments.ProjectFragment;

import static codingblocks.com.gsocinfo.adapters.OrgAdapter.ORG_TAG;

public class OrgDetailActivity extends AppCompatActivity {

    String orgID;
    private Organization organization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_detail);
        Intent i = getIntent();
        orgID = i.getStringExtra("ORG_ID");
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        organization = (Organization) i.getSerializableExtra(ORG_TAG);
        supportPostponeEnterTransition();

        Bundle extras = i.getExtras();

        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        ImageView orgImage = collapsingToolbarLayout.findViewById(R.id.org_detail_image);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Fade fade = new Fade();
            fade.excludeTarget(R.id.app_bar_layout, true);
            fade.excludeTarget(android.R.id.statusBarBackground, true);
            fade.excludeTarget(android.R.id.navigationBarBackground, true);
            getWindow().setEnterTransition(fade);
            getWindow().setExitTransition(fade);
            String imageTransitionName = extras.getString("EXTRA_TRANSITION_NAME");
            orgImage.setTransitionName(imageTransitionName);
        }

        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(" ");
                }
                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange())
                    collapsingToolbarLayout.setTitle(organization.getName());
            }
        });

        ImageView orgIcon = findViewById(R.id.org_detail_image);
        TextView orgDesc = findViewById(R.id.org_detail_desc);

        Picasso.with(this).load(organization.getImageUrl()).into(orgIcon, new Callback() {
            @Override
            public void onSuccess() {
                supportStartPostponedEnterTransition();
            }

            @Override
            public void onError() {
                supportStartPostponedEnterTransition();
            }
        });
        orgDesc.setText(organization.getPrecis());

        ViewPager viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return false;
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return OrgDetailFragment.newInstance();
                case 1:
                    return ProjectFragment.newInstance(orgID);
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.orgTitle);
                case 1:
                    return getString(R.string.orgProject);
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}

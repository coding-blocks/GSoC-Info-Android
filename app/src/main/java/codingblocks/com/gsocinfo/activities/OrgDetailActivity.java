package codingblocks.com.gsocinfo.activities;

import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.fragments.OrgDetailFragment;
import codingblocks.com.gsocinfo.fragments.ProjectFragment;
import codingblocks.com.gsocinfo.model.Organizations;

import static codingblocks.com.gsocinfo.adapters.OrgAdapter.ORG_TAG;

public class OrgDetailActivity extends AppCompatActivity {

    private Organizations.Organization organization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();
        organization = i.getParcelableExtra(ORG_TAG);
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (verticalOffset == 0){
                    collapsingToolbarLayout.setTitle(" ");
                }
                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange())
                    collapsingToolbarLayout.setTitle(organization.getName());
            }
        });

        ImageView orgIcon = findViewById(R.id.org_detail_image);
        TextView orgDesc = findViewById(R.id.org_detail_desc);

        Picasso.with(this).load(organization.getImageUrl()).into(orgIcon);
        orgDesc.setText(organization.getPrecis());

        ViewPager viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 :
                    return OrgDetailFragment.newInstance();
                case 1:
                    return ProjectFragment.newInstance(organization.getName());
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0 :
                    return getString(R.string.orgTitle);
                case 1 :
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

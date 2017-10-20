package codingblocks.com.gsocinfo.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.adapters.OrgAdapter;
import codingblocks.com.gsocinfo.data.model.Organization;
import codingblocks.com.gsocinfo.data.viewmodel.OrganizationViewModel;

/**
 * Created by harshit on 25/08/17.
 */

public class OrganizationFragment extends Fragment {

    OrganizationViewModel organizationViewModel;
    private OrgAdapter orgAdapter;

    public static OrganizationFragment newInstance() {
        Bundle args = new Bundle();
        OrganizationFragment fragment = new OrganizationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.about, menu);
        SearchView searchView;
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) searchMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                organizationViewModel = ViewModelProviders.of(getActivity()).get(OrganizationViewModel.class);
                organizationViewModel.getOrgsByName(query).observe(getActivity(), new Observer<PagedList<Organization>>() {
                    @Override
                    public void onChanged(@Nullable PagedList<Organization> organizations) {
                        orgAdapter.setList(organizations);
                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.equals("")) {
                    organizationViewModel.getOrganizations().observe(getActivity(), new Observer<PagedList<Organization>>() {
                        @Override
                        public void onChanged(@Nullable PagedList<Organization> organizations) {
                            orgAdapter.setList(organizations);
                        }
                    });
                }
                return false;
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_org, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_org);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        float width = displayMetrics.widthPixels / displayMetrics.density;
        final int spanCount = (int) (width / 180.00);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL));
        orgAdapter = new OrgAdapter();
        recyclerView.setAdapter(orgAdapter);
        organizationViewModel = ViewModelProviders.of(getActivity()).get(OrganizationViewModel.class);
        setHasOptionsMenu(true);
        organizationViewModel.getOrganizations().observe(this, new Observer<PagedList<Organization>>() {
            @Override
            public void onChanged(@Nullable PagedList<Organization> organizations) {
                orgAdapter.setList(organizations);
                view.findViewById(R.id.progressBar).setVisibility(View.GONE);
            }
        });

        return view;
    }

}

package codingblocks.com.gsocinfo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.adapters.OrgAdapter;

/**
 * Created by harshit on 25/08/17.
 */

public class OrganizationFragment extends Fragment {

    public static OrganizationFragment newInstance() {

        Bundle args = new Bundle();

        OrganizationFragment fragment = new OrganizationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_org, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_org);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        OrgAdapter orgAdapter = new OrgAdapter();
        recyclerView.setAdapter(orgAdapter);
        return view;
    }
}

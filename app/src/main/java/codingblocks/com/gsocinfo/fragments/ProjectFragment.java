package codingblocks.com.gsocinfo.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.adapters.ProjectAdapter;
import codingblocks.com.gsocinfo.data.model.Projects;
import codingblocks.com.gsocinfo.data.viewmodel.ProjectViewModel;

/**
 * Created by harshit on 31/08/17.
 */

public class ProjectFragment extends Fragment {

    private ProjectAdapter projectAdapter;

    public static ProjectFragment newInstance(String orgID) {
        Bundle args = new Bundle();
        args.putString("ORG", orgID);
        ProjectFragment fragment = new ProjectFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_project, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.rv_projects);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        projectAdapter = new ProjectAdapter();

        ProjectViewModel projectViewModel = ViewModelProviders.of(this).get(ProjectViewModel.class);
        String orgID = getArguments().getString("ORG");
        if (orgID != null && !orgID.equals(""))
            projectViewModel.setProjectByOrgID(orgID);

        projectViewModel.getProjects().observe(this, new Observer<List<Projects.Project>>() {
            @Override
            public void onChanged(@Nullable List<Projects.Project> projects) {
                projectAdapter.setData(projects);
            }
        });
        recyclerView.setAdapter(projectAdapter);

        return v;
    }

}

package codingblocks.com.gsocinfo.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
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
        final View view = inflater.inflate(R.layout.fragment_project, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_projects);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        float width = displayMetrics.widthPixels / displayMetrics.density;
        final int spanCount = (int) (width / 240.00);

        final StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        projectAdapter = new ProjectAdapter();
        ProjectViewModel projectViewModel = ViewModelProviders.of(getActivity()).get(ProjectViewModel.class);
        String orgID = getArguments().getString("ORG");
        if (orgID != null && !orgID.equals("")) {
            projectViewModel.getProjectsByOrgID(orgID).observe(this, new Observer<List<Projects.Project>>() {
                @Override
                public void onChanged(@Nullable List<Projects.Project> projects) {
                    projectAdapter.setData(projects);
                    view.findViewById(R.id.progressBar).setVisibility(View.GONE);
                }
            });
        } else {
            projectViewModel.getProjects().observe(this, new Observer<List<Projects.Project>>() {
                @Override
                public void onChanged(@Nullable List<Projects.Project> projects) {
                    projectAdapter.setData(projects);
                    view.findViewById(R.id.progressBar).setVisibility(View.GONE);
                }
            });
        }
        recyclerView.setAdapter(projectAdapter);

        return view;
    }

}

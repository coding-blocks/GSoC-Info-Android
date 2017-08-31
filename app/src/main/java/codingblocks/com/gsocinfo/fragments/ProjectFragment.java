package codingblocks.com.gsocinfo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import codingblocks.com.gsocinfo.Constants;
import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.adapters.ProjectAdapter;
import codingblocks.com.gsocinfo.model.Projects;

/**
 * Created by harshit on 31/08/17.
 */

public class ProjectFragment extends Fragment {

    int beg = 0, end = 20;

    public static ProjectFragment newInstance() {

        Bundle args = new Bundle();

        ProjectFragment fragment = new ProjectFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_project, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.rv_projects);
        final ProjectAdapter projectAdapter = new ProjectAdapter();
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(projectAdapter);
        final ArrayList<Projects.Project> projectArrayList = Constants.getProjects();
        projectAdapter.setData(projectArrayList.subList(beg, end));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalItemCount = linearLayoutManager.getItemCount();
                int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (totalItemCount <= (lastVisibleItem + 5) && totalItemCount < projectArrayList.size()) {
                    projectAdapter.setData(projectArrayList.subList(end+1,end + 20));
                }
            }
        });

        return v;

    }
}

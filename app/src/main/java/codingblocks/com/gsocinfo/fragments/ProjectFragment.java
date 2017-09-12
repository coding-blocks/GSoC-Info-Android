package codingblocks.com.gsocinfo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import codingblocks.com.gsocinfo.Constants;
import codingblocks.com.gsocinfo.GSoCApp;
import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.adapters.ProjectAdapter;

import static android.content.ContentValues.TAG;

/**
 * Created by harshit on 31/08/17.
 */

public class ProjectFragment extends Fragment {

    public static ProjectFragment newInstance(@Nullable String id) {

        Bundle args = new Bundle();
        if (id != null) {
            args.putString("ORG", id);
        }
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
        final String orgId = getArguments().getString("ORG");
        if (orgId != null && !orgId.equals("")) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Log.e(TAG, "run: " + orgId);
                    projectAdapter.setData(GSoCApp.getProjectDao().getProjectByOrgId(orgId));
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            projectAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }).start();
        } else {
            projectAdapter.setData(Constants.getProjects());
            projectAdapter.notifyDataSetChanged();
        }
        return v;

    }
}

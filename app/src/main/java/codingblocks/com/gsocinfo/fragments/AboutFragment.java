package codingblocks.com.gsocinfo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import codingblocks.com.gsocinfo.Constants;
import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.adapters.TimelineAdapter;

/**
 * Created by harshit on 25/08/17.
 */

public class AboutFragment extends Fragment {

    public static AboutFragment newInstance() {

        Bundle args = new Bundle();

        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_timeline);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final TimelineAdapter timelineAdapter = new TimelineAdapter();
        timelineAdapter.setData(Constants.getCopy());
        recyclerView.setAdapter(timelineAdapter);
        return view;
    }

}

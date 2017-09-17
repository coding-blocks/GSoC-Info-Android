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

import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.adapters.TimelineAdapter;
import codingblocks.com.gsocinfo.data.model.MainPage;
import codingblocks.com.gsocinfo.data.viewmodel.MainPageViewModel;

/**
 * Created by harshit on 25/08/17.
 */

public class MainPageFragment extends Fragment {

    private TimelineAdapter timelineAdapter;
    private MainPage.Copy copy;

    public static MainPageFragment newInstance() {
        Bundle args = new Bundle();

        MainPageFragment fragment = new MainPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_timeline);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        MainPageViewModel mainPageViewModel = ViewModelProviders.of(getActivity()).get(MainPageViewModel.class);
        timelineAdapter = new TimelineAdapter();
        recyclerView.setAdapter(timelineAdapter);
        mainPageViewModel.getMainPageCopy().observe(this, new Observer<MainPage.Copy>() {
            @Override
            public void onChanged(@Nullable MainPage.Copy copy) {
                timelineAdapter.setData(copy);
            }
        });
        return view;
    }

}

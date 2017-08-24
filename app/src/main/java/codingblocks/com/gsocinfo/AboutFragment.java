package codingblocks.com.gsocinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by harshit on 25/08/17.
 */

public class AboutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_timeline);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        TimelineAdapter timelineAdapter = new TimelineAdapter(null, null, null);

        recyclerView.setAdapter(timelineAdapter);
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

package codingblocks.com.gsocinfo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import codingblocks.com.gsocinfo.Constants;
import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.adapters.FaqAdapter;

/**
 * Created by harshit on 25/08/17.
 */

public class FaqFragment extends Fragment {

    public static FaqFragment newInstance() {

        Bundle args = new Bundle();

        FaqFragment fragment = new FaqFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faq, container, false);
        Animation animationUp, animationDown;

        animationUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        animationDown = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);

        RecyclerView generalRv = view.findViewById(R.id.rv_general_faq);
        FaqAdapter generalAdapter = new FaqAdapter(Constants.getGeneralQuestions(), Constants.getGeneralAnswers(), animationDown, animationUp);
        generalRv.setLayoutManager(new LinearLayoutManager(getContext()));

        generalRv.setAdapter(generalAdapter);

        return view;
    }
}

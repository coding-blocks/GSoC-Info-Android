package codingblocks.com.gsocinfo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.commonsware.cwac.anddown.AndDown;

import java.util.ArrayList;
import java.util.List;

import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.adapters.TagAdapter;
import codingblocks.com.gsocinfo.data.model.Organization;

import static codingblocks.com.gsocinfo.adapters.OrgAdapter.ORG_TAG;

/**
 * Created by harshit on 27/08/17.
 */

public class OrgDetailFragment extends Fragment {

    public static OrgDetailFragment newInstance() {

        Bundle args = new Bundle();

        OrgDetailFragment fragment = new OrgDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_org_details,container,false);
        Intent i = getActivity().getIntent();
        Organization organization = (Organization) i.getSerializableExtra(ORG_TAG);

        TextView orgDetails = view.findViewById(R.id.org_detail_details);
        TextView orgTitle = view.findViewById(R.id.org_detail_title);

        AndDown andDown=new AndDown();

        String orgDesc = organization.getDescription();
//                .replaceAll("(\\? )|(\\! )|(\\. )", "$0\n"); //Replace every period with newline

        orgDesc = andDown.markdownToHtml(orgDesc);  //Todo : do this while inserting to db

        orgDetails.setText(Html.fromHtml(orgDesc));
        orgTitle.setText(organization.getTagline());
        RecyclerView techRv = view.findViewById(R.id.techTagRecyclerView);
        TagAdapter techAdapter;
        List<String> tags = new ArrayList<>();

        tags.addAll(organization.getTechnologyTags());
        tags.addAll(organization.getTopicTags());
        tags.addAll(organization.getProposalTags());
        techAdapter = new TagAdapter(tags);

        techRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));
        techRv.setAdapter(techAdapter);

        return view;
    }


}

package codingblocks.com.gsocinfo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.adapters.TagAdapter;
import codingblocks.com.gsocinfo.model.Organizations;

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
        Organizations.Organization organization = i.getParcelableExtra(ORG_TAG);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(organization.getName());

        ImageView orgIcon = view.findViewById(R.id.org_detail_image);

        TextView orgDesc = view.findViewById(R.id.org_detail_desc);
        TextView orgDetails = view.findViewById(R.id.org_detail_details);
        TextView orgTitle = view.findViewById(R.id.org_detail_title);

        orgDetails.setText(organization.getDescription().replaceAll("(\\? )|(\\! )|(\\. )", "$0\n")); //Replace every period with newline
        orgTitle.setText(organization.getTagline());
        Picasso.with(getContext()).load(organization.getImageUrl()).into(orgIcon);
        orgDesc.setText(organization.getPrecis());
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

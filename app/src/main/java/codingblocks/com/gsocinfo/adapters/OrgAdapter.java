package codingblocks.com.gsocinfo.adapters;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.activities.OrgDetailActivity;
import codingblocks.com.gsocinfo.data.model.Organizations;

import static android.content.ContentValues.TAG;

/**
 * Created by harshit on 26/08/17.
 */

public class OrgAdapter extends PagedListAdapter<Organizations.Organization, OrgAdapter.OrgHolder> {

    public static final String ORG_TAG = "ORG";
    private List<Organizations.Organization> organizations = new ArrayList<>();
    private Context context;

    public OrgAdapter() {
        super(Organizations.Organization.DIFF_CALLBACK);
    }

    public void setData(List<Organizations.Organization> organizations) {
        this.organizations.addAll(organizations);
        notifyDataSetChanged();
    }

    @Override
    public OrgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new OrgHolder(LayoutInflater.from(context).inflate(R.layout.item_org, parent, false));
    }

    @Override
    public void onBindViewHolder(OrgHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: " + position);
        Organizations.Organization currentOrg = organizations.get(position);
        if (currentOrg != null) {
            holder.orgName.setText(currentOrg.getName());
            holder.orgTagline.setText(currentOrg.getTagline());
            String currUrl = currentOrg.getImageUrl();
            Picasso.with(context).load(currUrl).into(holder.orgImage);
        }
    }

    @Override
    public int getItemCount() {
        return organizations.size();
    }


    class OrgHolder extends RecyclerView.ViewHolder {

        CardView orgCard;
        ImageView orgImage;
        TextView orgName, orgTagline;

        public OrgHolder(View itemView) {
            super(itemView);
            orgImage = itemView.findViewById(R.id.org_image);
            orgCard = itemView.findViewById(R.id.card_view_org);
            orgName = itemView.findViewById(R.id.org_name);
            orgTagline = itemView.findViewById(R.id.org_tagline);

            orgCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, OrgDetailActivity.class);
                    i.putExtra(ORG_TAG, organizations.get(getAdapterPosition()));
                    i.putExtra("ORG_ID", organizations.get(getAdapterPosition()).getOrgID());
                    context.startActivity(i);
                }
            });
        }
    }

}

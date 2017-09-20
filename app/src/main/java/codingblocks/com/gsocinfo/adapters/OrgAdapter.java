package codingblocks.com.gsocinfo.adapters;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.activities.OrgDetailActivity;
import codingblocks.com.gsocinfo.data.model.Organization;

/**
 * Created by harshit on 26/08/17.
 */

public class OrgAdapter extends PagedListAdapter<Organization, OrgAdapter.OrgHolder> {

    public static final String ORG_TAG = "ORG";
    private static DiffCallback<Organization> DIFF_CALLBACK = new DiffCallback<Organization>() {

        @Override
        public boolean areItemsTheSame(@NonNull Organization oldItem, @NonNull Organization newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Organization oldItem, @NonNull Organization newItem) {
            return areItemsTheSame(oldItem, newItem);
        }
    };
    private Context context;

    public OrgAdapter() {
        super(DIFF_CALLBACK);
    }

    @Override
    public OrgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new OrgHolder(LayoutInflater.from(context).inflate(R.layout.item_org, parent, false));
    }

    @Override
    public void onBindViewHolder(OrgHolder holder, int position) {
        Organization currentOrg = getItem(position);
        if (currentOrg != null) {
            holder.orgName.setText(currentOrg.getName());
            holder.orgTagline.setText(currentOrg.getTagline());
            String currUrl = currentOrg.getImageUrl();
            Picasso.with(context).load(currUrl).resize(320, 320).into(holder.orgImage);
        } else
            holder.clear();
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
                    i.putExtra(ORG_TAG, getItem(getAdapterPosition()));
                    i.putExtra("ORG_ID", getItem(getAdapterPosition()).getOrgID());
                    context.startActivity(i);
                }
            });
        }

        public void clear() {

        }
    }

}

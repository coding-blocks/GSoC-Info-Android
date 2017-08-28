package codingblocks.com.gsocinfo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import codingblocks.com.gsocinfo.R;

/**
 * Created by harshit on 27/08/17.
 */

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.TagViewHolder>{

    private Context context;
    private List<String> orgTags;

    public TagAdapter(List<String> orgTags) {
        this.orgTags = orgTags;
    }

    @Override
    public TagViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.item_tag,parent,false);
        return new TagViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TagViewHolder holder, int position) {
        holder.chipView.setText(orgTags.get(position));
    }

    @Override
    public int getItemCount() {
        return orgTags.size();
    }

    public class TagViewHolder extends RecyclerView.ViewHolder{

        TextView chipView;

        public TagViewHolder(View itemView) {
            super(itemView);
            chipView = itemView.findViewById(R.id.chip_org_detail);
        }
    }

}

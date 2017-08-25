package codingblocks.com.gsocinfo;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.github.vipulasri.timelineview.TimelineView;

import java.util.ArrayList;

/**
 * Created by harshit on 25/08/17.
 */

public class TimelineAdapter extends android.support.v7.widget.RecyclerView.Adapter<TimelineAdapter.TimelineHolder> {

    private ArrayList<String> date, title, description;

    public TimelineAdapter(ArrayList<String> date, ArrayList<String> title, ArrayList<String> description) {
        this.date = date;
        this.title = title;
        this.description = description;
    }


    @Override
    public TimelineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_timeline, null);
        if(viewType == 0 ){
            view = View.inflate(parent.getContext(), R.layout.item_timeline_summary, null);
        }
        return new TimelineHolder(view, viewType);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void onBindViewHolder(TimelineHolder holder, int position) {
        holder.description.setText(description.get(position));
        holder.title.setText(title.get(position));
        holder.date.setText(date.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return 0;
        }
        return TimelineView.getTimeLineViewType(position,getItemCount());
    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    public class TimelineHolder extends RecyclerView.ViewHolder{

        TimelineView timelineView;
        AppCompatTextView title,description,date;

        public TimelineHolder(View itemView, int viewType) {
            super(itemView);
            timelineView = itemView.findViewById(R.id.time_line_item);
            title = itemView.findViewById(R.id.text_timeline_title);
            description = itemView.findViewById(R.id.text_timeline_description);
            date = itemView.findViewById(R.id.text_timeline_date);
            timelineView.initLine(viewType);
        }
    }

}

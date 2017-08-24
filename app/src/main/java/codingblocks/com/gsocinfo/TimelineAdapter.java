package codingblocks.com.gsocinfo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.github.vipulasri.timelineview.TimelineView;

import java.util.ArrayList;

/**
 * Created by harshit on 25/08/17.
 */

public class TimelineAdapter extends android.support.v7.widget.RecyclerView.Adapter<TimelineAdapter.TimelineHolder> {

    private ArrayList<String> date, title, content;

    public TimelineAdapter(ArrayList<String> date, ArrayList<String> title, ArrayList<String> content) {
        this.date = date;
        this.title = title;
        this.content = content;
    }

    @Override
    public TimelineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_timeline, null);
        return new TimelineHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(TimelineHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position,getItemCount());
    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    public class TimelineHolder extends RecyclerView.ViewHolder{

        TimelineView timelineView;


        public TimelineHolder(View itemView, int viewType) {
            super(itemView);
            timelineView = itemView.findViewById(R.id.time_line_item);
            timelineView.initLine(viewType);
        }
    }

}

package codingblocks.com.gsocinfo.adapters;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.graphics.drawable.ArgbEvaluator;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.github.vipulasri.timelineview.TimelineView;

import java.util.ArrayList;

import codingblocks.com.gsocinfo.Constants;
import codingblocks.com.gsocinfo.R;

/**
 * Created by harshit on 25/08/17.
 */

public class TimelineAdapter extends android.support.v7.widget.RecyclerView.Adapter<TimelineAdapter.TimelineHolder> {

    private Context context;
    private ArrayList<String> date = Constants.generateDate(),
    title = Constants.generateTitle(), description = Constants.generateDescription();

    private int lastCheckedPosition = -1;

    @Override
    public TimelineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = View.inflate(context, R.layout.item_timeline, null);
        return new TimelineHolder(view, viewType);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void onBindViewHolder(final TimelineHolder holder, int position) {

        holder.description.setText(description.get(position));
        holder.title.setText(title.get(position));
        holder.date.setText(date.get(position));
        if (position == lastCheckedPosition){
            int colorFrom = Color.WHITE;
            int colorTo = context.getResources().getColor(R.color.colorAccent);
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.setDuration(300); // milliseconds
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    holder.title.setTextSize(18);
                    holder.date.setTextSize(16);
                    holder.description.setTextSize(18);
                    holder.cardView.setBackgroundColor((int) animator.getAnimatedValue());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        holder.cardView.setElevation(6);
                    }
                }

            });
            colorAnimation.start();
        }else{
            holder.title.setTextSize(16);
            holder.date.setTextSize(14);
            holder.description.setTextSize(16);
            holder.cardView.setBackgroundColor(Color.WHITE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.cardView.setElevation(1);
            }
        }
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
        AppCompatTextView title,description,date;
        CardView cardView;

        public TimelineHolder(View itemView, int viewType) {
            super(itemView);
            timelineView = itemView.findViewById(R.id.time_line_item);
            title = itemView.findViewById(R.id.text_timeline_title);
            description = itemView.findViewById(R.id.text_timeline_description);
            date = itemView.findViewById(R.id.text_timeline_date);
            cardView = itemView.findViewById(R.id.cardview_timeline);
            timelineView.initLine(viewType);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lastCheckedPosition = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
        }
    }

}

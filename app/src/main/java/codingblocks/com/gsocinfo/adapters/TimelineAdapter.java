package codingblocks.com.gsocinfo.adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.vipulasri.timelineview.LineType;
import com.github.vipulasri.timelineview.TimelineView;

import java.util.List;

import codingblocks.com.gsocinfo.Constants;
import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.data.model.MainPage;

/**
 * Created by harshit on 25/08/17.
 */

public class TimelineAdapter extends android.support.v7.widget.RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int HEADER = 123;
    private List<String> date = Constants.generateDate(),
            title = Constants.generateTitle(),
            description = Constants.generateDescription();
    private MainPage.Copy mainPage;

    public TimelineAdapter() {
    }

    public void setData(MainPage.Copy copy) {
        this.mainPage = copy;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view;
        if (viewType == HEADER) {
            view = View.inflate(context, R.layout.item_card_about, null);
            return new AboutHolder(view);
        } else {
            view = View.inflate(context, R.layout.item_timeline, null);
            return new TimelineHolder(view, viewType);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TimelineHolder) {
            ((TimelineHolder) holder).description.setText(description.get(position));
            ((TimelineHolder) holder).title.setText(title.get(position));
            ((TimelineHolder) holder).date.setText(date.get(position));
        } else if (holder instanceof AboutHolder) {
            ((AboutHolder) holder).about.setText(mainPage.getNumberOfStudents() + " STUDENTS, " +
                    mainPage.getNumberOfStudentCountries() + " COUNTRIES,\n" +
                    mainPage.getNumberOfYears() + " YEARS, " + mainPage.getNumberOfOrganizations()
                    + " OPEN SOURCE ORGANIZATIONS");
            ((AboutHolder) holder).linesOfCode.setText(mainPage.getNumberOfLinesOfCode());
            ((AboutHolder) holder).overView.setText(mainPage.getHomepageIntroParagraph());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER;
        } else if (position == getItemCount() - 1) {
            return LineType.END;
        }
        return TimelineView.getTimeLineViewType(position - 1, getItemCount());
    }

    @Override
    public int getItemCount() {
        if (mainPage == null)
            return 0;
        return date.size();
    }

    public class AboutHolder extends RecyclerView.ViewHolder {
        TextView overView, linesOfCode, about;

        public AboutHolder(View itemView) {
            super(itemView);
            overView = itemView.findViewById(R.id.overView);
            linesOfCode = itemView.findViewById(R.id.linesOfCode);
            about = itemView.findViewById(R.id.textAbout);
        }
    }

    public class TimelineHolder extends RecyclerView.ViewHolder {

        TimelineView timelineView;
        AppCompatTextView title, description, date;
        CardView cardView;

        public TimelineHolder(View itemView, int viewType) {
            super(itemView);
            timelineView = itemView.findViewById(R.id.time_line_item);
            title = itemView.findViewById(R.id.text_timeline_title);
            description = itemView.findViewById(R.id.text_timeline_description);
            date = itemView.findViewById(R.id.text_timeline_date);
            cardView = itemView.findViewById(R.id.cardview_timeline);
            timelineView.initLine(viewType);
        }

    }

}

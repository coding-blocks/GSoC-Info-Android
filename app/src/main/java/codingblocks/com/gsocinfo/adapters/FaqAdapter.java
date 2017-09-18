package codingblocks.com.gsocinfo.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import codingblocks.com.gsocinfo.R;

import static android.view.View.GONE;

/**
 * Created by harshit on 25/08/17.
 */

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqHolder> {

    private ArrayList<String> questions, answers;
    private int lastCheckedPosition = -1;
    private Context context;

    public FaqAdapter(ArrayList<String> questions, ArrayList<String> answers) {
        this.questions = questions;
        this.answers = answers;

    }

    @Override
    public FaqHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        return new FaqHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_faq, parent, false));
    }

    @Override
    public void onBindViewHolder(final FaqHolder holder, int position) {
        holder.question.setText(questions.get(position));
        holder.answer.setVisibility(GONE);
        holder.answer.setText(Html.fromHtml(answers.get(position)));
        holder.answer.setClickable(true);
        holder.answer.setMovementMethod(LinkMovementMethod.getInstance());
        holder.answer.setLinkTextColor(context.getResources().getColor(R.color.colorPrimary));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class FaqHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayoutFaq;
        CardView cardView;
        TextView question, answer;

        public FaqHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview_faq);
            question = itemView.findViewById(R.id.question_faq);
            answer = itemView.findViewById(R.id.answer_faq);
            linearLayoutFaq = itemView.findViewById(R.id.linearLayoutFaq);
            linearLayoutFaq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (answer.isShown()) {
                        answer.setVisibility(GONE);
                    }else {
                        answer.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    }

}

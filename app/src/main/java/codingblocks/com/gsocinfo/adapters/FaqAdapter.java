package codingblocks.com.gsocinfo.adapters;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import java.util.ArrayList;

import codingblocks.com.gsocinfo.R;

/**
 * Created by harshit on 25/08/17.
 */

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqHolder> {

    private Animation animationDown,animationUp;
    private ArrayList<String> questions, answers;
    private int lastCheckedPosition = -1;
    private Context context;

    public FaqAdapter(ArrayList<String> questions, ArrayList<String> answers, Animation animationDown, Animation animationUp) {
        this.questions = questions;
        this.answers = answers;
        this.animationDown = animationDown;
        this.animationUp = animationUp;
    }

    @Override
    public FaqHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        return new FaqHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_faq, parent, false));
    }

    @Override
    public void onBindViewHolder(final FaqHolder holder, int position) {
        holder.question.setText(questions.get(position));
        collapse(holder);
        holder.answer.setText(Html.fromHtml(answers.get(position)));
        holder.answer.setClickable(true);
        holder.answer.setMovementMethod(LinkMovementMethod.getInstance());
        holder.answer.setLinkTextColor(context.getResources().getColor(R.color.colorPrimary));
    }

    public void expand(final FaqHolder h) {
        h.answer.setVisibility(View.VISIBLE);
        h.answer.startAnimation(animationDown);
        int colorFrom = Color.WHITE;
        int colorTo = context.getResources().getColor(R.color.colorAccent);
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(300); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                h.question.setTextSize(18);
                h.answer.setTextSize(16);
                h.cardView.setBackgroundColor((int) animator.getAnimatedValue());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    h.cardView.setElevation(6);
                }
            }

        });
        colorAnimation.start();
    }

    public void collapse(final FaqHolder h) {
        h.answer.startAnimation(animationUp);

        int colorTo = Color.WHITE;
        int colorFrom  = context.getResources().getColor(R.color.colorAccent);
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(300);// milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                h.question.setTextSize(16);
                h.cardView.setBackgroundColor(Color.WHITE);
            }
        });
        colorAnimation.start();

        CountDownTimer countDownTimer = new CountDownTimer(300, 16) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                h.answer.setVisibility(View.GONE);
            }
        };
        countDownTimer.start();

    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class FaqHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView question, answer;

        public FaqHolder(View itemView) {
            super(itemView);
            final FaqHolder faqHolder = this;
            cardView = itemView.findViewById(R.id.cardview_faq);
            question = itemView.findViewById(R.id.question_faq);
            answer = itemView.findViewById(R.id.answer_faq);
            faqHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (faqHolder.answer.isShown()){
                        collapse(faqHolder);
                    }else {
                        expand(faqHolder);
                    }
                }
            });
        }
    }

}

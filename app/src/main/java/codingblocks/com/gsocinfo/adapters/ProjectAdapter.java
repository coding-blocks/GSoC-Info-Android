package codingblocks.com.gsocinfo.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.model.Projects;

/**
 * Created by harshit on 26/08/17.
 */

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectHolder> {

    private Context context;
    private ArrayList<Projects.Project> projects = new ArrayList<>();
    private int count = 0; //keeping track of card item created for setting the background

    public void setData(List<Projects.Project> projects){
        this.projects.addAll(projects);
        notifyDataSetChanged();
    }

    @Override
    public ProjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new ProjectHolder(LayoutInflater.from(context).inflate(R.layout.item_project, parent, false));
    }

    @Override
    public void onBindViewHolder(ProjectHolder holder, int position) {

        Projects.Project currProject = projects.get(position);
        holder.studentName.setText(currProject.getStudent().getDisplayName());
        holder.projectName.setText(currProject.getTitle());
        holder.orgName.setText(currProject.getOrganization().getName());
        holder.projectMentor.setText("");
        for (int i = 0; i < currProject.getAssigneeDisplayNames().size(); i++) {
            if (i == currProject.getAssigneeDisplayNames().size() - 1)
                holder.projectMentor.append(currProject.getAssigneeDisplayNames().get(i));
            else
                holder.projectMentor.append(currProject.getAssigneeDisplayNames().get(i) + ", ");
        }
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    class ProjectHolder extends RecyclerView.ViewHolder {

        TextView studentName, projectName, projectMentor, orgName;
        ImageView urlImage;
        FrameLayout frameLayout;

        public ProjectHolder(View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.studentName);
            projectName = itemView.findViewById(R.id.projectName);
            projectMentor = itemView.findViewById(R.id.mentorName);
            orgName = itemView.findViewById(R.id.orgName);
            frameLayout = itemView.findViewById(R.id.frameLayoutProject);
            urlImage = itemView.findViewById(R.id.linkImage);

            switch (count++ % 4) {
                case 0:
                    frameLayout.setBackground(context.getResources().getDrawable(R.drawable.project_bg_one));
                    break;
                case 1:
                    frameLayout.setBackground(context.getResources().getDrawable(R.drawable.project_bg_two));
                    break;
                case 2:
                    frameLayout.setBackground(context.getResources().getDrawable(R.drawable.project_bg_three));
                    break;
                case 3:
                    frameLayout.setBackground(context.getResources().getDrawable(R.drawable.project_bg_four));
                    break;
            }

            urlImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    String url = projects.get(getAdapterPosition()).getId();
                    intent.setData(Uri.parse(url));
                    context.startActivity(intent);
                }
            });
        }
    }

}

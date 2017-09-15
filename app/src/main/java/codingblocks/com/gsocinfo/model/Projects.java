package codingblocks.com.gsocinfo.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by harshit on 25/08/17.
 */
public class Projects {

    @SerializedName("count")
    private Integer count;
    @SerializedName("next")
    private String next;
    @SerializedName("previous")
    private String previous;
    @SerializedName("results")

    private ArrayList<Project> results;

    public Integer getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public Object getPrevious() {
        return previous;
    }

    public ArrayList<Project> getResults() {
        return results;
    }

/*
    Not needed since @Embedded handles this automatically

    @Entity(tableName = "projects",
            foreignKeys = {@ForeignKey(entity = Student.class,
                    parentColumns = "studentID",
                    childColumns = "student_id",
                    onDelete = CASCADE),
                    @ForeignKey(entity = Organizations.Organization.class,
                            parentColumns = "orgID",
                            childColumns = "org_id",
                            onDelete = CASCADE)
            }
    )
 */

@Entity(tableName = "projects")
    public static class Project {
        @PrimaryKey
        @SerializedName("id")
        private long projectID;
        @SerializedName("title")
        private String title;
        @SerializedName("subcategory")
        private String subcategory;
        @SerializedName("organization")
        @Embedded
        private Organizations.Organization organization;
        @SerializedName("student")
        @Embedded
        private Student student;
        @SerializedName("abstract")
        private String _abstract;
        @SerializedName("assignee_display_names")
        private ArrayList<String> assigneeDisplayNames = null;

        public static final DiffCallback<Project> DIFF_CALLBACK = new DiffCallback<Project>() {
            @Override
            public boolean areItemsTheSame(@NonNull Project oldItem, @NonNull Project newItem) {
                return oldUser.getId() == newUser.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Project oldItem, @NonNull Project newItem) {
                return false;
            }
        };

        public Project(long projectID, String title, String subcategory, Organizations.Organization organization, Student student, String _abstract, ArrayList<String> assigneeDisplayNames) {
            this.projectID = projectID;
            this.title = title;
            this.subcategory = subcategory;
            this.organization = organization;
            this.student = student;
            this._abstract = _abstract;
            this.assigneeDisplayNames = assigneeDisplayNames;
        }

        public String getId() {
            return "https://summerofcode.withgoogle.com/projects/#" + projectID;
        }

        public void setId(long id) {
            this.projectID = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubcategory() {
            return subcategory;
        }

        public Organizations.Organization getOrganization() {
            return organization;
        }

        public void setOrganization(Organizations.Organization organization) {
            this.organization = organization;
        }

        public long getProjectID() {
            return projectID;
        }

        public void setProjectID(long projectID) {
            this.projectID = projectID;
        }

        public Student getStudent() {
            return student;
        }

        public String getAbstract() {
            return _abstract;
        }

        public ArrayList<String> getAssigneeDisplayNames() {
            return assigneeDisplayNames;
        }

        public void setSubcategory(String subcategory) {
            this.subcategory = subcategory;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public void set_abstract(String _abstract) {
            this._abstract = _abstract;
        }

        public void setAssigneeDisplayNames(ArrayList<String> assigneeDisplayNames) {
            this.assigneeDisplayNames = assigneeDisplayNames;
        }

    }

}
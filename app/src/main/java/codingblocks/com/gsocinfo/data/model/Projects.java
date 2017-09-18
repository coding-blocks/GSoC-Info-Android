package codingblocks.com.gsocinfo.data.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.EqualsAndHashCode;

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

    @EqualsAndHashCode
    @Entity(tableName = "projects")
    public static class Project implements Parcelable{
        public static final DiffCallback<Project> DIFF_CALLBACK = new DiffCallback<Project>() {
            @Override
            public boolean areItemsTheSame(@NonNull Project oldItem, @NonNull Project newItem) {
                return oldItem.getId().equals(newItem.getId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Project oldItem, @NonNull Project newItem) {
                return oldItem.getId().equals(newItem.getId());
            }
        };
        public static final Creator<Project> CREATOR = new Creator<Project>() {
            @Override
            public Project createFromParcel(Parcel in) {
                return new Project(in);
            }

            @Override
            public Project[] newArray(int size) {
                return new Project[size];
            }
        };
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

        public Project() {
        }

        protected Project(Parcel in) {
            projectID = in.readLong();
            title = in.readString();
            subcategory = in.readString();
            organization = in.readParcelable(Organizations.Organization.class.getClassLoader());
            _abstract = in.readString();
            assigneeDisplayNames = in.createStringArrayList();
        }

        public long getProjectID() {
            return projectID;
        }

        public void setProjectID(long projectID) {
            this.projectID = projectID;
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

        public void setSubcategory(String subcategory) {
            this.subcategory = subcategory;
        }

        public Organizations.Organization getOrganization() {
            return organization;
        }

        public void setOrganization(Organizations.Organization organization) {
            this.organization = organization;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public String get_abstract() {
            return _abstract;
        }

        public void set_abstract(String _abstract) {
            this._abstract = _abstract;
        }

        public ArrayList<String> getAssigneeDisplayNames() {
            return assigneeDisplayNames;
        }

        public void setAssigneeDisplayNames(ArrayList<String> assigneeDisplayNames) {
            this.assigneeDisplayNames = assigneeDisplayNames;
        }

        public String getId() {
            return "https://summerofcode.withgoogle.com/projects/#" + projectID;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(projectID);
            parcel.writeString(title);
            parcel.writeString(subcategory);
            parcel.writeParcelable(organization, i);
            parcel.writeString(_abstract);
            parcel.writeStringList(assigneeDisplayNames);
        }
    }

}
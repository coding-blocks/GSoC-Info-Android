package codingblocks.com.gsocinfo.data.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by harshit on 19/09/17.
 */

@Entity(tableName = "projects")
public class Project {

    @PrimaryKey
    @SerializedName("id")
    private String projectID;
    @SerializedName("title")
    private String title;
    @SerializedName("subcategory")
    private String subcategory;
    @SerializedName("organization")
    @Embedded
    private Organization organization;
    @SerializedName("student")
    @Embedded
    private Student student;
    @SerializedName("abstract")
    private String _abstract;
    @SerializedName("assignee_display_names")
    private ArrayList<String> assigneeDisplayNames = null;

    public Project() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Project) {
            Project other = (Project) obj;

            return (projectID.equals(other.projectID));
        }

        return (false);
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
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

}
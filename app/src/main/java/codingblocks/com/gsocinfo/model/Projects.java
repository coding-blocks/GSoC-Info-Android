package codingblocks.com.gsocinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harshit on 25/08/17.
 */
public class Projects {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("previous")
    @Expose
    private String previous;
    @SerializedName("results")
    @Expose
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

    public class Project {

        @SerializedName("id")
        @Expose
        private long id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("subcategory")
        @Expose
        private String subcategory;
        @SerializedName("organization")
        @Expose
        private Organizations.Organization organization;
        @SerializedName("student")
        @Expose
        private Student student;
        @SerializedName("abstract")
        @Expose
        private String _abstract;
        @SerializedName("assignee_display_names")
        @Expose
        private ArrayList<String> assigneeDisplayNames = null;
        @SerializedName("program_year")
        @Expose
        private Integer programYear;

        public String getId() {
            return "https://summerofcode.withgoogle.com/projects/#" + id;
        }

        public void setId(long id) {
            this.id = id;
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

        public Student getStudent() {
            return student;
        }

        public String getAbstract() {
            return _abstract;
        }

        public List<String> getAssigneeDisplayNames() {
            return assigneeDisplayNames;
        }

        public Integer getProgramYear() {
            return programYear;
        }

    }

    public class Student {

        @SerializedName("id")
        @Expose
        private long id;
        @SerializedName("display_name")
        @Expose
        private String displayName;
        @SerializedName("program_year")
        @Expose
        private Integer programYear;

        public long getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDisplayName() {
            return displayName;
        }

        public Integer getProgramYear() {
            return programYear;
        }

    }

}
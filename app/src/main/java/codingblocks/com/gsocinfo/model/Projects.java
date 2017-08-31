package codingblocks.com.gsocinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<Project> results = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<Project> getResults() {
        return results;
    }

    public void setResults(List<Project> results) {
        this.results = results;
    }


    public class Project {

        @SerializedName("id")
        @Expose
        private Integer id;
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
        private Student student;  //Student
        @SerializedName("abstract")
        @Expose
        private String projectAbstract; //Project Details
        @SerializedName("assignee_display_names")
        @Expose
        private List<String> assigneeDisplayNames = null;  //Mentor
        @SerializedName("program_year")
        @Expose
        private Integer programYear;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
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

        public String getAbstract() {
            return projectAbstract;
        }

        public void setAbstract(String _abstract) {
            this.projectAbstract = _abstract;
        }

        public List<String> getAssigneeDisplayNames() {
            return assigneeDisplayNames;
        }

        public void setAssigneeDisplayNames(List<String> assigneeDisplayNames) {
            this.assigneeDisplayNames = assigneeDisplayNames;
        }

        public Integer getProgramYear() {
            return programYear;
        }

        public void setProgramYear(Integer programYear) {
            this.programYear = programYear;
        }

        public class Student {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("display_name")
            @Expose
            private String displayName;
            @SerializedName("program_year")
            @Expose
            private Integer programYear;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getDisplayName() {
                return displayName;
            }

            public void setDisplayName(String displayName) {
                this.displayName = displayName;
            }

            public Integer getProgramYear() {
                return programYear;
            }

            public void setProgramYear(Integer programYear) {
                this.programYear = programYear;
            }

        }

    }

}


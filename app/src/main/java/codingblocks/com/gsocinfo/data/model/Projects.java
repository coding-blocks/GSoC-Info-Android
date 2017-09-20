package codingblocks.com.gsocinfo.data.model;

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
                        @ForeignKey(entity = Organization.class,
                                parentColumns = "orgID",
                                childColumns = "org_id",
                                onDelete = CASCADE)
                }
        )
     */

}
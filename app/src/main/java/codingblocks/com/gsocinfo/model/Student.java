package codingblocks.com.gsocinfo.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import static android.R.attr.id;

/**
 * Created by harshit on 08/09/17.
 */
@Entity(tableName = "students")
public class Student {

    @SerializedName("id")
    @PrimaryKey
    private long studentID;
    @SerializedName("display_name")
    private String displayName;

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.studentID = id;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
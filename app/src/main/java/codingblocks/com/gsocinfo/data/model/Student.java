package codingblocks.com.gsocinfo.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import lombok.EqualsAndHashCode;

/**
 * Created by harshit on 08/09/17.
 */

@EqualsAndHashCode
@Entity(tableName = "students")
public class Student {

    @SerializedName("id")
    @PrimaryKey
    private long studentID;
    @SerializedName("display_name")
    private String displayName;

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
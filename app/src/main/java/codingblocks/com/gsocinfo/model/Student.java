package codingblocks.com.gsocinfo.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by harshit on 08/09/17.
 */

@EqualsAndHashCode
@Getter
@Setter
@Entity(tableName = "students")
public class Student {

    @SerializedName("id")
    @PrimaryKey
    private long studentID;
    @SerializedName("display_name")
    private String displayName;


}
package codingblocks.com.gsocinfo.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by harshit on 01/09/17.
 */
public class MainPage {

    public int mainPageId;
    private Copy copy;

    public Copy getCopy() {
        return copy;
    }

    @EqualsAndHashCode
    @Getter
    @Setter
    @Entity(tableName = "mainpage")
    public static class Copy {

        @PrimaryKey(autoGenerate = true)
        public int id;
        @SerializedName("number_of_lines_of_code")
        private String numberOfLinesOfCode;
        @SerializedName("homepage_start_button")
        private String homepageStartButton;
        @SerializedName("number_of_students")
        private String numberOfStudents;
        @SerializedName("homepage_intro_paragraph")
        private String homepageIntroParagraph;
        @SerializedName("number_of_mentors")
        private String numberOfMentors;
        @SerializedName("number_of_student_and_mentor_countries")
        private String numberOfStudentAndMentorCountries;
        @SerializedName("number_of_years")
        private String numberOfYears;
        @SerializedName("number_of_organizations")
        private String numberOfOrganizations;
        @SerializedName("number_of_student_countries")
        private String numberOfStudentCountries;
    }
}

package codingblocks.com.gsocinfo.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by harshit on 01/09/17.
 */
public class MainPage {

    public int mainPageId;
    private Copy copy;

    public Copy getCopy() {
        return copy;
    }

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

        public String getNumberOfLinesOfCode() {
            return numberOfLinesOfCode;
        }

        public String getHomepageStartButton() {
            return homepageStartButton;
        }

        public String getNumberOfStudents() {
            return numberOfStudents;
        }

        public String getHomepageIntroParagraph() {
            return homepageIntroParagraph;
        }

        public String getNumberOfMentors() {
            return numberOfMentors;
        }

        public String getNumberOfStudentAndMentorCountries() {
            return numberOfStudentAndMentorCountries;
        }

        public String getNumberOfYears() {
            return numberOfYears;
        }

        public String getNumberOfOrganizations() {
            return numberOfOrganizations;
        }

        public String getNumberOfStudentCountries() {
            return numberOfStudentCountries;
        }

        public void setNumberOfLinesOfCode(String numberOfLinesOfCode) {
            this.numberOfLinesOfCode = numberOfLinesOfCode;
        }

        public void setHomepageStartButton(String homepageStartButton) {
            this.homepageStartButton = homepageStartButton;
        }

        public void setNumberOfStudents(String numberOfStudents) {
            this.numberOfStudents = numberOfStudents;
        }

        public void setHomepageIntroParagraph(String homepageIntroParagraph) {
            this.homepageIntroParagraph = homepageIntroParagraph;
        }

        public void setNumberOfMentors(String numberOfMentors) {
            this.numberOfMentors = numberOfMentors;
        }

        public void setNumberOfStudentAndMentorCountries(String numberOfStudentAndMentorCountries) {
            this.numberOfStudentAndMentorCountries = numberOfStudentAndMentorCountries;
        }

        public void setNumberOfYears(String numberOfYears) {
            this.numberOfYears = numberOfYears;
        }

        public void setNumberOfOrganizations(String numberOfOrganizations) {
            this.numberOfOrganizations = numberOfOrganizations;
        }

        public void setNumberOfStudentCountries(String numberOfStudentCountries) {
            this.numberOfStudentCountries = numberOfStudentCountries;
        }
    }
}

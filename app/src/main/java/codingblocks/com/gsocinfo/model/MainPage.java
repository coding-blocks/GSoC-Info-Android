package codingblocks.com.gsocinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by harshit on 01/09/17.
 */

public class MainPage {

    private Copy copy;

    public Copy getCopy() {
        return copy;
    }

    public class Copy {
        @SerializedName("number_of_lines_of_code")
        @Expose
        private String numberOfLinesOfCode;
        @SerializedName("homepage_start_button")
        @Expose
        private String homepageStartButton;
        @SerializedName("number_of_students")
        @Expose
        private String numberOfStudents;
        @SerializedName("homepage_intro_paragraph")
        @Expose
        private String homepageIntroParagraph;
        @SerializedName("number_of_mentors")
        @Expose
        private String numberOfMentors;
        @SerializedName("number_of_student_and_mentor_countries")
        @Expose
        private String numberOfStudentAndMentorCountries;
        @SerializedName("number_of_years")
        @Expose
        private String numberOfYears;
        @SerializedName("number_of_organizations")
        @Expose
        private String numberOfOrganizations;
        @SerializedName("number_of_student_countries")
        @Expose
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

    }
}

package codingblocks.com.gsocinfo.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import lombok.EqualsAndHashCode;

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
    @Entity(tableName = "mainpage")
    public static class Copy implements Parcelable{

        public static final Creator<Copy> CREATOR = new Creator<Copy>() {
            @Override
            public Copy createFromParcel(Parcel in) {
                return new Copy(in);
            }

            @Override
            public Copy[] newArray(int size) {
                return new Copy[size];
            }
        };
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

        public Copy() {
        }

        protected Copy(Parcel in) {
            id = in.readInt();
            numberOfLinesOfCode = in.readString();
            homepageStartButton = in.readString();
            numberOfStudents = in.readString();
            homepageIntroParagraph = in.readString();
            numberOfMentors = in.readString();
            numberOfStudentAndMentorCountries = in.readString();
            numberOfYears = in.readString();
            numberOfOrganizations = in.readString();
            numberOfStudentCountries = in.readString();
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNumberOfLinesOfCode() {
            return numberOfLinesOfCode;
        }

        public void setNumberOfLinesOfCode(String numberOfLinesOfCode) {
            this.numberOfLinesOfCode = numberOfLinesOfCode;
        }

        public String getHomepageStartButton() {
            return homepageStartButton;
        }

        public void setHomepageStartButton(String homepageStartButton) {
            this.homepageStartButton = homepageStartButton;
        }

        public String getNumberOfStudents() {
            return numberOfStudents;
        }

        public void setNumberOfStudents(String numberOfStudents) {
            this.numberOfStudents = numberOfStudents;
        }

        public String getHomepageIntroParagraph() {
            return homepageIntroParagraph;
        }

        public void setHomepageIntroParagraph(String homepageIntroParagraph) {
            this.homepageIntroParagraph = homepageIntroParagraph;
        }

        public String getNumberOfMentors() {
            return numberOfMentors;
        }

        public void setNumberOfMentors(String numberOfMentors) {
            this.numberOfMentors = numberOfMentors;
        }

        public String getNumberOfStudentAndMentorCountries() {
            return numberOfStudentAndMentorCountries;
        }

        public void setNumberOfStudentAndMentorCountries(String numberOfStudentAndMentorCountries) {
            this.numberOfStudentAndMentorCountries = numberOfStudentAndMentorCountries;
        }

        public String getNumberOfYears() {
            return numberOfYears;
        }

        public void setNumberOfYears(String numberOfYears) {
            this.numberOfYears = numberOfYears;
        }

        public String getNumberOfOrganizations() {
            return numberOfOrganizations;
        }

        public void setNumberOfOrganizations(String numberOfOrganizations) {
            this.numberOfOrganizations = numberOfOrganizations;
        }

        public String getNumberOfStudentCountries() {
            return numberOfStudentCountries;
        }

        public void setNumberOfStudentCountries(String numberOfStudentCountries) {
            this.numberOfStudentCountries = numberOfStudentCountries;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeString(numberOfLinesOfCode);
            parcel.writeString(homepageStartButton);
            parcel.writeString(numberOfStudents);
            parcel.writeString(homepageIntroParagraph);
            parcel.writeString(numberOfMentors);
            parcel.writeString(numberOfStudentAndMentorCountries);
            parcel.writeString(numberOfYears);
            parcel.writeString(numberOfOrganizations);
            parcel.writeString(numberOfStudentCountries);
        }
    }
}

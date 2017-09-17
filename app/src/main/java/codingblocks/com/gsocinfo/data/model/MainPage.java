package codingblocks.com.gsocinfo.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

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
    public static class Copy implements Parcelable{

        public Copy() {
        }

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

package codingblocks.com.gsocinfo.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by harshit on 25/08/17.
 */
public class Organizations {

    private ArrayList<Organization> results;

    public ArrayList<Organization> getResults() {
        return results;
    }

    @EqualsAndHashCode
    @Getter
    @Setter
    @Entity(tableName = "organizations")
    public static class Organization implements Parcelable{

        public Organization() {
        }

        @SerializedName("id")
        @PrimaryKey
        private String orgID;
        @SerializedName("name")
        private String name;
        @SerializedName("website_url")
        private String websiteUrl;
        @SerializedName("category")
        private String category;
        @SerializedName("contact_email")
        private String contactEmail;
        @SerializedName("mailing_list")
        private String mailingList;
        @SerializedName("irc_channel")
        private String ircChannel;
        @SerializedName("tagline")
        private String tagline;
        @SerializedName("precis")
        private String precis;
        @SerializedName("description")
        private String description;
        @SerializedName("primary_open_source_license")
        private String primaryOpenSourceLicense;
        @SerializedName("image_url")
        private String imageUrl;
        @SerializedName("gplus_url")
        private String gplusUrl;
        @SerializedName("twitter_url")
        private String twitterUrl;
        @SerializedName("blog_url")
        private String blogUrl;
        @SerializedName("application_instructions")
        private String applicationInstructions;
        @SerializedName("topic_tags")
        private ArrayList<String> topicTags = null;
        @SerializedName("technology_tags")
        private ArrayList<String> technologyTags = null;
        @SerializedName("proposal_tags")
        private ArrayList<String> proposalTags = null;
        @SerializedName("ideas_list")
        private String ideasList;
        @SerializedName("contact_method")
        private String contactMethod;

        protected Organization(Parcel in) {
            name = in.readString();
            websiteUrl = in.readString();
            category = in.readString();
            contactEmail = in.readString();
            mailingList = in.readString();
            tagline = in.readString();
            precis = in.readString();
            description = in.readString();
            primaryOpenSourceLicense = in.readString();
            imageUrl = in.readString();
            gplusUrl = in.readString();
            twitterUrl = in.readString();
            blogUrl = in.readString();
            applicationInstructions = in.readString();
            topicTags = in.createStringArrayList();
            technologyTags = in.createStringArrayList();
            proposalTags = in.createStringArrayList();
            ideasList = in.readString();
            contactMethod = in.readString();
        }

        public static final Creator<Organization> CREATOR = new Creator<Organization>() {
            @Override
            public Organization createFromParcel(Parcel in) {
                return new Organization(in);
            }

            @Override
            public Organization[] newArray(int size) {
                return new Organization[size];
            }
        };

        public static Creator<Organization> getCREATOR() {
            return CREATOR;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(name);
            parcel.writeString(websiteUrl);
            parcel.writeString(category);
            parcel.writeString(contactEmail);
            parcel.writeString(mailingList);
            parcel.writeString(tagline);
            parcel.writeString(precis);
            parcel.writeString(description);
            parcel.writeString(primaryOpenSourceLicense);
            parcel.writeString(imageUrl);
            parcel.writeString(gplusUrl);
            parcel.writeString(twitterUrl);
            parcel.writeString(blogUrl);
            parcel.writeString(applicationInstructions);
            parcel.writeStringList(topicTags);
            parcel.writeStringList(technologyTags);
            parcel.writeStringList(proposalTags);
            parcel.writeString(ideasList);
            parcel.writeString(contactMethod);
        }
    }

}

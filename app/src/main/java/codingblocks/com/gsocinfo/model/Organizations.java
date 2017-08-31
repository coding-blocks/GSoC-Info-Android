package codingblocks.com.gsocinfo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harshit on 25/08/17.
 */

public class Organizations {

    private ArrayList<Organization> results;

    public ArrayList<Organization> getResults() {
        return results;
    }

    public static class Organization implements Parcelable{

        @SerializedName("id")
        @Expose
        private Long id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("website_url")
        @Expose
        private String websiteUrl;
        @SerializedName("category")
        @Expose
        private String category;
        @SerializedName("contact_email")
        @Expose
        private String contactEmail;
        @SerializedName("mailing_list")
        @Expose
        private String mailingList;
        @SerializedName("irc_channel")
        @Expose
        private Object ircChannel;
        @SerializedName("tagline")
        @Expose
        private String tagline;
        @SerializedName("precis")
        @Expose
        private String precis;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("primary_open_source_license")
        @Expose
        private String primaryOpenSourceLicense;
        @SerializedName("image_url")
        @Expose
        private String imageUrl;
        @SerializedName("image_bg_color")
        @Expose
        private Object imageBgColor;
        @SerializedName("gplus_url")
        @Expose
        private String gplusUrl;
        @SerializedName("twitter_url")
        @Expose
        private String twitterUrl;
        @SerializedName("blog_url")
        @Expose
        private String blogUrl;
        @SerializedName("application_instructions")
        @Expose
        private String applicationInstructions;
        @SerializedName("topic_tags")
        @Expose
        private List<String> topicTags = null;
        @SerializedName("technology_tags")
        @Expose
        private List<String> technologyTags = null;
        @SerializedName("proposal_tags")
        @Expose
        private List<String> proposalTags = null;
        @SerializedName("ideas_list")
        @Expose
        private String ideasList;
        @SerializedName("contact_method")
        @Expose
        private String contactMethod;
        @SerializedName("program_year")
        @Expose
        private Integer programYear;

        protected Organization(Parcel in) {
            name = in.readString();
            slug = in.readString();
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

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public String getWebsiteUrl() {
            return websiteUrl;
        }

        public String getCategory() {
            return category;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public String getMailingList() {
            return mailingList;
        }

        public Object getIrcChannel() {
            return ircChannel;
        }

        public String getTagline() {
            return tagline;
        }

        public String getPrecis() {
            return precis;
        }

        public String getDescription() {
            return description;
        }

        public String getPrimaryOpenSourceLicense() {
            return primaryOpenSourceLicense;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public Object getImageBgColor() {
            return imageBgColor;
        }

        public String getGplusUrl() {
            return gplusUrl;
        }

        public String getTwitterUrl() {
            return twitterUrl;
        }

        public String getBlogUrl() {
            return blogUrl;
        }

        public String getApplicationInstructions() {
            return applicationInstructions;
        }

        public List<String> getTopicTags() {
            return topicTags;
        }

        public List<String> getTechnologyTags() {
            return technologyTags;
        }

        public List<String> getProposalTags() {
            return proposalTags;
        }

        public String getIdeasList() {
            return ideasList;
        }

        public String getContactMethod() {
            return contactMethod;
        }

        public Integer getProgramYear() {
            return programYear;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(name);
            parcel.writeString(slug);
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

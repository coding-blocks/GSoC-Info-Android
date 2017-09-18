package codingblocks.com.gsocinfo.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.EqualsAndHashCode;

/**
 * Created by harshit on 25/08/17.
 */
public class Organizations {

    private ArrayList<Organization> results;

    public ArrayList<Organization> getResults() {
        return results;
    }

    @EqualsAndHashCode
    @Entity(tableName = "organizations")
    public static class Organization implements Parcelable{

        public static final DiffCallback<Organization> DIFF_CALLBACK = new DiffCallback<Organization>() {

            @Override
            public boolean areItemsTheSame(@NonNull Organization oldItem, @NonNull Organization newItem) {
                return oldItem.getOrgID().equals(newItem.getOrgID());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Organization oldItem, @NonNull Organization newItem) {
                return oldItem.equals(newItem);
            }
        };
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

        public Organization() {
        }

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

        public static Creator<Organization> getCREATOR() {
            return CREATOR;
        }

        public String getOrgID() {
            return orgID;
        }

        public void setOrgID(String orgID) {
            this.orgID = orgID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWebsiteUrl() {
            return websiteUrl;
        }

        public void setWebsiteUrl(String websiteUrl) {
            this.websiteUrl = websiteUrl;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        public String getMailingList() {
            return mailingList;
        }

        public void setMailingList(String mailingList) {
            this.mailingList = mailingList;
        }

        public String getIrcChannel() {
            return ircChannel;
        }

        public void setIrcChannel(String ircChannel) {
            this.ircChannel = ircChannel;
        }

        public String getTagline() {
            return tagline;
        }

        public void setTagline(String tagline) {
            this.tagline = tagline;
        }

        public String getPrecis() {
            return precis;
        }

        public void setPrecis(String precis) {
            this.precis = precis;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPrimaryOpenSourceLicense() {
            return primaryOpenSourceLicense;
        }

        public void setPrimaryOpenSourceLicense(String primaryOpenSourceLicense) {
            this.primaryOpenSourceLicense = primaryOpenSourceLicense;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getGplusUrl() {
            return gplusUrl;
        }

        public void setGplusUrl(String gplusUrl) {
            this.gplusUrl = gplusUrl;
        }

        public String getTwitterUrl() {
            return twitterUrl;
        }

        public void setTwitterUrl(String twitterUrl) {
            this.twitterUrl = twitterUrl;
        }

        public String getBlogUrl() {
            return blogUrl;
        }

        public void setBlogUrl(String blogUrl) {
            this.blogUrl = blogUrl;
        }

        public String getApplicationInstructions() {
            return applicationInstructions;
        }

        public void setApplicationInstructions(String applicationInstructions) {
            this.applicationInstructions = applicationInstructions;
        }

        public ArrayList<String> getTopicTags() {
            return topicTags;
        }

        public void setTopicTags(ArrayList<String> topicTags) {
            this.topicTags = topicTags;
        }

        public ArrayList<String> getTechnologyTags() {
            return technologyTags;
        }

        public void setTechnologyTags(ArrayList<String> technologyTags) {
            this.technologyTags = technologyTags;
        }

        public ArrayList<String> getProposalTags() {
            return proposalTags;
        }

        public void setProposalTags(ArrayList<String> proposalTags) {
            this.proposalTags = proposalTags;
        }

        public String getIdeasList() {
            return ideasList;
        }

        public void setIdeasList(String ideasList) {
            this.ideasList = ideasList;
        }

        public String getContactMethod() {
            return contactMethod;
        }

        public void setContactMethod(String contactMethod) {
            this.contactMethod = contactMethod;
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

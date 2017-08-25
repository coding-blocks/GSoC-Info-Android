package codingblocks.com.gsocinfo.model;

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

    public class Organization{

        @SerializedName("id")
        private Long id;
        @SerializedName("name")
        private String name;
        @SerializedName("slug")
        private String slug;
        @SerializedName("website_url")
        private String websiteUrl;
        @SerializedName("category")
        private String category;
        @SerializedName("contact_email")
        private String contactEmail;
        @SerializedName("mailing_list")
        private String mailingList;
        @SerializedName("irc_channel")
        private Object ircChannel;
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
        @SerializedName("image_bg_color")
        private Object imageBgColor;
        @SerializedName("gplus_url")
        private String gplusUrl;
        @SerializedName("twitter_url")
        private String twitterUrl;
        @SerializedName("blog_url")
        private String blogUrl;
        @SerializedName("application_instructions")
        private String applicationInstructions;
        @SerializedName("topic_tags")
        private List<String> topicTags = null;
        @SerializedName("technology_tags")
        private List<String> technologyTags = null;
        @SerializedName("proposal_tags")
        private List<String> proposalTags = null;
        @SerializedName("ideas_list")
        private String ideasList;
        @SerializedName("contact_method")
        private String contactMethod;
        @SerializedName("program_year")
        private Integer programYear;

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

        public void setSlug(String slug) {
            this.slug = slug;
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

        public Object getIrcChannel() {
            return ircChannel;
        }

        public void setIrcChannel(Object ircChannel) {
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

        public Object getImageBgColor() {
            return imageBgColor;
        }

        public void setImageBgColor(Object imageBgColor) {
            this.imageBgColor = imageBgColor;
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

        public List<String> getTopicTags() {
            return topicTags;
        }

        public void setTopicTags(List<String> topicTags) {
            this.topicTags = topicTags;
        }

        public List<String> getTechnologyTags() {
            return technologyTags;
        }

        public void setTechnologyTags(List<String> technologyTags) {
            this.technologyTags = technologyTags;
        }

        public List<String> getProposalTags() {
            return proposalTags;
        }

        public void setProposalTags(List<String> proposalTags) {
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

        public Integer getProgramYear() {
            return programYear;
        }

        public void setProgramYear(Integer programYear) {
            this.programYear = programYear;
        }


    }

}

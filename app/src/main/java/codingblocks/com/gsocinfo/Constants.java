package codingblocks.com.gsocinfo;

import com.google.gson.Gson;

import java.util.ArrayList;

import codingblocks.com.gsocinfo.model.Organizations;


/**
 * Created by vraun on 25-08-2017.
 */

public class Constants {

    private static Organizations organizations;

    public static void setOrganizations(String json) {
        Gson gson = new Gson();

        Constants.organizations = gson.fromJson(json, Organizations.class);
    }

    public static ArrayList<Organizations.Organization> getOrganizations(){
        return organizations.getResults();
    }

    public static ArrayList<String > generateTitle(){
        ArrayList<String> title = new ArrayList<>();
        title.add("Organisation Applications open");
        title.add("Organizations Application Deadline");
        title.add("Organizations Announced");
        title.add("Student Application Period");
        title.add("Application Review Period");
        title.add("Student Projects Announced");
        title.add("Community Bonding");
        title.add("Coding");
        title.add("Evaluations");
        title.add("Students Submit Code and Final Evaluations");
        title.add("Mentors Submit Final Evaluations");
        title.add("Results Announced");
        return title ;

    }

    public static ArrayList<String> generateDescription(){
        ArrayList<String> description = new ArrayList<>();
        description.add("Open source organizations that would like to participate as a mentor organization in this year’s program can apply.");
        description.add("All organizations wishing to be a part of GSoC 2017 must complete their application by February 9, 2017 22:30 (India Standard Time)");
        description.add("Interested students can now begin discussing project ideas with accepted mentor organizations.");
        description.add("Students can register and submit their applications to mentor organizations. All proposals must be submitted by April 3, 2017 21:30 (India Standard Time).");
        description.add("Organizations review and select student proposals.");
        description.add("Accepted students are paired with a mentor and start planning their projects and milestones.");
        description.add("Students spend a month learning more about their organization’s community.");
        description.add("Students work on their Google Summer of Code projects.\n" +
                "while time.now() < deadline:\n" +
                "  code() and debug() and document()");
        description.add("Mentors and students submit their evaluations of one another. These evaluations are a required step of the program.");
        description.add("Students submit their code, project summaries, and final evaluations of their mentors.");
        description.add("Mentors review student code samples and determine if the students have successfully completed their Google Summer of Code 2017 project.");
        description.add("Students are notified of the pass/fail status of their Google Summer of Code 2017 projects.");


        return description ;

    }

    public static ArrayList<String> generateDate(){
        ArrayList<String> date = new ArrayList<>();
        date.add("January 19, 2017");
        date.add("February 9, 2017");
        date.add("February 27, 2017");
        date.add("March 20, 2017 - April 3, 2017");
        date.add("April 3, 2017 - May 4, 2017");
        date.add("May 4, 2017");
        date.add("May 5 - 30, 2017");
        date.add("May 30, 2017 - August 21, 2017");
        date.add("June 26 - 30, 2017\n" +
                "July 24 - 28, 2017");
        date.add("August 21 - 29, 2017");
        date.add("August 29, 2017 - September 5, 2017");
        date.add("September 6, 2017");


        return date ;

    }

    public static  ArrayList<String> getGeneralQuestions(){
        ArrayList<String> generalQuestions = new ArrayList<>();

        generalQuestions.add("When can students apply for GSoC?");
        generalQuestions.add("What programming language(s) should I know to participate in GSoC?");
        generalQuestions.add("Can I submit more than one proposal?");
        generalQuestions.add("Can students already working on an open source project continue to work on it as part of GSoC?");
        generalQuestions.add("Can a group submit a proposal together to work on a single project?");
        generalQuestions.add("Should I send proposals directly to the mentoring organizations?");
        generalQuestions.add("What are the eligibility requirements for participation?");
        generalQuestions.add("What forms will I need to provide?");
        generalQuestions.add("I am an accepted student in the United States on an F1 visa. How do I get authorization to participate?");
        generalQuestions.add("How do I know if my school is “accredited”?");
        generalQuestions.add("I graduate in the middle of the program. Can I still participate?");
        generalQuestions.add("Do I get paid for participating in GSoC? ");
        generalQuestions.add("Will I get paid even if the organization does not use my code?");
        generalQuestions.add("What does a good student proposal look like?");
        generalQuestions.add("How much time does GSoC participation take?");
        generalQuestions.add("Can I earn course credit for participating in GSoC?");
        generalQuestions.add("Is Google Summer of Code (GSoC) a recruiting program?");
        generalQuestions.add("Is GSoC considered an internship, a job, or any form of employment?");
        generalQuestions.add("Are mentoring organizations required to use the code produced by students? ");
        generalQuestions.add("Where does GSoC occur?");
        generalQuestions.add("What can I do to help spread the word about GSoC?");
        generalQuestions.add("How do I organize or host a GSoC information session or meetup?");
        generalQuestions.add("Can I participate in GSoC as both a mentor and a student?");
        generalQuestions.add("What if I have more questions?");

        return generalQuestions ;

    }

    public static ArrayList<String> getGeneralAnswers(){
        ArrayList<String> generalAnswers = new ArrayList<>();
        generalAnswers.add("Please see the  <a href=\"https://developers.google.com/open-source/gsoc/timeline\">program timeline</a>   for more detailed information.");
        generalAnswers.add("The programming language you need to know depends on which organization you are\n" +
                "interested in working with. You should be familiar with the programming\n" +
                "language(s) used by that organization.");
        generalAnswers.add("Yes, each student may submit up to five proposals. However, only one per student\n" +
                "may be accepted. No more than one proposal per student will be accepted, no\n" +
                "matter how many proposals you submit.");
        generalAnswers.add("Yes, but students should be sure to note their previous relationship with the\n" +
                "project in their proposals.");
        generalAnswers.add("No, only an individual may work on a given project.");
        generalAnswers.add("No, all proposals should be submitted to the program site. Proposals submitted\n" +
                "outside of the Google Summer of Code program site ");
        generalAnswers.add("You must be at least 18 years of age\n " +
                "You must currently be a full or part-time student (or have been accepted for the fall term) at an" +
                " <a href=\"#accredited\">accredited</a> " + "university as of the student acceptance date. \n" +
                "You must be eligible to work in the country you will reside in during the program\n" +
                "You have not already been accepted as a Student in GSoC more than once"
                + "You must reside in a country that is not currently embargoed by the United States. See <a href=\"https://developers.google.com/open-source/gsoc/rules\">Program Rules</a>  for more information.");
        generalAnswers.add("All applicants will need to provide  <a href=\"https://developers.google.com/open-source/gsoc/help/proof-of-enrollment\">proof of enrollment</a>  <a href=\"#accredited\">accredited</a> educational institution.");
        generalAnswers.add("Accepted participants will need to provide appropriate <a href=\"https://developers.google.com/open-source/gsoc/help/tax-forms\">tax forms</a>");
        generalAnswers.add("Please talk to your school's international student affairs office for more details. In the past, students on an F1 visa have participated in GSoC through\n" +
                "<a href=\"http://en.wikipedia.org/wiki/Curricular_Practical_Training\">CPT</a>\n" + "but you will need to check with your school to see what will work best.\n" + "Students with accepted projects can receive a CPT letter upon request.");
        generalAnswers.add("You can learn more about accreditation for universities  <a href=\"http://en.wikipedia.org/wiki/Higher_education_accreditation\">here.</a>\n" +
                "Please note that participating in online courses, even if they are with accredited universities, does not alone constitute enrollment. You must be/will be enrolled at the university.");
        generalAnswers.add("Yes, as long as you are accepted into or enrolled in a college or university program as of the date accepted students are announced, you are eligible to participate in the program. Students must provide proof of enrollment during the proposal period.");
        generalAnswers.add("Yes! Google will provide a stipend to those students who successfully complete the program. More information on the stipend can be found  <a href=\"https://developers.google.com/open-source/gsoc/help/student-stipends\">here</a>");
        generalAnswers.add("Yes, so long as the student passes his/her evaluation(s). Whether or not the project uses the produced code does not impact the student stipend.");
        generalAnswers.add("The <a href=\"https://developers.google.com/open-source/gsoc/resources/manual#student_manual\">Student Manual</a>  has a section on \"Writing a Proposal\". \n" + "The best proposals are often from students who took the time to interact and discuss their ideas with the organization before submission. Be sure to include the following: detail on exactly what you're proposing, why you're proposing it, the reason you're qualified to do it, and your development methodology. It should also include details of your academic, industry, and/or open source development experience.");
        generalAnswers.add("You are expected to spend around 30+ hours a week working on your project during the 3 month coding period. If you already have an internship, another summer job, or plan to be gone on vacation for more than a week during that time, GSoC is not the right program for you this year.");
        generalAnswers.add("Absolutely. Google can provide documentation to your school so you can obtain course credit once we receive a positive final evaluation from your mentor.");
        generalAnswers.add("No. If you are interested in working for Google, please visit the\n  <a href=\"http://www.google.com/about/careers/\">Google jobs website.</a>");
        generalAnswers.add("No. GSoC is an activity that the student performs as an independent developer for which he/she is paid a stipend.");
        generalAnswers.add("No. While we hope that all the code that comes out of this program will find a happy home, we don’t require organizations to use the student's' code.");
        generalAnswers.add("Google Summer of Code occurs entirely online; there is no requirement to travel as part of the program.");
        generalAnswers.add("You can download\n <a href=\"https://developers.google.com/open-source/gsoc/resources/media\">flyers</a>  to post\n" +
                "around your campus. You can also tweet about the program, make YouTube videos,\n" +
                "or host a meetup or information session in your area.");
        generalAnswers.add("You are welcome to schedule a meetup at whatever time and place is convenient\n" +
                "for you! Please review the\n <a href=\"https://developers.google.com/open-source/gsoc/rules\">Program Rules</a> first and utilize our " +
                "\n <a href=\"https://developers.google.com/open-source/gsoc/resources/presentations\">presentation template</a> \n" +
                "and flyers. Send us the details of the meetup (date, location, time etc.) and we\n" +
                "will add it to our external calendar. <a href=\"http://opensource.googleblog.com/\">Google Open Source Blog</a> We'd love to see a blog post (including pictures!) for the\n  <a href=\"http://opensource.googleblog.com/\">Google Open Source Blog</a>"  );
        generalAnswers.add("No. We want to make sure that each project and student receives sufficient\n" +
                "attention, and we feel this could create a bad experience for those\n" +
                "involved. Please choose whether participation as a mentor or a student is more\n" +
                "appealing to you and plan to apply accordingly.");
        generalAnswers.add("Check out the <a href=\"https://developers.google.com/open-source/gsoc/resources/manual#student_manual\">Student Manual</a>  and\n" +
                "other pages on <a href=\"https://developers.google.com/open-source/gsoc/\">this site</a> . If after reading through all the documentation you still don't have an answer\n" +
                "please consider reaching out to the GSoC community via IRC or the discussion\n" +
                "list. Visit\n" +
                "the <a href=\"https://developers.google.com/open-source/gsoc/contact\">Contact Us</a> page to find out how ");
        return generalAnswers;

    }
}

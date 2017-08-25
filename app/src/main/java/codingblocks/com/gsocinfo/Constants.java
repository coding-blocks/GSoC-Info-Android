package codingblocks.com.gsocinfo;

import java.util.ArrayList;


/**
 * Created by vraun on 25-08-2017.
 */

public class Constants {

    public static ArrayList<String > generateTitle(){
        ArrayList<String> title = new ArrayList<>();
        title.add("Organisation Applications open");
        title.add("Organization Application Deadline");
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
        description.add("\n" +
                "Open source organizations that would like to participate as a mentor organization in this year’s program can apply.");
        description.add("\n" +
                "All organizations wishing to be a part of GSoC 2017 must complete their application by February 9, 2017 22:30 (India Standard Time)");
        description.add("Interested students can now begin discussing project ideas with accepted mentor organizations.");
        description.add("Students can register and submit their applications to mentor organizations. All proposals must be submitted by April 3, 2017 21:30 (India Standard Time).");
        description.add("Organizations review and select student proposals.");
        description.add(
                "Accepted students are paired with a mentor and start planning their projects and milestones.");
        description.add(
                "Students spend a month learning more about their organization’s community.");
        description.add("Students work on their Google Summer of Code projects.\n" +
                "while time.now() < deadline:\n" +
                "  code() and debug() and document()");
        description.add(
                "Mentors and students submit their evaluations of one another. These evaluations are a required step of the program.");
        description.add("\n" +
                "Students submit their code, project summaries, and final evaluations of their mentors.");
        description.add("Mentors review student code samples and determine if the students have successfully completed their Google Summer of Code 2017 project.");
        description.add("\n" +
                "Students are notified of the pass/fail status of their Google Summer of Code 2017 projects.");


        return description ;

    }

    static ArrayList<String> generateDate(){
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
        date.add("August 21 - 29, 2017\n");
        date.add("August 29, 2017 - September 5, 2017\n");
        date.add("September 6, 2017\n");


        return date ;

    }

}

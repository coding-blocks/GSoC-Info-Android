package codingblocks.com.gsocinfo.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import codingblocks.com.gsocinfo.model.MainPage;
import codingblocks.com.gsocinfo.model.Organizations;
import codingblocks.com.gsocinfo.model.Projects;
import codingblocks.com.gsocinfo.model.Student;

/**
 * Created by harshit on 08/09/17.
 */
@Database(entities = {Student.class, Organizations.Organization.class, Projects.Project.class, MainPage.Copy.class}, version = 2)
@TypeConverters(Converter.class)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProjectDao getProjectsDao();

    public abstract StudentDao getStudentsDao();

    public abstract OrganizationDao getOrganizationsDao();

    public abstract MainPageDao getMainPageDao();

}

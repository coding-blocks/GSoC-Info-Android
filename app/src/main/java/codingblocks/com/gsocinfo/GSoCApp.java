package codingblocks.com.gsocinfo;

import android.app.Application;
import android.arch.persistence.room.Room;

import codingblocks.com.gsocinfo.db.AppDatabase;
import codingblocks.com.gsocinfo.db.MainPageDao;
import codingblocks.com.gsocinfo.db.OrganizationDao;
import codingblocks.com.gsocinfo.db.ProjectDao;
import codingblocks.com.gsocinfo.db.StudentDao;

/**
 * Created by harshit on 08/09/17.
 */

public class GSoCApp extends Application {

    private static ProjectDao projectsDao;
    private static OrganizationDao organizationDao;
    private static StudentDao studentDao;
    private static MainPageDao mainPageDao;

    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "gsoc-database").build();
        projectsDao = appDatabase.getProjectsDao();
        organizationDao = appDatabase.getOrganizationsDao();
        studentDao = appDatabase.getStudentsDao();
        mainPageDao = appDatabase.getMainPageDao();
    }

    public static OrganizationDao getOrgDao() {
        return organizationDao;
    }

    public static ProjectDao getProjectDao() {
        return projectsDao;
    }

    public static StudentDao getStudentDao() {
        return studentDao;
    }

    public static MainPageDao getMainPageDao() {
        return mainPageDao;
    }

}

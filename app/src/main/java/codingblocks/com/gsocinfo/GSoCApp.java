package codingblocks.com.gsocinfo;

import android.app.Application;
import android.arch.persistence.room.Room;

import codingblocks.com.gsocinfo.db.AppDatabase;
import codingblocks.com.gsocinfo.db.dao.MainPageDao;
import codingblocks.com.gsocinfo.db.dao.OrganizationDao;
import codingblocks.com.gsocinfo.db.dao.ProjectDao;

/**
 * Created by harshit on 08/09/17.
 */

public class GSoCApp extends Application {

    private static ProjectDao projectsDao;
    private static OrganizationDao organizationDao;
    private static MainPageDao mainPageDao;

    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "gsoc-database").build();
        projectsDao = appDatabase.getProjectsDao();
        organizationDao = appDatabase.getOrganizationsDao();
        mainPageDao = appDatabase.getMainPageDao();
    }

    public static OrganizationDao getOrgDao() {
        return organizationDao;
    }

    public static ProjectDao getProjectDao() {
        return projectsDao;
    }

    public static MainPageDao getMainPageDao() {
        return mainPageDao;
    }

}

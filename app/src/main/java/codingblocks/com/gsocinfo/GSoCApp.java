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
    private static AppDatabase appDatabase;

    public static OrganizationDao getOrgDao() {
        if (organizationDao == null)
            organizationDao = appDatabase.getOrganizationsDao();
        return organizationDao;
    }

    public static ProjectDao getProjectDao() {
        if (projectsDao == null)
            projectsDao = appDatabase.getProjectsDao();
        return projectsDao;
    }

    public static MainPageDao getMainPageDao() {
        if (mainPageDao == null)
            mainPageDao = appDatabase.getMainPageDao();
        return mainPageDao;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "gsoc-database")
                .fallbackToDestructiveMigration()
                .build();
    }

}

package codingblocks.com.gsocinfo;

import android.app.Application;
import android.arch.persistence.room.Room;

import codingblocks.com.gsocinfo.db.AppDatabase;
import codingblocks.com.gsocinfo.db.MainPageDao;
import codingblocks.com.gsocinfo.db.OrganizationDao;
import codingblocks.com.gsocinfo.db.ProjectDao;

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
        new Thread(new Runnable() {
            @Override
            public void run() {
                Constants.setCopy(getMainPageDao().getData());
                Constants.setOrganizations(getOrgDao().getAllOrganizations());
                Constants.setProjects(getProjectDao().getAllProjects());
            }
        }).start();
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

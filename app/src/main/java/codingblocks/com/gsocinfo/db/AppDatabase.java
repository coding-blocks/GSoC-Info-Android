package codingblocks.com.gsocinfo.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import codingblocks.com.gsocinfo.data.model.MainPage;
import codingblocks.com.gsocinfo.data.model.Organization;
import codingblocks.com.gsocinfo.data.model.Project;
import codingblocks.com.gsocinfo.db.dao.MainPageDao;
import codingblocks.com.gsocinfo.db.dao.OrganizationDao;
import codingblocks.com.gsocinfo.db.dao.ProjectDao;

/**
 * Created by harshit on 08/09/17.
 */
@Database(entities = {Organization.class, Project.class, MainPage.Copy.class}, version = 2)
@TypeConverters(Converter.class)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProjectDao getProjectsDao();

    public abstract OrganizationDao getOrganizationsDao();

    public abstract MainPageDao getMainPageDao();

}

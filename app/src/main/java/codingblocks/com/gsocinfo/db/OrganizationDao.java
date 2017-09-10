package codingblocks.com.gsocinfo.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import codingblocks.com.gsocinfo.model.Organizations;

/**
 * Created by harshit on 08/09/17.
 */
@Dao
public interface OrganizationDao {

    @Query("SELECT * FROM organizations ORDER BY name")
    List<Organizations.Organization> getAllOrganizations();

//    @Query("SELECT * FROM projects")
//    Projects.Project getProjectByStudentId(long id);
    @Insert
    void insertAllOrganization(List<Organizations.Organization> organizations);

    @Delete
    void deleteAllOrganizations(List<Organizations.Organization> organizations);

    @Query("DELETE FROM organizations")
    void nukeOrgs();
}

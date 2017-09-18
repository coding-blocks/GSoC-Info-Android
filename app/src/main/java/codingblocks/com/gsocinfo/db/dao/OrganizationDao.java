package codingblocks.com.gsocinfo.db.dao;

import android.arch.paging.LivePagedListProvider;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import codingblocks.com.gsocinfo.data.model.Organizations;

/**
 * Created by harshit on 08/09/17.
 */
@Dao
public interface OrganizationDao {

    @Query("SELECT * FROM organizations ORDER BY name")
    LivePagedListProvider<Integer, Organizations.Organization> getAllOrganizations();

    @Insert
    void insertAllOrganization(List<Organizations.Organization> organizations);

    @Delete
    void deleteAllOrganizations(List<Organizations.Organization> organizations);

    @Query("DELETE FROM organizations")
    void nukeOrgs();
}

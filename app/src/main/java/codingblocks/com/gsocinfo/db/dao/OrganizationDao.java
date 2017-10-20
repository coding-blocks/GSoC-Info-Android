package codingblocks.com.gsocinfo.db.dao;

import android.arch.paging.LivePagedListProvider;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import codingblocks.com.gsocinfo.data.model.Organization;

/**
 * Created by harshit on 08/09/17.
 */
@Dao
public interface OrganizationDao {

    @Query("SELECT * FROM organizations ORDER BY name")
    LivePagedListProvider<?, Organization> getAllOrganizations();

    @Insert
    void insertAllOrganization(List<Organization> organizations);

    @Delete
    void deleteAllOrganizations(List<Organization> organizations);

    @Query("SELECT * FROM organizations WHERE name like '%' || :name || '%' OR " +
            "topicTags like '%' || :name || '%' OR technologyTags like '%' || :name || '%' OR" +
            " proposalTags like '%' || :name || '%' ORDER BY name")
    LivePagedListProvider<?, Organization> getOrgsByName(String name);

    @Query("DELETE FROM organizations")
    void nukeOrgs();
}

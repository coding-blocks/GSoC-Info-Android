package codingblocks.com.gsocinfo.db.dao;

import android.arch.paging.LivePagedListProvider;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import codingblocks.com.gsocinfo.data.model.Project;

/**
 * Created by harshit on 08/09/17.
 */
@Dao
public interface ProjectDao {

    @Query("SELECT * FROM projects ORDER BY title")
    LivePagedListProvider<?, Project> getAllProjects();

    @Query("SELECT * FROM projects WHERE orgID = :id")
    LivePagedListProvider<?, Project> getProjectByOrgId(String id);

    @Insert
    void insertAllProjects(List<Project> projects);

    @Insert
    void insertSingleProject(Project... project);

    @Delete
    void deleteAllProjects(List<Project> projects);

    @Query("DELETE FROM projects")
    void nukeProjects();
}

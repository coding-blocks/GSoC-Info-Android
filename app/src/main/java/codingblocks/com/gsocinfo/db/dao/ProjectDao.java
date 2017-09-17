package codingblocks.com.gsocinfo.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import codingblocks.com.gsocinfo.data.model.Projects;

/**
 * Created by harshit on 08/09/17.
 */
@Dao
public interface ProjectDao {

    @Query("SELECT * FROM projects ORDER BY title")
    LiveData<List<Projects.Project>> getAllProjects();

    @Query("SELECT * FROM projects WHERE orgID = :id")
    LiveData<List<Projects.Project>> getProjectByOrgId(String id);

    @Insert
    void insertAllProjects(List<Projects.Project> projects);

    @Insert
    void insertSingleProject(Projects.Project... project);

    @Delete
    void deleteAllProjects(List<Projects.Project> projects);

    @Query("DELETE FROM projects")
    void nukeProjects();
}

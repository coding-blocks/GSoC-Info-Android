package codingblocks.com.gsocinfo.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import codingblocks.com.gsocinfo.data.model.MainPage;

/**
 * Created by harshit on 08/09/17.
 */
@Dao
public interface MainPageDao {

    @Query("SELECT * FROM mainpage")
    MainPage.Copy getData();

    @Insert
    void insertData(MainPage.Copy copy);

    @Query("DELETE FROM mainpage")
    void nukeProjects();
}

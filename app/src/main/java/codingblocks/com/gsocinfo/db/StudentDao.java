package codingblocks.com.gsocinfo.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import codingblocks.com.gsocinfo.model.Student;

/**
 * Created by harshit on 08/09/17.
 */
@Dao
public interface StudentDao {

    @Query("SELECT * FROM students ORDER BY displayName")
    List<Student> getAllStudents();

//    @Query("SELECT * FROM projects")
//    Projects.Project getProjectByStudentId(long id);

    @Insert
    void insertAllStudents(List<Student> students);

    @Insert
    void insertSingleStudent(Student student);

    @Delete
    void deleteAllStudents(List<Student> students);

    @Query("DELETE FROM students")
    void nukeStudents();

}

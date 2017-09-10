package codingblocks.com.gsocinfo.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import codingblocks.com.gsocinfo.GSoCApp;
import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.model.MainPage;
import codingblocks.com.gsocinfo.model.Organizations;
import codingblocks.com.gsocinfo.model.Projects;

import static codingblocks.com.gsocinfo.GSoCApp.getProjectDao;
import static codingblocks.com.gsocinfo.GSoCApp.getStudentDao;

/**
 * Created by harshit on 02/09/17.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), AboutActivity.class));
                finish();
            }
        });

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final Gson gson = new Gson();
        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage("Setting things up, please wait")
                .setCancelable(false)
                .create();
        alertDialog.show();
        Runnable runnable = new Runnable() {

            Organizations organizations;

            @Override
            public void run() {
                if (!sharedPreferences.getBoolean(getString(R.string.org_key), false)) {
                    try {
                        GSoCApp.getOrgDao().nukeOrgs();
                        String json;
                        InputStream inputStream = getAssets().open("org.json");
                        int size = inputStream.available();
                        byte[] buffer = new byte[size];
                        inputStream.read(buffer);
                        inputStream.close();
                        json = new String(buffer, "UTF-8");
//                        Constants.setOrganizations(json);
                        organizations = gson.fromJson(json, Organizations.class);
                        GSoCApp.getOrgDao().insertAllOrganization(organizations.getResults());
                        sharedPreferences.edit().putBoolean(getString(R.string.org_key), true).apply();
                    } catch (IOException e) {
                        sharedPreferences.edit().putBoolean(getString(R.string.org_key), false).apply();
                        e.printStackTrace();
                    }
                }
                if (!sharedPreferences.getBoolean(getString(R.string.main_page), false)) {
                    try {
                        String json2;
                        InputStream inputStream2 = null;
                        inputStream2 = getAssets().open("main_page.json");
                        int size2 = inputStream2.available();
                        byte[] buffer2 = new byte[size2];
                        inputStream2.read(buffer2);
                        inputStream2.close();
                        json2 = new String(buffer2, "UTF-8");
//                        Constants.setMainPage(json2);
                        Gson gson = new Gson();
                        MainPage mainPage = gson.fromJson(json2, MainPage.class);
                        GSoCApp.getMainPageDao().insertData(mainPage.getCopy());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (!sharedPreferences.getBoolean(getString(R.string.project_key), false) && !sharedPreferences.getBoolean(getString(R.string.student_key), false)) {
                    try {

                        sharedPreferences.edit().putBoolean(getString(R.string.student_key), true).apply();
                        GSoCApp.getProjectDao().nukeProjects();
                        final Projects projects;
                        String json1;
                        InputStream inputStream1 = getAssets().open("projects.json");
                        int size1 = inputStream1.available();
                        byte[] buffer1 = new byte[size1];
                        inputStream1.read(buffer1);
                        inputStream1.close();
                        json1 = new String(buffer1, "UTF-8");
                        projects = gson.fromJson(json1, Projects.class);

                        getStudentDao().nukeStudents();

                        for (Projects.Project project : projects.getResults()) {
                            getStudentDao().insertSingleStudent(project.getStudent());
                        }

                        for (Projects.Project project : projects.getResults()) {
                            project.setOrg_id(project.getOrganization().getOrgID());
                            project.setStudent_id(project.getStudent().getStudentID());
                        }

                        getProjectDao().insertAllProjects(projects.getResults());
                        sharedPreferences.edit().putBoolean(getString(R.string.project_key), true).apply();

                    } catch (IOException | NullPointerException e) {
                        e.printStackTrace();
                        sharedPreferences.edit().putBoolean(getString(R.string.student_key), false).apply();
                        sharedPreferences.edit().putBoolean(getString(R.string.project_key), false).apply();
                    }
                }
                LoginActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        alertDialog.hide();
                    }
                });
            }
        };
        new Thread(runnable).start();
    }


}

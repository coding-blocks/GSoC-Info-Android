package codingblocks.com.gsocinfo.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import codingblocks.com.gsocinfo.GSoCApp;
import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.data.model.MainPage;
import codingblocks.com.gsocinfo.data.model.Organizations;
import codingblocks.com.gsocinfo.data.model.Projects;

import static codingblocks.com.gsocinfo.GSoCApp.getProjectDao;

/**
 * Created by harshit on 02/09/17.
 */

public class LoginActivity extends AppCompatActivity {

    private AlertDialog alertDialog;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Button button = findViewById(R.id.loginButton);

//        if (sharedPreferences.getBoolean("LOGGED_IN",false)){
//            startActivity(new Intent(getBaseContext(), HomeActivity.class));
//            finish();
//        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), HomeActivity.class));
                sharedPreferences.edit().putBoolean("LOGGED_IN", true).apply();
            }
        });

        final Gson gson = new Gson();
        final View view = LayoutInflater.from(this).inflate(R.layout.dialog_progress, null, false);
        ((TextView) view.findViewById(R.id.textViewDialog)).setText(R.string.first_launch_dialog);

        Runnable runnable = new Runnable() {
            Organizations organizations;

            @Override
            public void run() {
                if (!sharedPreferences.getBoolean(getString(R.string.main_page), false)) {
                    LoginActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            alertDialog = new AlertDialog.Builder(LoginActivity.this)
                                    .setMessage("Setting things up, please wait")
                                    .setView(view)
                                    .setCancelable(false)
                                    .setView(view)
                                    .create();
                            alertDialog.show();
                        }
                    });
                    try {
                        String json2;
                        InputStream inputStream2 = null;
                        inputStream2 = getAssets().open("main_page.json");
                        int size2 = inputStream2.available();
                        byte[] buffer2 = new byte[size2];
                        inputStream2.read(buffer2);
                        inputStream2.close();
                        json2 = new String(buffer2, "UTF-8");
                        Gson gson = new Gson();
                        MainPage mainPage = gson.fromJson(json2, MainPage.class);
                        GSoCApp.getMainPageDao().insertData(mainPage.getCopy());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
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
                        organizations = gson.fromJson(json, Organizations.class);
                        GSoCApp.getOrgDao().insertAllOrganization(organizations.getResults());
                        sharedPreferences.edit().putBoolean(getString(R.string.org_key), true).apply();
                    } catch (IOException e) {
                        sharedPreferences.edit().putBoolean(getString(R.string.org_key), false).apply();
                        e.printStackTrace();
                    }
                }
                if (!sharedPreferences.getBoolean(getString(R.string.project_key), false) && !sharedPreferences.getBoolean(getString(R.string.student_key), false)) {
                    try {
                        getProjectDao().nukeProjects();
                        final Projects projects;
                        String json1;
                        InputStream inputStream1 = getAssets().open("projects.json");
                        int size1 = inputStream1.available();
                        byte[] buffer1 = new byte[size1];
                        inputStream1.read(buffer1);
                        inputStream1.close();
                        json1 = new String(buffer1, "UTF-8");
                        projects = gson.fromJson(json1, Projects.class);
                        getProjectDao().insertAllProjects(projects.getResults());
                        sharedPreferences.edit().putBoolean(getString(R.string.project_key), true).apply();

                    } catch (IOException | NullPointerException e) {
                        e.printStackTrace();
                        sharedPreferences.edit().putBoolean(getString(R.string.project_key), false).apply();
                    }
                }
                LoginActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (alertDialog.isShowing())
                            alertDialog.hide();
                    }
                });
            }
        };
        new Thread(runnable).start();
    }

}

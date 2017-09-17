package codingblocks.com.gsocinfo.data.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import codingblocks.com.gsocinfo.GSoCApp;
import codingblocks.com.gsocinfo.data.model.Projects;

/**
 * Created by harshit on 17/09/17.
 */

public class ProjectViewModel extends AndroidViewModel {

    private LiveData<List<Projects.Project>> projects;

    public ProjectViewModel(Application application) {
        super(application);
        projects = GSoCApp.getProjectDao().getAllProjects();
    }

    public LiveData<List<Projects.Project>> getProjects() {
        return projects;
    }

    public void setProjects(LiveData<List<Projects.Project>> projects) {
        this.projects = projects;
    }

    public void setProjectByOrgID(String orgID){
        GSoCApp.getProjectDao().getProjectByOrgId(orgID);
    }


}

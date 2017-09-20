package codingblocks.com.gsocinfo.data.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;

import codingblocks.com.gsocinfo.GSoCApp;
import codingblocks.com.gsocinfo.data.model.Project;

/**
 * Created by harshit on 17/09/17.
 */

public class ProjectViewModel extends AndroidViewModel {

    private LiveData<PagedList<Project>> projects;

    public ProjectViewModel(Application application) {
        super(application);
        projects = GSoCApp.getProjectDao().getAllProjects().create(null, 50);
    }

    public LiveData<PagedList<Project>> getProjects() {
        return projects;
    }

    public void setProjects(LiveData<PagedList<Project>> projects) {
        this.projects = projects;
    }

    public LiveData<PagedList<Project>> getProjectsByOrgID(String id) {
        return GSoCApp.getProjectDao().getProjectByOrgId(id).create(null, 50);
    }


}

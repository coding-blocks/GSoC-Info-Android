package codingblocks.com.gsocinfo.data.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;

import codingblocks.com.gsocinfo.GSoCApp;
import codingblocks.com.gsocinfo.data.model.Projects;

/**
 * Created by harshit on 17/09/17.
 */

public class ProjectViewModel extends AndroidViewModel {

    private LiveData<PagedList<Projects.Project>> projects;

    public ProjectViewModel(Application application) {
        super(application);
        projects = GSoCApp.getProjectDao().getAllProjects().create(0,
                new PagedList.Config.Builder()
                        .setPageSize(40)
                        .setEnablePlaceholders(false)
                        .setPrefetchDistance(10)
                        .build());
    }

    public LiveData<PagedList<Projects.Project>> getProjectsByOrgID(String id) {
        return GSoCApp.getProjectDao().getProjectByOrgId(id).create(0,
                new PagedList.Config.Builder()
                        .setPageSize(40)
                        .setEnablePlaceholders(true)
                        .setPrefetchDistance(10)
                        .build());
    }

    public LiveData<PagedList<Projects.Project>> getProjects() {
        return projects;
    }

    public void setProjects(LiveData<PagedList<Projects.Project>> projects) {
        this.projects = projects;
    }

    public void setProjectByOrgID(String orgID) {
        GSoCApp.getProjectDao().getProjectByOrgId(orgID);
    }


}

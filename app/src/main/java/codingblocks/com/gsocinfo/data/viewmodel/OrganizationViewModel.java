package codingblocks.com.gsocinfo.data.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;

import codingblocks.com.gsocinfo.GSoCApp;
import codingblocks.com.gsocinfo.data.model.Organization;

/**
 * Created by harshit on 17/09/17.
 */

public class OrganizationViewModel extends AndroidViewModel {

    public LiveData<PagedList<Organization>> organizations;

    public OrganizationViewModel(Application application) {
        super(application);
        organizations = GSoCApp.getOrgDao().getAllOrganizations()
                .create(null, new PagedList.Config.Builder()
                        .setPageSize(50)
                        .setPrefetchDistance(10)
                        .build());
    }

    public LiveData<PagedList<Organization>> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(LiveData<PagedList<Organization>> organizations) {
        this.organizations = organizations;
    }

    public LiveData<PagedList<Organization>> getOrgsByName(String name) {
        return GSoCApp.getOrgDao().getOrgsByName(name)
                .create(null, new PagedList.Config.Builder()
                        .setPageSize(50)
                        .setPrefetchDistance(10)
                        .build());
    }
}

package codingblocks.com.gsocinfo.data.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;

import codingblocks.com.gsocinfo.GSoCApp;
import codingblocks.com.gsocinfo.data.model.Organizations;

/**
 * Created by harshit on 17/09/17.
 */

public class OrganizationViewModel extends AndroidViewModel {

    private LiveData<PagedList<Organizations.Organization>> organizations;

    public OrganizationViewModel(Application application) {
        super(application);
        organizations = GSoCApp.getOrgDao().getAllOrganizations()
                .create(null, new PagedList.Config.Builder()
                        .setPageSize(30)
                        .setPrefetchDistance(30)
                        .build()
                );

    }

    public LiveData<PagedList<Organizations.Organization>> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(LiveData<PagedList<Organizations.Organization>> organizations) {
        this.organizations = organizations;
    }
}

package codingblocks.com.gsocinfo.data.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import codingblocks.com.gsocinfo.GSoCApp;
import codingblocks.com.gsocinfo.data.model.Organizations;

/**
 * Created by harshit on 17/09/17.
 */

public class OrganizationViewModel extends AndroidViewModel {

    private LiveData<List<Organizations.Organization>> organizations;

    public OrganizationViewModel(Application application) {
        super(application);
        organizations = GSoCApp.getOrgDao().getAllOrganizations();

    }

    public LiveData<List<Organizations.Organization>> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(LiveData<List<Organizations.Organization>> organizations) {
        this.organizations = organizations;
    }

}

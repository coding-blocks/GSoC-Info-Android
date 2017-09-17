package codingblocks.com.gsocinfo.data.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import codingblocks.com.gsocinfo.GSoCApp;
import codingblocks.com.gsocinfo.data.model.MainPage;

/**
 * Created by harshit on 17/09/17.
 */

public class MainPageViewModel extends AndroidViewModel {

    private LiveData<MainPage.Copy> mainPageCopy;

    public MainPageViewModel(Application application) {
        super(application);
        mainPageCopy = GSoCApp.getMainPageDao().getData();
    }

    public LiveData<MainPage.Copy> getMainPageCopy() {
        return mainPageCopy;
    }

    public void setMainPageCopy(LiveData<MainPage.Copy> mainPageCopy) {
        this.mainPageCopy = mainPageCopy;
    }

}

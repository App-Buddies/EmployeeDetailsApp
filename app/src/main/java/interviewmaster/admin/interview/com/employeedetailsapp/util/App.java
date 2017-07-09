package interviewmaster.admin.interview.com.employeedetailsapp.util;

import android.app.Application;

import interviewmaster.admin.interview.com.employeedetailsapp.components.AppComponent;
import interviewmaster.admin.interview.com.employeedetailsapp.components.DaggerAppComponent;
import interviewmaster.admin.interview.com.employeedetailsapp.components.Detailscreencomponent;
import interviewmaster.admin.interview.com.employeedetailsapp.components.MainScreenComponent;
import interviewmaster.admin.interview.com.employeedetailsapp.modules.AppModule;
import interviewmaster.admin.interview.com.employeedetailsapp.modules.NetModule;

public class App extends Application {

    AppComponent appComponent;
    MainScreenComponent mainScreenComponent;
    Detailscreencomponent detailscreencomponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://private-2a004-androidtest3.apiary-mock.com"))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public Detailscreencomponent getDetailscreencomponent() {
        return detailscreencomponent;
    }

    public MainScreenComponent getMainScreenComponent() {
        return mainScreenComponent;
    }
}

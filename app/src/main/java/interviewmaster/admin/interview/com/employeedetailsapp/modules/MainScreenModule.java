package interviewmaster.admin.interview.com.employeedetailsapp.modules;

import android.view.View;

import dagger.Module;
import dagger.Provides;
import interviewmaster.admin.interview.com.employeedetailsapp.util.CustomScope;
import interviewmaster.admin.interview.com.employeedetailsapp.view.Detailsview;
import interviewmaster.admin.interview.com.employeedetailsapp.view.MainView;

@Module
public class MainScreenModule {

    private final MainView mview;


    public MainScreenModule(MainView view) {

        this.mview = view;
    }

    @Provides
    @CustomScope
    public MainView provideview() {
        return mview;
    }




}

package interviewmaster.admin.interview.com.employeedetailsapp.modules;

import android.app.Application;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;

    }

    @Singleton
    @Provides
     Application getmApplication() {
        return mApplication;
    }
}

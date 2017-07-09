package interviewmaster.admin.interview.com.employeedetailsapp.components;

import javax.inject.Singleton;

import dagger.Component;
import interviewmaster.admin.interview.com.employeedetailsapp.modules.AppModule;
import interviewmaster.admin.interview.com.employeedetailsapp.modules.DetailscreenModule;
import interviewmaster.admin.interview.com.employeedetailsapp.modules.NetModule;
import retrofit2.Retrofit;


@Singleton
@Component(modules = {NetModule.class, AppModule.class, DetailscreenModule.class})
public interface AppComponent {
    Retrofit retrofit();
}

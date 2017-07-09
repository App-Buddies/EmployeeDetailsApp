package interviewmaster.admin.interview.com.employeedetailsapp.components;

import dagger.Component;
import dagger.Subcomponent;
import interviewmaster.admin.interview.com.employeedetailsapp.activities.DetailsActivity;
import interviewmaster.admin.interview.com.employeedetailsapp.activities.MainActivity;
import interviewmaster.admin.interview.com.employeedetailsapp.modules.MainScreenModule;
import interviewmaster.admin.interview.com.employeedetailsapp.util.CustomScope;


@CustomScope
@Component(dependencies = {AppComponent.class},modules = {MainScreenModule.class})
public interface MainScreenComponent {
    void inject(MainActivity activity);
}

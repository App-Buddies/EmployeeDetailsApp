package interviewmaster.admin.interview.com.employeedetailsapp.components;

import dagger.Component;
import dagger.Subcomponent;
import interviewmaster.admin.interview.com.employeedetailsapp.activities.DetailsActivity;
import interviewmaster.admin.interview.com.employeedetailsapp.modules.DetailscreenModule;
import interviewmaster.admin.interview.com.employeedetailsapp.modules.MainScreenModule;
import interviewmaster.admin.interview.com.employeedetailsapp.util.CustomScope;
import interviewmaster.admin.interview.com.employeedetailsapp.util.DetailScope;

/**
 * Created by ADMIN on 06-07-2017.
 */
@DetailScope
@Subcomponent( modules = {DetailscreenModule.class})
public interface Detailscreencomponent {
    void inject(DetailsActivity detailsActivity);

}

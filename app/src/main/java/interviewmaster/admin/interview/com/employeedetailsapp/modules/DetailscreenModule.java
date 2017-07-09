package interviewmaster.admin.interview.com.employeedetailsapp.modules;

import android.support.v7.widget.RecyclerView;

import dagger.Module;
import dagger.Provides;
import interviewmaster.admin.interview.com.employeedetailsapp.util.CustomScope;
import interviewmaster.admin.interview.com.employeedetailsapp.view.Detailsview;
import retrofit2.Retrofit;

/**
 * Created by ADMIN on 06-07-2017.
 */
@Module
public class DetailscreenModule {

    private final Detailsview detailsview;

    public DetailscreenModule(Detailsview detailsview) {
        this.detailsview = detailsview;


    }


    @Provides
    @CustomScope
    public Detailsview detailsview() {
        return detailsview;
    }
}

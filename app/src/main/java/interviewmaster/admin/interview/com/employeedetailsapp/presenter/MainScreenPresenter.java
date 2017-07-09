package interviewmaster.admin.interview.com.employeedetailsapp.presenter;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import dagger.Provides;
import interviewmaster.admin.interview.com.employeedetailsapp.activities.MainActivity;
import interviewmaster.admin.interview.com.employeedetailsapp.api.Apiservice;
import interviewmaster.admin.interview.com.employeedetailsapp.database.DBHelper;
import interviewmaster.admin.interview.com.employeedetailsapp.model.Example;
import interviewmaster.admin.interview.com.employeedetailsapp.view.MainView;
import retrofit2.Retrofit;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ADMIN on 05-07-2017.
 */

public class MainScreenPresenter implements Presenter {

    Retrofit mRetrofit;
    MainView mview;
   /* @Inject
    protected DBHelper dbHelper;*/



    @Inject
    public MainScreenPresenter(Retrofit retrofit, MainView view) {
        this.mRetrofit = retrofit;
        this.mview = view;
    }


    @Override
    public void loadEmployeeDetails() {
        mRetrofit.create(Apiservice.class).getEmloyeeData().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Example>>() {
                    @Override
                    public void onCompleted() {
                        mview.showComplete();

                    }

                    @Override
                    public void onError(Throwable e) {
                        mview.showError("Error");

                    }

                    @Override
                    public void onNext(List<Example> examples) {
                        //dbHelper.addemployee(examples);
                       // mview.showEmployeeDetails(dbHelper.getemployee());
                        mview.showEmployeeDetails(examples);
                    }
                });

    }
}

package interviewmaster.admin.interview.com.employeedetailsapp.presenter;

import interviewmaster.admin.interview.com.employeedetailsapp.api.Apiservice;
import interviewmaster.admin.interview.com.employeedetailsapp.model.Example;
import interviewmaster.admin.interview.com.employeedetailsapp.view.Detailsview;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ADMIN on 06-07-2017.
 */

public class DetailScreensPresenter implements DetailPresenter {

    Retrofit retrofit;
    Detailsview detailsview;


    DetailScreensPresenter(Retrofit retrofit, Detailsview detailsview) {
        this.retrofit = retrofit;
        this.detailsview = detailsview;
    }

    @Override
    public void detailsemployee(String name) {
        retrofit.create(Apiservice.class).getdata(name).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Example>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Example example) {
             detailsview.showEmployee(example);
            }
        });

    }




}

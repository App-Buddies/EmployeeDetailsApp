package interviewmaster.admin.interview.com.employeedetailsapp.api;

import java.util.List;

import interviewmaster.admin.interview.com.employeedetailsapp.model.Employee;
import interviewmaster.admin.interview.com.employeedetailsapp.model.Example;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ADMIN on 05-07-2017.
 */

public interface Apiservice {

    @GET("/employeesList")
    Observable<List<Example>> getEmloyeeData();

    @GET("/employeesList")
    Observable<Example> getdata(@Query("firstName")String name);
}

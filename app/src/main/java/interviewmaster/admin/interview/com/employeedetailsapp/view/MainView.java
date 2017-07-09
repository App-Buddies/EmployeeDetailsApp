package interviewmaster.admin.interview.com.employeedetailsapp.view;

import java.util.List;

import interviewmaster.admin.interview.com.employeedetailsapp.model.Example;

/**
 * Created by ADMIN on 05-07-2017.
 */

public interface MainView {
    void showEmployeeDetails(List<Example> examples);

    void showError(String message);

    void showComplete();

    void addtodb(List<Example> e);

}

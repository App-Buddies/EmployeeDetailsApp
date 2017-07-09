package interviewmaster.admin.interview.com.employeedetailsapp.view;

import java.util.List;

import interviewmaster.admin.interview.com.employeedetailsapp.model.Example;

/**
 * Created by ADMIN on 06-07-2017.
 */

public interface Detailsview {
    void showEmployee(Example examples);

    void showError(String message);
}

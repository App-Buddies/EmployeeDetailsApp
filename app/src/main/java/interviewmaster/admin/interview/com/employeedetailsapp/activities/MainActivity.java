package interviewmaster.admin.interview.com.employeedetailsapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;


import butterknife.BindView;
import butterknife.ButterKnife;
import interviewmaster.admin.interview.com.employeedetailsapp.R;
import interviewmaster.admin.interview.com.employeedetailsapp.adapters.RecycleAdapter;

import interviewmaster.admin.interview.com.employeedetailsapp.components.DaggerMainScreenComponent;
import interviewmaster.admin.interview.com.employeedetailsapp.model.Example;
import interviewmaster.admin.interview.com.employeedetailsapp.modules.MainScreenModule;
import interviewmaster.admin.interview.com.employeedetailsapp.presenter.MainScreenPresenter;
import interviewmaster.admin.interview.com.employeedetailsapp.util.App;
import interviewmaster.admin.interview.com.employeedetailsapp.util.Networkutils;
import interviewmaster.admin.interview.com.employeedetailsapp.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView, RecycleAdapter.Clicklistner {


    @Inject
    MainScreenPresenter mainScreenPresenter;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

   // DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainScreenComponent.builder().
                appComponent(((App) getApplicationContext()).
                        getAppComponent()).
                mainScreenModule(new MainScreenModule(this))
                .build().
                inject(this);
        ButterKnife.bind(this);
        if (Networkutils.getnetwork(this)) {
            mainScreenPresenter.loadEmployeeDetails();
        } else {

           // showEmployeeDetails(dbHelper.getemployee());
        }

    }

    private void init(RecycleAdapter recycleAdapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycleAdapter.setClicklistner(this);
        recyclerView.setAdapter(recycleAdapter);
    }

    @Override
    public void showEmployeeDetails(List<Example> examples) {
        RecycleAdapter recycleAdapter = new RecycleAdapter(this, examples);
        init(recycleAdapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(getApplicationContext(), "complete", Toast.LENGTH_LONG).show();

    }

    @Override
    public void addtodb(List<Example> e) {

    }

    @Override
    public void clicked(String name) {
        startActivity(new Intent(this,DetailsActivity.class).putExtra("name",name));
    }
}

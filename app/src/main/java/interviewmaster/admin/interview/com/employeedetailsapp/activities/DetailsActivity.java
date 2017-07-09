package interviewmaster.admin.interview.com.employeedetailsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import interviewmaster.admin.interview.com.employeedetailsapp.R;

import interviewmaster.admin.interview.com.employeedetailsapp.model.Example;
import interviewmaster.admin.interview.com.employeedetailsapp.modules.DetailscreenModule;
import interviewmaster.admin.interview.com.employeedetailsapp.modules.MainScreenModule;
import interviewmaster.admin.interview.com.employeedetailsapp.presenter.DetailScreensPresenter;
import interviewmaster.admin.interview.com.employeedetailsapp.util.App;
import interviewmaster.admin.interview.com.employeedetailsapp.view.Detailsview;


public class DetailsActivity extends AppCompatActivity implements Detailsview {

    @BindView(R.id.textname) TextView textname;
    @BindView(R.id.textdesignation)TextView textdesig;
    @BindView(R.id.textemail)TextView textemail;
    @BindView(R.id.textlanguage)TextView textlang;
    @BindView(R.id.textmobile)TextView textmob;
    @BindView(R.id.textnationality)TextView textnationl;
    @BindView(R.id.texttechnical)TextView texttecnical;
    @BindView(R.id.designation)TextView desig;
    @BindView(R.id.email)TextView email;
    @BindView(R.id.language)TextView lag;
    @BindView(R.id.mobile)TextView mobile;
    @BindView(R.id.nationality)TextView nationality;
    @BindView(R.id.skils)TextView skils;

    @BindView(R.id.technical)TextView tecnical;
    @BindView(R.id.textExatracurri)TextView textcurri;
    @BindView(R.id.extracurricular)TextView extar;
    @BindView(R.id.profile_image)ImageView profileimage;
    @Inject
    DetailScreensPresenter detailScreensPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewemployee);
      //  (((App)getApplicationContext()).getAppComponent())
     //   ButterKnife.bind(this);
/*
        DaggerMainScreenComponent.builder().
                appComponent(((App) getApplicationContext()).
                        getAppComponent()).
                mainScreenModule(new MainScreenModule(this))
                .build().
                inject(this);
        ButterKnife.bind(this)*/

/*
DaggerdDetailscreencomponent.builder().appcomponent(((App)getApplicationContext()).getAppComponent()).detailscreenModule(new DetailscreenModule(this)).build().inject(this);
*/
        ButterKnife.bind(this);    }

    @Override
    public void showEmployee(Example examples) {

    }

    @Override
    public void showError(String message) {

    }
}

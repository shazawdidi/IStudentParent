package com.tztechs.student.ui.user.ui.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.hbb20.CountryCodePicker;
import com.tztechs.student.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends AppCompatActivity {

    LoggedInUserView model;
    @BindView(R.id.ccp)
    CountryCodePicker ccp;
    @BindView(R.id.phone_number)
    EditText phoneNumber;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.loading)
    ProgressBar loading;
    @BindView(R.id.container)
    ConstraintLayout container;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        phoneNumber.setText("900940206");


    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }


}

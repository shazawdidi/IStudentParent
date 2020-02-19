package com.tztechs.student.ui.user.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.hbb20.CountryCodePicker;
import com.tztechs.student.R;
import com.tztechs.student.base.BaseComponent;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.ccp)
    ImageView ccp;
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
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,BaseComponent.class);
                startActivity(intent);
//                finish();
            }
        });

    }






}

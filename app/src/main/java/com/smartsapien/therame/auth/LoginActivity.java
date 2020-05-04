package com.smartsapien.therame.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.smartsapien.therame.MainActivity;
import com.smartsapien.therame.R;
import com.smartsapien.therame.SplashActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.donthave)TextView dontHave;
    @BindView(R.id.loginbtn)MaterialButton loginBt;
    @BindView(R.id.forgotPwd) TextView passReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.loginbtn) void loginAcc() {
        //login
        startActivity(new Intent(this, SplashActivity.class));
    }
    @OnClick(R.id.donthave) void createAcc() {
        //create a new account
        startActivity(new Intent(this, SignUpActivity.class));
    }
    @OnClick(R.id.forgotPwd) void reset() {
       //reset password
        startActivity(new Intent(this, ResetActivity.class));
    }
}

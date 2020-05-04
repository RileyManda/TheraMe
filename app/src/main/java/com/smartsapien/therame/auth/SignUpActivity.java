package com.smartsapien.therame.auth;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.smartsapien.therame.MainActivity;
import com.smartsapien.therame.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class SignUpActivity extends AppCompatActivity {
    @BindView(R.id.username)EditText userName;
    @BindView(R.id.email)EditText userEmail;
    @BindView(R.id.signUp)MaterialButton signUpBtn;
    @BindView(R.id.memberReturn)TextView backtoSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        //add unbinder for unbinding views
    }

    @OnClick(R.id.signUp) void loginAcc() {
        //login
        Timber.i("Signed Up Success");
        startActivity(new Intent(this, LoginActivity.class));
    }

   @OnClick(R.id.memberReturn) void already(){
       Timber.i("Already a Member");
       startActivity(new Intent(this, LoginActivity.class));
   }
}

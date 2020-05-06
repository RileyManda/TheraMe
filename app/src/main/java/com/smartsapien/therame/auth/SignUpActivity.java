package com.smartsapien.therame.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.smartsapien.therame.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class SignUpActivity extends AppCompatActivity {
    @BindView(R.id.signUp)MaterialButton signUpBtn;
    @BindView(R.id.memberReturn)MaterialButton backtoSignIn;

    //username fields
    @BindView(R.id.username_signup_input)TextInputLayout usernameInput;
    @BindView(R.id.username)TextInputEditText userNameEdit;
//email fields
    @BindView(R.id.email_signup_input)TextInputLayout emailInput;
    @BindView(R.id.email)TextInputEditText userEmailEdit;
    //password fields
    @BindView(R.id.password_text_input)TextInputLayout passwordInput;
    @BindView(R.id.password)TextInputEditText passEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        //add unbinder for unbinding views
    }

    //TODO:Going to change this to a switch statement
    @OnClick(R.id.signUp) void signUp() {
        //username field validation
       validateForm();
    }



   @OnClick(R.id.memberReturn) void already(){
       Timber.i("Already a Member");
       startActivity(new Intent(this, LoginActivity.class));
   }



    private boolean isUsernameValid(@Nullable Editable userText) {
        return userText != null && userText.length() >= 8;
    }
    private boolean isPasswordValid(@Nullable Editable passTxt) {
        return passTxt != null && passTxt.length() >= 8;
    }

    private boolean isEmailValid(@Nullable Editable emailTxt) {
        return emailTxt != null && emailTxt.length() >= 8;
    }


    private boolean validateForm() {
        boolean valid = true;

        String email = userEmailEdit.getText().toString();
        if (TextUtils.isEmpty(email)) {
            userEmailEdit.setError("Required.");
            valid = false;
        } else {
            userEmailEdit.setError(null);
        }

        String password = passEdit.getText().toString();
        if (TextUtils.isEmpty(password)) {
            passEdit.setError("Required.");
            valid = false;
        } else {
            passEdit.setError(null);
        }

        return valid;
        //returnToLogin();


    }

    private void returnToLogin() {
        startActivity(new Intent(this,LoginActivity.class));
    }

    private String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }

}

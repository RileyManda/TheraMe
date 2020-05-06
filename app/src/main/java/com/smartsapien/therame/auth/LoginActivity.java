package com.smartsapien.therame.auth;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.smartsapien.therame.R;
import com.smartsapien.therame.SplashActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.donthave)MaterialButton dontHave;
    @BindView(R.id.loginbtn)MaterialButton loginBt;
    @BindView(R.id.forgotPwd) MaterialButton passReset;
    //password fields
    @BindView(R.id.password_text_input)TextInputLayout passInput;
    @BindView(R.id.password)TextInputEditText passEditTxt;
    //username fields
    @BindView(R.id.username_text_input)TextInputLayout usernameInput;
    @BindView(R.id.username)TextInputEditText usernameEditTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.loginbtn) void loginAcc() {
        //login
        if (!isPasswordEmpty(passEditTxt.getText())) {

            passInput.setError(getString(R.string.pass_field_empty));
        }else {
           passInput.setError(null); // Clear the error
            startActivity(new Intent(this, SplashActivity.class));
        }
//        if (!isUsernameValid(usernameEditTxt.getText())) {
//            usernameInput.setError(getString(R.string.error_username));
//        }else if (!isUsernameEmpty(passEditTxt.getText())) {
//            passInput.setError(getString(R.string.pass_field_empty));
//        }
//
//        else {
//            usernameInput.setError(null); // Clear the error
//            startActivity(new Intent(this, SplashActivity.class));
//
//        }
    }
    @OnClick(R.id.donthave) void createAcc() {
        //create a new account
        startActivity(new Intent(this, SignUpActivity.class));
    }
    @OnClick(R.id.forgotPwd) void reset() {
       //reset password
        startActivity(new Intent(this, ResetActivity.class));
    }
    //isUsernameValid Valid
    private boolean isUsernameValid(@Nullable Editable userText) {
        return userText != null && userText.length() >= 8;
    }
    private boolean isPasswordValid(@Nullable Editable passTxt) {
        return passTxt != null && passTxt.length() >= 8;
    }
    //check if password fields are empty
    private boolean isPasswordEmpty(@Nullable Editable passTxt) {
        return passTxt == null;
    }
    private boolean isUsernameEmpty(@Nullable Editable userTxt) {
        return userTxt != null;
    }
    // Toast.makeText(this, "You did not enter a password", Toast.LENGTH_SHORT).show();
}

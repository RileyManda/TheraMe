package com.smartsapien.therame.auth;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.smartsapien.therame.MainActivity;
import com.smartsapien.therame.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class ResetActivity extends AppCompatActivity {
@BindView(R.id.resetbtn)MaterialButton resetBt;
@BindView(R.id.email) TextInputEditText emailTx;
@BindView(R.id.backtologin)
TextView backToLogin;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        ButterKnife.bind(this);
        }
@OnClick(R.id.resetbtn) void setResetBt() {
       //Reset Pwd and return to Login
        }
        @OnClick(R.id.backtologin) void setBackToLogin() {
        //login
            Timber.i("Back to login");
    startActivity(new Intent(this, LoginActivity.class));
        }
}

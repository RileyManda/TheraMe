package com.smartsapien.therame.profile;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.smartsapien.therame.R;
import butterknife.ButterKnife;
public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
    }

}
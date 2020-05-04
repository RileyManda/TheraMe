package com.smartsapien.therame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.smartsapien.therame.auth.LoginActivity;
import com.smartsapien.therame.profile.ProfileActivity;
import com.smartsapien.therame.utils.Utils;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.fabchat)FloatingActionButton fabChat;
    @BindView(R.id.chatclose)FloatingActionButton fabClose;

    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    boolean isUserFirstTime;

    @Override
    protected void onStart() {
        super.onStart();


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        isUserFirstTime = Boolean.parseBoolean(Utils.readSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME, "true"));

        Intent introIntent = new Intent(MainActivity.this, OnBoardActivity.class);
        introIntent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);

        if (isUserFirstTime)
            startActivity(introIntent);
        FloatingActionButton fab = findViewById(R.id.fabchat);


        fabChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabChat.setVisibility(View.GONE);
                fabClose.setVisibility(View.VISIBLE);


                Snackbar.make(view, "Chat with TheraBot", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fabClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabChat.setVisibility(View.VISIBLE);
                fabClose.setVisibility(View.GONE);


                Snackbar.make(view, "Speak to TheraMe", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    //OnFirst Run
    private void checkFirstRun() {

        final String PREFS_NAME = "MyPrefsFile";
        final String PREF_VERSION_CODE_KEY = "version_code";
        final int DOESNT_EXIST = -1;

        // Get current version code
        int currentVersionCode = BuildConfig.VERSION_CODE;

        // Get saved version code
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int savedVersionCode = prefs.getInt(PREF_VERSION_CODE_KEY, DOESNT_EXIST);

        // Check for first run or upgrade
        if (currentVersionCode == savedVersionCode) {

            // This is just a normal run
            return;

        } else if (savedVersionCode == DOESNT_EXIST) {

            startActivity(new Intent(this,OnBoardActivity.class));

            // TODO This is a new install (or the user cleared the shared preferences)

        } else if (currentVersionCode > savedVersionCode) {

            // TODO This is an upgrade
        }

        // Update the shared preferences with the current version code
        prefs.edit().putInt(PREF_VERSION_CODE_KEY, currentVersionCode).apply();
    }

    //Project Plan"
    //OnFirst RUn,Launch welcome screen/tutorial using gamification
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.profile) {
           startActivity(new Intent(this, ProfileActivity.class));
        }

        if (id == R.id.sign_out) {
            startActivity(new Intent(this, LoginActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.ernest.userprofiledesign.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ernest.userprofiledesign.R;
import com.ernest.userprofiledesign.viewmodel.MainActivityViewModel;
import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;

import at.markushi.ui.CircleButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created: 19/03/2020
 * Author: Ernest Obot
 * */

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.StFirstLayout)
    RelativeLayout rl;
    @BindView(R.id.StsecoundLayout)
    RelativeLayout r2;
    @BindView(R.id.StthirdLayout)
    RelativeLayout r3;
    @BindView(R.id.StFourthLayout)
    RelativeLayout r4;
    @BindView(R.id.StFifthLayout)
    RelativeLayout r5;
    @BindView(R.id.settings_button_rlayout)
    RelativeLayout r6;
    @BindView(R.id.editprofile_button_rlayout)
    RelativeLayout r7;
    @BindView(R.id.BoostButton)
    CircleButton ff;
    @BindView(R.id.username)
    TextView edt;
    @BindView(R.id.Iconimage2)
    CircleImageView profile_images;
    private MainActivityViewModel mViewModel;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * initialized ButterKnife
         */
        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);

        /**
         * initialized ViewModel
         */
        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        initRelative();
        initViews();

    }

    private void initViews() {
        r6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //code for settings activity or fragment
                //code for navigating to Settings Activity using intent
                //replace this SettingsActivity.class with yours
                Intent myIntent = new Intent(getBaseContext(),   MainActivity.class);
                startActivity(myIntent);

            }
        });

        r7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //code for edit profile activity or fragment
                //code for navigating to EditProfile Activity using intent
                //replace this EditProfileActivty.class with yours
                Intent myIntent = new Intent(getBaseContext(),   MainActivity.class);
                startActivity(myIntent);
            }
        });

        //edt.setText("Obot Ernest");
        //profile_images.setImageResource(R.drawable.obot);


    }


    private void initRelative() {

        /**
         * Write a logic that will triger rating
         * */
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for rating
                    final String appName = getApplicationContext().getPackageName();
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appName)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appName)));
                    }
            }
        });

        /**
         * Write a logic that will triger inviting friends
         * */
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for inviting friends
                //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.play_more_apps))));
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "User Profile Template");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, getResources().getString(R.string.share_app_text));
                startActivity(Intent.createChooser(sharingIntent, "Share User Profile Template via"));
                Log.i(TAG, "App Shared");
            }
        });

        /**
         * Write a logic that will triger FAQ and Contact Us Activity
         * */
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for navigating to FAQ and Contact Us Activity using intent
                //replace this ContactUsActivity.class with yours
                Intent myIntent = new Intent(getBaseContext(),   MainActivity.class);
                startActivity(myIntent);
            }
        });

        /**
         * Write a logic that will triger for an update
         * */
        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //code for update
                checkForNetworkAndUpdate();

            }
        });

        /**
         * Write a logic that will triger privacy policy activity, fragment or dialog
         * */
        r5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //code for privacy policy activity, fragment or dialog
                //code for navigating to privacy policy Activity using intent
                //replace this PrivacyActivity.class with yours
                Intent myIntent = new Intent(getBaseContext(),   MainActivity.class);
                startActivity(myIntent);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void checkForNetworkAndUpdate(){
        //checking for internet connectivity
        ConnectivityManager connMgr = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        //if there is network access, make an update query to the backend
        if (networkInfo != null && networkInfo.isConnected()) {

            AppUpdater appUpdater = new AppUpdater(this);
            appUpdater.setUpdateFrom(UpdateFrom.JSON)
                    .setUpdateJSON("https://megtrix.com/update-changelog.json")
                    .setDisplay(Display.DIALOG)
                    .showAppUpdated(true)
                    .setTitleOnUpdateAvailable("Update Available")
                    //.setContentOnUpdateAvailable("Check out the latest version available of Profile Template App!")
                    .setTitleOnUpdateNotAvailable("Update not available")
                    .setContentOnUpdateNotAvailable("No update available. Check for updates again later!")
                    .setButtonUpdate("Update now?")
                    .setButtonDismiss("Maybe later")
                    .setButtonDoNotShowAgain(null)
                    .showEvery(3)
                    .setIcon(R.drawable.ic_system_update)
                    .setCancelable(false)
                    .start();
        } else {
            //if there is no network, show toast to users
            Toast toast = Toast.makeText(this,"Please Connect to Internet to Check for Latest Updates",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}

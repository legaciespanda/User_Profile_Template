package com.ernest.userprofiledesign.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ernest.userprofiledesign.R;
import com.ernest.userprofiledesign.viewmodel.MainActivityViewModel;

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
                Intent myIntent = new Intent(getBaseContext(),   SettingsActivity.class);
                startActivity(myIntent);

            }
        });

        r7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //code for edit profile activity or fragment
                //code for navigating to EditProfile Activity using intent
                //replace this EditProfileActivty.class with yours
                Intent myIntent = new Intent(getBaseContext(),   EditProfileActivty.class);
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
                Intent myIntent = new Intent(getBaseContext(),   ContactUsActivity.class);
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
                Intent myIntent = new Intent(getBaseContext(),   PrivacyActivity.class);
                startActivity(myIntent);
            }
        });
    }




}

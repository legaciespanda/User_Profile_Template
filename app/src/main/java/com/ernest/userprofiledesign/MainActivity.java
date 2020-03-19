package com.ernest.userprofiledesign;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    CircleImageView profile_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);
        initRelative();
        initViews();
    }

    private void initViews() {
        r6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //code for settings activity or fragment
            }
        });

        r7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //code for edit profile activity or fragment
            }
        });

        //edt.setText("Obot Ernest");
        //profile_image.setImageResource(R.drawable.obot);


    }


    private void initRelative() {

        /**
         * Write a logic that will triger rating
         * */
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //code for rating
            }
        });

        /**
         * Write a logic that will triger inviting friends
         * */
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //code for inviting friends
            }
        });

        /**
         * Write a logic that will triger FAQ and Contact Us Activity
         * */
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //code for FAQ and Contact Us Activity
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
            }
        });
    }




}

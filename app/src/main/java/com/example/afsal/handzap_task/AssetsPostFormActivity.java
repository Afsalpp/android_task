package com.example.afsal.handzap_task;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class AssetsPostFormActivity extends AppCompatActivity {

    ImageButton button,btnLocation,attach;
    TextView payment;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assets_post_form);

        button= findViewById(R.id.button);
        payment = findViewById(R.id.payment);
        btnLocation= findViewById(R.id.button_location);
        attach= findViewById(R.id.btn_attach);

        payment.setFocusable(false);
        payment.setClickable(true);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment fragment = new DialogFragment();
                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_layout, fragment);
                transaction.commit();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssetsPostFormActivity.this,CategoriesActivity.class);
                startActivity(intent);
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssetsPostFormActivity.this,MapActivity.class);
                startActivity(intent);
            }
        });

        attach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraDialog fragment = new CameraDialog();
                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_layout, fragment);
                transaction.commit();
            }
        });

    }
}

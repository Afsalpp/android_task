package com.example.afsal.handzap_task;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CameraDialog extends DialogFragment {
    TextView camera,video,document;
    private View rootView;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    public static CameraDialog newInstance(String title) {
        CameraDialog frag = new CameraDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_camera_dialog, container, false);

        camera= rootView.findViewById(R.id.camera);
        video= rootView.findViewById(R.id.video);
        document= rootView.findViewById(R.id.document);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }            }
        });

        return rootView;
    }
}

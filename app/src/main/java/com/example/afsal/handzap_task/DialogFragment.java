package com.example.afsal.handzap_task;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DialogFragment extends android.support.v4.app.DialogFragment {
    RadioGroup radioPaymentMode;
    private String noPref,e_payment,cash;
    public String paymentMode;
    private RadioButton radioButton;
    Button cancel,select;
    private View rootView;

    public static DialogFragment newInstance(String title) {
        DialogFragment frag = new DialogFragment();
        Bundle args = new Bundle();
        args.putString("Payment Method", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_dialog, container, false);

        radioPaymentMode = rootView.findViewById(R.id.radioMode);
        cancel = rootView.findViewById(R.id.cancel);
        select= rootView.findViewById(R.id.select);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),AssetsPostFormActivity.class));
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),AssetsPostFormActivity.class));
            }
        });
        radioPaymentMode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId){

                    case R.id.radio_pref:
                        paymentMode = "No preference";
                        break;
                    case R.id.radio_payment:
                        paymentMode = "e-payment";
                        break;
                    case R.id.radio_cash:
                        paymentMode = "cash";
                        break;
                }
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {

        super.onResume();
        radioPaymentMode.clearCheck();
    }
}

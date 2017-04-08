package com.sdacademy.slowinski.andrzej.mycv;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sdacademy.slowinski.andrzej.mycv.Views.CvRow;
import com.sdacademy.slowinski.andrzej.mycv.model.MailItem;
import com.sdacademy.slowinski.andrzej.mycv.model.PhoneItem;
import com.sdacademy.slowinski.andrzej.mycv.model.WebItem;


public class ContactFragment extends Fragment {

    private LinearLayout rowHolder;

    public ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        rowHolder = (LinearLayout) view.findViewById(R.id.contactFragmentRowHolder);
        setupRows();

        return view;
    }
    public void setupRows() {

        CvRow table[] = new CvRow[]{
                new CvRow(getActivity(), new PhoneItem()),
                new CvRow(getActivity(), new WebItem("git", R.drawable.ic_cloud_black_24dp, "https://github.com/andre1704/MyCv")),
                new CvRow(getActivity(), new MailItem("mail", R.drawable.ic_contact_mail_black_24dp)),
                new CvRow(getActivity(), new WebItem("adres domowy", R.drawable.ic_location_city_black_24dp, "https://www.google.pl/maps/place/Krzysztofa+Kolumba+5,+51-503+Wroc%C5%82aw/@51.112385,17.1167235,17z/data=!3m1!4b1!4m5!3m4!1s0x470fe80902774f13:0xe8f953eb03c77c8c!8m2!3d51.112385!4d17.1189122"))
        };
        for (int i = 0; i < table.length; i++) {
            rowHolder.addView(table[i]);
        }
    }



}

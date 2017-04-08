package com.sdacademy.slowinski.andrzej.mycv;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmailSendFragment extends Fragment {


    public EmailSendFragment() {
        // Required empty public constructor
    }

    public static EmailSendFragment newInstance() {
        EmailSendFragment fragment = new EmailSendFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_email_send, container, false);
    }

}

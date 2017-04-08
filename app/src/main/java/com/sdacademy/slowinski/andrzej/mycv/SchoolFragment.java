package com.sdacademy.slowinski.andrzej.mycv;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class SchoolFragment extends Fragment {
    private LinearLayout rowHolder;

    public static SchoolFragment newInstance() {
        SchoolFragment fragment = new SchoolFragment();
        return fragment;
    }


    public SchoolFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_school,container,false);
        rowHolder=(LinearLayout) view.findViewById(R.id.schoolFragment);
        setupRows();
        return view;



    }


    public void setupRows() {

        CvRow table[] = new CvRow[]{
                new CvRow(getActivity(), new WebItem("Politechnika Wrocławska, kierunnek Automatryka i robotyka, wydział Elektroniki", R.drawable.ic_school_black_24dp,"http://weka.pwr.edu.pl/44074,41.dhtml")),
                new CvRow(getActivity(), new WebItem("III liceum ogólnokształcące imienia Mikołaja Kopernika w Kaliszu", R.drawable.ic_school_black_24dp,"http://www.kopernik.kalisz.pl")),

        };
        for (int i = 0; i < table.length; i++) {
            rowHolder.addView(table[i]);
        }
    }

}

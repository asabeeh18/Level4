package com.tct.level4;

/**
 * Created by Aditya C Awalkar on 17-03-2015.
 */
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ThatFragment extends ListFragment {

    Context context;
    LayoutInflater inflater;
    ViewGroup container;
    public ThatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.container=container;
        this.inflater=inflater;
        return inflater.inflate(R.layout.fragment_that, container, false);

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
/*
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Planets, android.R.layout.simple_list_item_1);

        setListAdapter(adapter);
       // getListView().setOnItemClickListener(this);

    }
*/
        this.context = container.getContext();
        DatabaseHandler adi = new DatabaseHandler(context);
//ab ye kya hua?
        ArrayList results = adi.displayAll();
        Log.d("db", "1");

        inflater.inflate(R.layout.fragment_that, container, false);
        TextView tView = new TextView(context);
        tView.setText("PREVIOUS MESSAGES LIST");
        getListView().addHeaderView(tView);
        Log.d("db", "2");
        setListAdapter(new ArrayAdapter<String>(context,
                android.R.layout.simple_list_item_1, results));
        getListView().setTextFilterEnabled(true);
        Log.d("db", "3");
    }
}
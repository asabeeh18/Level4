package com.tct.level4;

/**
 * Created by Aditya C Awalkar on 17-03-2015.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TheOtherFragment extends Fragment implements View.OnClickListener {

    Context context;
    private Button awaaj;
    private Button vib;
    View v;

    public TheOtherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_the_other, container, false);
        context = container.getContext();


        //  }

        //  @Override
        // public void onActivityCreated(Bundle savedInstanceState) {

        //  super.onActivityCreated(savedInstanceState);
        awaaj = (Button) v.findViewById(R.id.sound);
        vib = (Button) v.findViewById(R.id.vibration);
        Log.d("onactivity", "dada");
        awaaj.setOnClickListener(this);
        vib.setOnClickListener(this);

     /*
        @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Ring.class);
                startActivity(intent);

            }
        });

        (new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.d("vib","2");

            }
        });
*/
        return v;
    }


    @Override
    public void onClick(View va) {
        switch (va.getId()) {
            case R.id.vibration:
                Log.d("awaaj","1");
                Intent intent = new Intent(context, Vib.class);
                startActivity(intent);
                Log.d("awaaj","2");
                break;

            case R.id.sound:
                Log.d("vib","1");
                Intent inten = new Intent(context, Ring.class);
                startActivity(inten);
                Log.d("vib","1");
                break;

        }
    }
}
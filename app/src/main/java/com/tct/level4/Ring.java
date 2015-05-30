package com.tct.level4;

/**
 * Created by Aditya C Awalkar on 28-03-2015.
 */

        import android.app.ListActivity;
        import android.content.Context;
        import android.content.SharedPreferences;
        import android.database.Cursor;
        import android.media.MediaPlayer;
        import android.media.RingtoneManager;
        import android.net.Uri;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import java.util.List;

public class Ring extends ListActivity  implements OnItemClickListener  {
    ArrayAdapter adapter;
    String n[] =new String[]{"None","Buzz","Heat","Demonstrative","Solemn","Sherlock"};
    int apna[]=new int[]{R.raw.none,R.raw.buzz,R.raw.heat,R.raw.demonstrative,R.raw.solemn,R.raw.sherlock};
    //String frustrated="bcnf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, n);
        setListAdapter(adapter);
        TextView t=new TextView(this);
//        t.setText("SELECT NOTIFICATION TONE");
  //      getListView().addHeaderView(t);
        getListView().setOnItemClickListener(this);
    }

     MediaPlayer md;
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if(md != null) {
            if(md.isPlaying())
                md.stop();
            md = null;
        }
        //Uri adi= Uri.parse("android.resource:///com.tct.level14/"+ apna[position]);
        SharedPreferences settings = Ring.this.getSharedPreferences("hhh", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        int a= apna[position];
        String te= a +"";
        Log.d("song",te);
        editor.putInt("sabeehsucks", a);
        editor.commit();
        md = MediaPlayer.create(this, apna[position]);
        md.start();
    }

}

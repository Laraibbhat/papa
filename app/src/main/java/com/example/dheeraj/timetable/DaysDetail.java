package com.example.dheeraj.timetable;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dheeraj.timetable.Utils.LetterImageView;

//import android.widget.Toolbar;

public class DaysDetail extends AppCompatActivity {

    private ListView listView;
    private Toolbar toolbar;
    public static String [] Monday;
    public static String [] Tuesday;
    public static String [] Wednesday;
    public static String [] Thusday;
    public static String [] Friday;
    public static String [] Saturday;
    public static String [] Time_1;
    public static String [] Time_2;
    public static String [] Time_3;
    public static String [] Time_4;
    public static String [] Time_5;
    public static String [] Time_6;
    private String [] PreferredDays;
    private String [] PreferredTime;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_days_detail );
        setUIView();
        init();
        setupListView();
    }

    private void setUIView(){
        listView=(ListView)findViewById( R.id.lvDayDetail );
        toolbar=(Toolbar)findViewById( R.id.ToolbarDayDetails );
    }

    private void init(){
        setSupportActionBar( toolbar );
        getSupportActionBar().setTitle(days_activity.sharedPreferences.getString( days_activity.SEL_DAYS,null ));
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

    }

    private void setupListView(){
        Monday=getResources().getStringArray( R.array.SE );
        Tuesday=getResources().getStringArray( R.array.TE );
        Wednesday=getResources().getStringArray( R.array.BE );
        Thusday=getResources().getStringArray( R.array.Thusday );
        Friday=getResources().getStringArray( R.array.Friday);
        Saturday=getResources().getStringArray( R.array.Saturday );


        Time_1=getResources().getStringArray( R.array.Time_1 );
        Time_2=getResources().getStringArray( R.array.Time_2);
        Time_3=getResources().getStringArray( R.array.Time_3 );
        Time_4=getResources().getStringArray( R.array.Time_4 );
        Time_5=getResources().getStringArray( R.array.Time_5 );
        Time_6=getResources().getStringArray( R.array.Time_6 );

        String selected_day=days_activity.sharedPreferences.getString( days_activity.SEL_DAYS,null );

        if(selected_day.equalsIgnoreCase( "SE" )){
            PreferredDays=Monday;
            PreferredTime=Time_1;

        }else
            if(selected_day.equalsIgnoreCase( "TE" )){
            PreferredDays=Tuesday;
            PreferredTime=Time_2;

        }else if(selected_day.equalsIgnoreCase( "BE" )){
            PreferredDays=Wednesday;
            PreferredTime=Time_3;

        }else if(selected_day.equalsIgnoreCase( "Thusday" )){
            PreferredDays=Thusday;
            PreferredTime=Time_4;

        }else if(selected_day.equalsIgnoreCase( "Friday" )){
            PreferredDays=Friday;
            PreferredTime=Time_5;

        }else {
            PreferredDays=Saturday;
            PreferredTime=Time_6;

        }

        SimpleAdapter simpleAdapter=new SimpleAdapter( DaysDetail.this ,PreferredDays,PreferredTime);
        listView.setAdapter( simpleAdapter );

    }

    public class SimpleAdapter extends BaseAdapter {


        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView subject,time;
        private String [] subjectArray;
        private String[] timeArray;
        private LetterImageView letterImageView;

        public SimpleAdapter(Context context,String[] subjectArray,String[] timeArray){
            mContext=context;
            this.subjectArray=subjectArray;
            this.timeArray=timeArray;
            layoutInflater=LayoutInflater.from(context);

        }



        @Override
        public int getCount() {
            return subjectArray.length;
        }

        @Override
        public Object getItem(int i) {
            return subjectArray[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null)
            {
                view = layoutInflater.inflate(R.layout.day_detail_single_item,null);
            }

            subject=(TextView)view.findViewById(R.id.tvDayDetail);
            time=(TextView)view.findViewById(R.id.tvTimeDayDetail);
            letterImageView=(LetterImageView)view.findViewById(R.id.ivDayDetail);

            subject.setText(subjectArray[i]);
            time.setText(timeArray[i]);


            letterImageView.setOval( true );
            letterImageView.setLetter( subjectArray[i].charAt( 0 ) );



            return view;
        }
    }

    public static class Teachertimetable extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_teachertimetable);
        }
    }
}

package com.example.dheeraj.timetable;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dheeraj.timetable.TimetableAdapters.RecyclerviewBE;
import com.example.dheeraj.timetable.TimetableAdapters.RecyclerviewSE;
import com.example.dheeraj.timetable.TimetableAdapters.RecyclerviewTE;
import com.example.dheeraj.timetable.TimetableAdapters.parera;
import com.example.dheeraj.timetable.TimetableAdapters.parera1;
import com.example.dheeraj.timetable.TimetableAdapters.parera10;
import com.example.dheeraj.timetable.TimetableAdapters.parera2;
import com.example.dheeraj.timetable.TimetableAdapters.parera3;
import com.example.dheeraj.timetable.TimetableAdapters.parera4;
import com.example.dheeraj.timetable.TimetableAdapters.parera5;
import com.example.dheeraj.timetable.TimetableAdapters.parera6;
import com.example.dheeraj.timetable.TimetableAdapters.parera7;
import com.example.dheeraj.timetable.TimetableAdapters.parera8;
import com.example.dheeraj.timetable.TimetableAdapters.parera9;
import com.example.dheeraj.timetable.Utils.LetterImageView;

//import android.widget.Toolbar;


public class teachertimetable extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    public static SharedPreferences sharedPreferences;
    public static String SEL_DAYS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_days_activity );
        setupUIView();
        init();
        /*setSupportActionBar( toolbar );
        getSupportActionBar().setTitle("Days");
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );*/
        setupListView();

    }


    private void setupUIView()
    {
        toolbar=findViewById( R.id.ToolbarDays );
        listView=findViewById( R.id.ListDays );
        sharedPreferences=getSharedPreferences( "My Day",MODE_PRIVATE );
    }

    private void init(){
        setSupportActionBar( toolbar );
        getSupportActionBar().setTitle("Teachertimetable");
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

    }
    private void setupListView(){
        String[] days=getResources().getStringArray( R.array.Teacher );
        DaysAdepter adapter=new DaysAdepter( this,R.layout.activity_teachertimetable ,days );
        listView.setAdapter( adapter );
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0: {
                        startActivity( new Intent( teachertimetable.this, parera.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS, "Parera" ).apply();
                        break;
                    }
                    case 1:{startActivity( new Intent( teachertimetable.this,parera1.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"Deshmukh mam" ).apply();
                        break;}
                    case 2:{startActivity( new Intent( teachertimetable.this,parera2.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"Deshmukh sir" ).apply();
                        break;}
                    case 3:{startActivity( new Intent( teachertimetable.this, parera3.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"Ghumrai sir" ).apply();
                        break;}
                    case 4:{startActivity( new Intent( teachertimetable.this, parera4.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"Snehal mam" ).apply();
                        break;}
                    case 5:{startActivity( new Intent( teachertimetable.this, parera5.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"Agarwal" ).apply();
                        break;}
                    case 6:{startActivity( new Intent( teachertimetable.this, parera6.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"Surbe mam" ).apply();
                        break;}
                    case 7:{startActivity( new Intent( teachertimetable.this, parera7.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"kanchan mam" ).apply();
                        break;}
                    case 8:{startActivity( new Intent( teachertimetable.this, parera8.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"Turlai sir" ).apply();
                        break;}
                    case 9:{startActivity( new Intent( teachertimetable.this, parera9.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"Air_p" ).apply();
                        break;}
                    case 10:{startActivity( new Intent( teachertimetable.this, parera10.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"El_2" ).apply();
                        break;}
                    default:break;

                }
            }
        } );
    }

    public class DaysAdepter extends ArrayAdapter{

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] days= new String[]{};


        public DaysAdepter(@NonNull Context context, int resource, String [] objects) {
            super( context, resource ,objects);
            this.resource=resource;
            this.days=objects;
            layoutInflater=(LayoutInflater)context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                holder=new ViewHolder();
                convertView=layoutInflater.inflate( resource,null );
                holder.ivLogo=(LetterImageView)convertView.findViewById( R.id.ivLetter );
                holder.tvdays=(TextView)convertView.findViewById( R.id.tvMain);
                convertView.setTag( holder );

            }
            else
            {
                holder=(ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval( true );
            holder.ivLogo.setLetter( days[position].charAt( 0 ) );
            holder.tvdays.setText( days[position] );
            return convertView;


        }

        class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvdays;

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:{
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected( item );
    }
}

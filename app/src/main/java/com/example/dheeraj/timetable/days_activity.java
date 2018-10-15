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

import com.example.dheeraj.timetable.Utils.LetterImageView;

//import android.widget.Toolbar;


public class days_activity extends AppCompatActivity {

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
        getSupportActionBar().setTitle("CLASSES");
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

    }
    private void setupListView(){
        String[] days=getResources().getStringArray( R.array.Days );
        DaysAdepter adapter=new DaysAdepter( this,R.layout.activity_days_single_item ,days );
        listView.setAdapter( adapter );
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0: {
                        startActivity( new Intent( days_activity.this, DaysDetail.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS, "SE" ).apply();
                        break;
                    }
                    case 1:{startActivity( new Intent( days_activity.this,Recyclerview.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"TE" ).apply();
                        break;}
                    case 2:{startActivity( new Intent( days_activity.this,Recyclerview.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"BE" ).apply();
                        break;}
                    /*case 3:{startActivity( new Intent( days_activity.this, DaysDetail.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"Thusday" ).apply();
                        break;}
                    case 4:{startActivity( new Intent( days_activity.this, DaysDetail.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"Friday" ).apply();
                        break;}
                    case 5:{startActivity( new Intent( days_activity.this, DaysDetail.class ) );
                        sharedPreferences.edit().putString( SEL_DAYS,"Saturday" ).apply();
                        break;}*/
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

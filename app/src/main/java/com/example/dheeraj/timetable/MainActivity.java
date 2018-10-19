package com.example.dheeraj.timetable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar=findViewById(R.id.ToolbarMain);
        listView=findViewById(R.id.Listview);


        setSupportActionBar( toolbar );
        getSupportActionBar().setTitle("Timetable");

        //UIViews();
       // initToolbar();
        setUpListView();
    }

   /* private void UIViews()
    {
        toolbar=findViewById(R.id.ToolbarMain);
        listView=findViewById(R.id.Listview);

    }

    private void initToolbar()
    {
        setSupportActionBar(Toolbar toolbar );
        getSupportActionBar().setTitle("Timetable");

    }*/


    private void setUpListView()
    {
        String[] title = getResources().getStringArray(R.array.Main);
        String[] description = getResources().getStringArray(R.array.description);

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,title,description);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:{
                        Intent intent=new Intent( MainActivity.this,days_activity.class );
                        startActivity( intent );
                        break;
                    }
                    case 1:{Intent intent=new Intent( MainActivity.this,teachertimetable.class );
                        startActivity( intent );
                        break;
                    }
                    case 2:{
                        break;
                    }

                }
            }
        } );
    }


    public class SimpleAdapter extends BaseAdapter{


        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView  title,description;
        private String [] titleArray;
        private String[] descriptionArray;
        private ImageView imageView;

        public SimpleAdapter(Context context,String[] title,String[] description){
            mContext=context;
            titleArray=title;
            descriptionArray=description;
            layoutInflater=LayoutInflater.from(context);

        }



        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int i) {
            return titleArray[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null)
            {
                view = layoutInflater.inflate(R.layout.main_activity_single_item,null);
            }

            title=(TextView)view.findViewById(R.id.tvMain);
            description=(TextView)view.findViewById(R.id.tvDescription);
            imageView=(ImageView)view.findViewById(R.id.ivMain);

            title.setText(titleArray[i]);
            description.setText(descriptionArray[i]);

            if(titleArray[i].equalsIgnoreCase("Timetable"))
            {
                imageView.setImageResource(R.drawable.timetable);
            }

            else if(titleArray[i].equalsIgnoreCase("Faculty"))
            {
                imageView.setImageResource(R.drawable.contact);
            }
            else if(titleArray[i].equalsIgnoreCase("Setting"))
            {
                imageView.setImageResource(R.drawable.setting);
            }


            return view;
        }
    }
}

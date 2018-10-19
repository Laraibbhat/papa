package com.example.dheeraj.timetable.TimetableAdapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dheeraj.timetable.R;
import com.example.dheeraj.timetable.Utils.SeTimetable;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewTE extends AppCompatActivity {
    RecyclerView recyclerView, recyclerView1, recyclerView2,
            recyclerView3, recyclerView4;
    TextView Automobile,Civil,Comp,Instru,Entc;
    ArrayList<Integer> images = new ArrayList<>();
    LinearLayoutManager linearLayoutManager, linearLayoutManager1, linearLayoutManager2,
            linearLayoutManager3, linearLayoutManager4;
    private Toolbar toolbar;
    public int ptrUID;

    public SeTimetable seTimetable;

   private FirebaseDatabase firebaseDatabase;




    public int[] logosauto = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
    public int[] logoscivil = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
    public int[] logoscomp = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
    public int[] logosentc = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
    public int[] logosinstru = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        firebaseDatabase=FirebaseDatabase.getInstance();
       // DatabaseReference databaseReference=firebaseDatabase.getReference(firebaseDatabase.ti)
        toolbar = (Toolbar) findViewById(R.id.toolbar);



        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TimeTable");
        addImages();

        linearManager();
        recycleView();
        layoutMan();
        setadap();


    }

    public void addImages() {

    }

    public void layoutMan() {
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView3.setLayoutManager(linearLayoutManager3);
        recyclerView4.setLayoutManager(linearLayoutManager4);

    }

    public void linearManager() {

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager4 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);


    }

    public void recycleView() {

        recyclerView = (RecyclerView) findViewById(R.id.rvListAutoGames);
        recyclerView1 = (RecyclerView) findViewById(R.id.rvListCivilGames);
        recyclerView2 = (RecyclerView) findViewById(R.id.rvListCompGames);
        recyclerView3 = (RecyclerView) findViewById(R.id.rvListEnTCGames);
        recyclerView4 = (RecyclerView) findViewById(R.id.rvListInstruGames);
        Automobile=(TextView)findViewById(R.id.tvAutoGames);
        Civil=(TextView)findViewById(R.id.tvCivilGames);
        Comp=(TextView)findViewById(R.id.tvCompGames);
        Entc=(TextView)findViewById(R.id.tvEnTCGames);
        Instru=(TextView)findViewById(R.id.tvInstruGames);

    }

    public void setadap() {


        FirebaseFirestore.getInstance()
                .collection("TE_Timetable")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful())
                        {
                            List<DocumentSnapshot> mylistofDocuments=task.getResult().getDocuments();
                            seTimetable=mylistofDocuments.get(1).toObject(SeTimetable.class);
                            ArrayList<String> subject;
                            String[] times={"10:15","11:15","12:15","1:15","1:45","2:45","3:45","4:45"};

                            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(RecyclerviewTE.this, logosauto, seTimetable.getMon(), "auto",times);
                            recyclerView.setAdapter(recyclerViewAdapter);
                            RecyclerViewAdapter recyclerViewAdapter1 = new RecyclerViewAdapter(RecyclerviewTE.this, logoscivil, seTimetable.getTue(), "civil",times);
                            recyclerView1.setAdapter(recyclerViewAdapter1);
                            RecyclerViewAdapter recyclerViewAdapter2 = new RecyclerViewAdapter(RecyclerviewTE.this, logoscomp, seTimetable.getWen(), "comp",times);
                            recyclerView2.setAdapter(recyclerViewAdapter2);
                            RecyclerViewAdapter recyclerViewAdapter3 = new RecyclerViewAdapter(RecyclerviewTE.this, logosentc, seTimetable.getThur(), "entc",times);
                            recyclerView3.setAdapter(recyclerViewAdapter3);
                            RecyclerViewAdapter recyclerViewAdapter4 = new RecyclerViewAdapter(RecyclerviewTE.this, logosinstru, seTimetable.getfri(), "instru",times);
                            recyclerView4.setAdapter(recyclerViewAdapter4);
                        }
                    }
                });



    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
        Context mcontext;
        ArrayList<String> EventNames;
        String department;
        int[] images;
        String[] waqt;
        LayoutInflater layoutInflater;


        public RecyclerViewAdapter(Context context, int[] images, ArrayList<String> EventNames, String department,String[] waqt) {
            this.mcontext = context;
            this.images = images;
            this.EventNames = EventNames;
            this.department = department;
            this.waqt=waqt;
            layoutInflater = LayoutInflater.from(mcontext);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view= layoutInflater.inflate(R.layout.list_timetable,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {


            holder.Title.setText(EventNames.get(position));
            holder.Timee.setText(waqt[position]);

        }

        @Override
        public int getItemCount() {
            return EventNames.size();
        }



        public class ViewHolder extends RecyclerView.ViewHolder
        {
            public ImageView imageList;
            public TextView Title,Timee
                    ;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
               // imageList=(ImageView)itemView.findViewById(R.id.ivtimetable);
                Title=(TextView)itemView.findViewById(R.id.tvtimetable);
                Timee=(TextView)itemView.findViewById(R.id.tvtimetableTime);
                Title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent( RecyclerviewTE.this,BatchtimetableTE.class );
                        startActivity( intent );
                    }
                });


            }
        }
    }
}

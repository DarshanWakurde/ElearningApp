package com.example.elearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class Courser extends AppCompatActivity implements ItemClickListner {


    RecyclerView recyclerView;
    TextView name;
    CircleImageView imgwe;
    String[] str = {"Data Structure and algo", "Java Programing", "Operating System", "Sql", "Python"};
    int[] img = {R.drawable.datastructurealgos, R.drawable.java, R.drawable.ps, R.drawable.sql, R.drawable.python};
    Student stud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courser);

        name = findViewById(R.id.namestudent);
        imgwe = findViewById(R.id.myimage);
        String auth = FirebaseAuth.getInstance().getUid();

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://elearning-app-e343a-default-rtdb.firebaseio.com/");
        DatabaseReference dbref = database.getReference("StudentsData");
        dbref.child("Stud".concat(auth)).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {

                    if (task.getResult().exists()) {


                        DataSnapshot snapshot = task.getResult();
                        name.setText("Hey,   ".concat(String.valueOf(snapshot.child("name").getValue())));
                        String id = String.valueOf(snapshot.child("id").getValue());

                        imgwe.setImageResource(Integer.parseInt(id));


                    } else {
                        Toast.makeText(Courser.this, "Resul Not Exist", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(Courser.this, "Sorry Not Success!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


//        dbref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
////                 if(snapshot.exists()){
////                     for (DataSnapshot ds:snapshot.getChildren()){
////                         stud=ds.getValue(Student.class);
////                     }
//                Student s=snapshot.child(auth).getValue(Student.class);
//                     Toast.makeText(Courser.this, s.getEmail(), Toast.LENGTH_SHORT).show();
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


        recyclerView = findViewById(R.id.myCourses);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        MainAdapter mainAdapter = new MainAdapter(str, img);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(mainAdapter);
        mainAdapter.setClickListner(new ItemClickListner() {
            @Override
            public void onCLick(View v, int pos) {




                    Intent intent = new Intent(Courser.this, Nextactivity.class);
                    intent.putExtra("Resid", img[pos]);
                    intent.putExtra("Name", str[pos]);
                    startActivity(intent);




            }
        });

    }


    @Override
    public void onCLick(View v, int pos) {

    }
}
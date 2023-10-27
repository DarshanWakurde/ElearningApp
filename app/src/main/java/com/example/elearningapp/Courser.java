package com.example.elearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
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
    int imgId=0;
    TextView name;
    CircleImageView imgwe;
    String[] str = {"Data Structure and algo", "Java Programing", "Operating System", "Sql", "Python"};
    int[] img = {R.drawable.datastructurealgos, R.drawable.java, R.drawable.ps, R.drawable.sql, R.drawable.python};
    Student stud;
String name12,Email;
Long mobile;
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
                        imgId=Integer.parseInt(id);

                        Email=snapshot.child("email").getValue(String.class);
                        mobile=snapshot.child("mobile").getValue(Long.class);
                        name12=snapshot.child("name").getValue(String.class);
                        Toast.makeText(Courser.this, name12, Toast.LENGTH_SHORT).show();

                        imgwe.setImageResource(imgId);

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


        imgwe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Courser.this,ProfileActivity.class);
                intent.putExtra("Imagee",imgId);
                intent.putExtra("Name",name12);
                intent.putExtra("Mobile",mobile);
                intent.putExtra("Email",Email);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onCLick(View v, int pos) {

    }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder builder = new AlertDialog.Builder(Courser.this);


        builder.setMessage("Do you want to exit ?");


        builder.setTitle("Alert !");


        builder.setCancelable(false);


        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {

            finish();
        });

        //
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {

            dialog.cancel();
        });


        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }
}
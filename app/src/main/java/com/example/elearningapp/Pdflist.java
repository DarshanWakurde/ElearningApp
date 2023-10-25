package com.example.elearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Pdflist extends AppCompatActivity {



    FirebaseDatabase database;

    DatabaseReference databaseReference;
    List<VideoModel> list;
    RecyclerView recyclerView;
    PdfAdapter adapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdflist);


        recyclerView=findViewById(R.id.RecycleViewpdf);



        Intent intent=getIntent();


        list=new ArrayList<>();

        database=FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        if(intent.getStringExtra("Name").equals("Python")) {

            databaseReference.child("PYTHON pdf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    // Iterate through the children of the "python" node
                    for (DataSnapshot pythonData : dataSnapshot.getChildren()) {
                        // Access the Python data fields

                        VideoModel videoModel = pythonData.getValue(VideoModel.class);
                        list.add(videoModel);
                        // Use the data as needed (e.g., display it in your app)
                        // Example: Log the Python data
//                     Log.d("PythonData", "ID: " + videoModel.getId() + ", Link: " + videoModel.getLink() + ", Title: " + videoModel.getTitle() + ", Description: " + videoModel.getDiscription());
                    }
                    adapterView = new PdfAdapter(list, Pdflist.this);
                    recyclerView.setAdapter(adapterView);
                    adapterView.setClickListner(new ItemClickListner() {
                        @Override
                        public void onCLick(View v, int pos) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setDataAndType(Uri.parse(list.get(pos).getLink()), "application/pdf");
                            startActivity(intent);
                        }
                    });


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle any errors that occur during the retrieval of data
                    Log.e("FirebaseError", "Error: " + databaseError.getMessage());
                }
            });
        }
        //-----------------------------------------------------Data Structures and alogos--------------------------------------------------------------------
        if(intent.getStringExtra("Name").equals("Data Structure and algo")) {

            databaseReference.child("DSA pdf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    // Iterate through the children of the "python" node
                    for (DataSnapshot pythonData : dataSnapshot.getChildren()) {
                        // Access the Python data fields

                        VideoModel videoModel = pythonData.getValue(VideoModel.class);
//                     String id = pythonData.child("id").getValue(String.class);
//                     String link = pythonData.child("link").getValue(String.class);
//                     String title = pythonData.child("Title").getValue(String.class);
//                     String description = pythonData.child("discription").getValue(String.class);
                        list.add(videoModel);
                        // Use the data as needed (e.g., display it in your app)
                        // Example: Log the Python data
//                     Log.d("PythonData", "ID: " + videoModel.getId() + ", Link: " + videoModel.getLink() + ", Title: " + videoModel.getTitle() + ", Description: " + videoModel.getDiscription());
                    }
                    adapterView = new PdfAdapter(list, Pdflist.this);
                    recyclerView.setAdapter(adapterView);
                    adapterView.setClickListner(new ItemClickListner() {
                        @Override
                        public void onCLick(View v, int pos) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setDataAndType(Uri.parse(list.get(pos).getLink()), "application/pdf");
                            startActivity(intent);
                        }
                    });


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle any errors that occur during the retrieval of data
                    Log.e("FirebaseError", "Error: " + databaseError.getMessage());
                }
            });
        }


        //-----------------------------------------------------------------------------------------------------------------------------------------------------

        //-----------------------------------------------------Java Programing--------------------------------------------------------------------
        if(intent.getStringExtra("Name").equals("Java Programing")) {

            databaseReference.child("JAVA pdf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    // Iterate through the children of the "python" node
                    for (DataSnapshot pythonData : dataSnapshot.getChildren()) {
                        // Access the Python data fields

                        VideoModel videoModel = pythonData.getValue(VideoModel.class);
//                     String id = pythonData.child("id").getValue(String.class);
//                     String link = pythonData.child("link").getValue(String.class);
//                     String title = pythonData.child("Title").getValue(String.class);
//                     String description = pythonData.child("discription").getValue(String.class);
                        list.add(videoModel);
                        // Use the data as needed (e.g., display it in your app)
                        // Example: Log the Python data
//                     Log.d("PythonData", "ID: " + videoModel.getId() + ", Link: " + videoModel.getLink() + ", Title: " + videoModel.getTitle() + ", Description: " + videoModel.getDiscription());
                    }
                    adapterView = new PdfAdapter(list, Pdflist.this);
                    recyclerView.setAdapter(adapterView);
                    adapterView.setClickListner(new ItemClickListner() {
                        @Override
                        public void onCLick(View v, int pos) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setDataAndType(Uri.parse(list.get(pos).getLink()), "application/pdf");
                            startActivity(intent);
                        }
                    });


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle any errors that occur during the retrieval of data
                    Log.e("FirebaseError", "Error: " + databaseError.getMessage());
                }
            });
        }


        //-----------------------------------------------------------------------------------------------------------------------------------------------------

        //-----------------------------------------------------Operating System--------------------------------------------------------------------
        if(intent.getStringExtra("Name").equals("Operating System")) {

            databaseReference.child("Os pdf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    // Iterate through the children of the "python" node
                    for (DataSnapshot pythonData : dataSnapshot.getChildren()) {
                        // Access the Python data fields

                        VideoModel videoModel = pythonData.getValue(VideoModel.class);
//                     String id = pythonData.child("id").getValue(String.class);
//                     String link = pythonData.child("link").getValue(String.class);
//                     String title = pythonData.child("Title").getValue(String.class);
//                     String description = pythonData.child("discription").getValue(String.class);
                        list.add(videoModel);
                        // Use the data as needed (e.g., display it in your app)
                        // Example: Log the Python data
//                     Log.d("PythonData", "ID: " + videoModel.getId() + ", Link: " + videoModel.getLink() + ", Title: " + videoModel.getTitle() + ", Description: " + videoModel.getDiscription());
                    }
                    adapterView = new PdfAdapter(list, Pdflist.this);
                    recyclerView.setAdapter(adapterView);
                    adapterView.setClickListner(new ItemClickListner() {
                        @Override
                        public void onCLick(View v, int pos) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setDataAndType(Uri.parse(list.get(pos).getLink()), "application/pdf");
                            startActivity(intent);
                        }
                    });


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle any errors that occur during the retrieval of data
                    Log.e("FirebaseError", "Error: " + databaseError.getMessage());
                }
            });
        }


        //-----------------------------------------------------------------------------------------------------------------------------------------------------

        //-----------------------------------------------------Sql--------------------------------------------------------------------
        if(intent.getStringExtra("Name").equals("Sql")) {

            databaseReference.child("SQL pdf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    // Iterate through the children of the "python" node
                    for (DataSnapshot pythonData : dataSnapshot.getChildren()) {
                        // Access the Python data fields

                        VideoModel videoModel = pythonData.getValue(VideoModel.class);
//                     String id = pythonData.child("id").getValue(String.class);
//                     String link = pythonData.child("link").getValue(String.class);
//                     String title = pythonData.child("Title").getValue(String.class);
//                     String description = pythonData.child("discription").getValue(String.class);
                        list.add(videoModel);
                        // Use the data as needed (e.g., display it in your app)
                        // Example: Log the Python data
//                     Log.d("PythonData", "ID: " + videoModel.getId() + ", Link: " + videoModel.getLink() + ", Title: " + videoModel.getTitle() + ", Description: " + videoModel.getDiscription());
                    }
                    adapterView = new PdfAdapter(list, Pdflist.this);
                    recyclerView.setAdapter(adapterView);
                    adapterView.setClickListner(new ItemClickListner() {
                        @Override
                        public void onCLick(View v, int pos) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setDataAndType(Uri.parse(list.get(pos).getLink()), "application/pdf");
                            startActivity(intent);
                        }
                    });


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle any errors that occur during the retrieval of data
                    Log.e("FirebaseError", "Error: " + databaseError.getMessage());
                }
            });
        }


        //-----------------------------------------------------------------------------------------------------------------------------------------------------





        recyclerView.setLayoutManager(new LinearLayoutManager(this));












    }
}
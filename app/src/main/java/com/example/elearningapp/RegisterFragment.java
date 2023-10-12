package com.example.elearningapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ReportFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;


public class RegisterFragment extends Fragment {

    Button btn;
    private FirebaseAuth mAuth;
    View view;

    Random in = new Random();


    int[] images = {R.drawable.harry, R.drawable.hermine, R.drawable.ron, R.drawable.lupin, R.drawable.snape, R.drawable.draco, R.drawable.albusdd, R.drawable.snape, R.drawable.hedwig};
    EditText email, pass, name, mobileno;
    TextView regmi;

    FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_register, container, false);

        regmi = view.findViewById(R.id.regishipre);
        email = view.findViewById(R.id.email);
        pass = view.findViewById(R.id.passowrd);
        name = view.findViewById(R.id.name);
        mobileno = view.findViewById(R.id.mobile);
        mAuth = FirebaseAuth.getInstance();
        btn = view.findViewById(R.id.register);
        FragmentManager fm = getParentFragmentManager();
        FragmentTransaction fragTransc = fm.beginTransaction();
        fragTransc.replace(R.id.myFrame, new LoginFrag());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        int id = images[in.nextInt(images.length)];
                        createUserFirebase(email.getText().toString(), name.getText().toString(), mobileno.getText().toString(), pass.getText().toString(), id);

                        Toast.makeText(getActivity(), "Created Successfully", Toast.LENGTH_LONG).show();
                        fragTransc.commit();
                    }
                });
            }
        });

        regmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragTransc.commit();
            }


        });
        return view;
    }

    private void createUserFirebase(String email, String name, String mobile, String pass, int id) {
        String unique = mAuth.getUid();
        Long mobile1 = Long.parseLong(mobile);
        Student stud = new Student(email, name, pass, mobile1, id);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://elearning-app-e343a-default-rtdb.firebaseio.com/");
        DatabaseReference dbref = firebaseDatabase.getReference("StudentsData").child("Stud" + unique);
        dbref.setValue(stud).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

            }
        });


    }


    public void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(getActivity(), Courser.class));
                            getActivity().finish();
        }

    }
}
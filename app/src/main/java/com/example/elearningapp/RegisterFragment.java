package com.example.elearningapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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


public class RegisterFragment extends Fragment {

    Button btn;
    private FirebaseAuth mAuth;
    View view;

    EditText email,pass;
    TextView regmi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view=inflater.inflate(R.layout.fragment_register, container, false);

        regmi=view.findViewById(R.id.regishipre);
        email=view.findViewById(R.id.email);
        pass=view.findViewById(R.id.passowrd);
        mAuth=FirebaseAuth.getInstance();
        btn=view.findViewById(R.id.register);
        FragmentManager fm=getParentFragmentManager();
        FragmentTransaction fragTransc=fm.beginTransaction();
        fragTransc.replace(R.id.myFrame,new LoginFrag());

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                mAuth.createUserWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(getActivity(),"Created Successfully",Toast.LENGTH_LONG).show();
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
}
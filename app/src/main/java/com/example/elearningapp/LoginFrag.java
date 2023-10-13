package com.example.elearningapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginFrag extends Fragment {

    Button btn;
    View view;
    TextView loginmi;
    EditText emlog,logpassword;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);

        btn=view.findViewById(R.id.login);
        loginmi=view.findViewById(R.id.loginhiper);

        emlog=view.findViewById(R.id.loginuname);
        logpassword=view.findViewById(R.id.loginpass);

        mAuth=FirebaseAuth.getInstance();





        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (isValidEmail(emlog.getText().toString())&&(!emlog.getText().toString().isEmpty())) {

                    if (isValidPassword(logpassword.getText().toString()) && (!logpassword.getText().toString().isEmpty())) {

                        mAuth.signInWithEmailAndPassword(emlog.getText().toString(), logpassword.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                startActivity(new Intent(getActivity(), Courser.class));
                                Toast.makeText(getActivity(), "login Successfully", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getActivity(), "Sorry incorrect Email or Password", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    else {
                        Toast.makeText(getActivity(), "Password id Wrong or empty", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getActivity(), "Sorry Wrong Email or No Input", Toast.LENGTH_SHORT).show();
                }
            }

        });

        loginmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getParentFragmentManager();
                FragmentTransaction fragTransc=fm.beginTransaction();
                fragTransc.replace(R.id.myFrame,new RegisterFragment());
                fragTransc.commit();
            }
        });







        // Inflate the layout for this fragment
        return view;
    }


    public static boolean isValidEmail(String email) {
        String EMAIL_REGEX = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        String PASSWORD_REGEX = "^[a-zA-Z1-9]{6,}$";
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
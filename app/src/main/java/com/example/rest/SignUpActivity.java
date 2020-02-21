package com.example.rest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity {


    private TextView textView;
    private EditText signUpEmailEditText , signUpPasswordEditText ;
    private Button SigUpButton;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //remove the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //remove the title bar
        getWindow() .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.activity_sign_up);


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();



        //Find Progreeber
        progressBar =(ProgressBar) findViewById(R.id.SignUpProgressBer_Id);

        //find EditText Sign In
        signUpEmailEditText=(EditText) findViewById(R.id.SignUpEmailUserEditText_ID);
        signUpPasswordEditText=(EditText)findViewById(R.id.SignUpPasswordlUserEditText_ID);



        //find Button Sign In
        SigUpButton=(Button) findViewById(R.id.SignUpButtonUser_ID);


        //signup activity
        textView=(TextView) findViewById(R.id.SignInTextViewUserID);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SignUpActivity.this, UserLogin.class);
                startActivity(intent);
                finish();

            }
        });


        //Button Lisenner Add for next Activity And Registration Part
        SigUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SignUp Create a Function
                userRegister();

            }
        });



    }

    public void userRegister() {

        //input email passwor fron java class this

        String email =signUpEmailEditText.getText().toString().trim();
        String password =signUpPasswordEditText.getText().toString().trim();



        progressBar.setVisibility(View.VISIBLE);

        //checking the validity of the email
        if(email.isEmpty())
        {
            signUpEmailEditText.setError("Enter an email address");
            signUpEmailEditText.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signUpEmailEditText.setError("Enter a valid email address");
            signUpEmailEditText.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            signUpPasswordEditText.setError("Enter a password");
            signUpPasswordEditText.requestFocus();
            return;
        }

        if (password.length()<6){
            signUpPasswordEditText.setError("Minimum lenth of a password should be 6");
            signUpPasswordEditText.requestFocus();
            return;
        }





        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {

                    Toast.makeText(getApplicationContext(),"Registred is succesful",Toast.LENGTH_SHORT).show();

                } else {

                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"User is already Registered",Toast.LENGTH_SHORT).show();
                    }else {

                        Toast.makeText(getApplicationContext(),"Registred is not succesful",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


    }
}

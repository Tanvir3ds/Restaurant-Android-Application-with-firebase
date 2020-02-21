package com.example.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {


    private ProgressBar progressBar;
    private int progress= 0;
    //private TextView textView;
    //private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //remove the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //remove the title bar
        getWindow() .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {

                doWork();
                startApp();
            }
        });
        thread.start();



    }

    public void doWork(){



        for (progress=1; progress<=10; progress=progress+1){
            try {
                Thread.sleep(90);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void startApp(){

        Intent intent = new Intent(MainActivity.this, UserLogin.class);
        startActivity(intent);
        finish();
    }



}

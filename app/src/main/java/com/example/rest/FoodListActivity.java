package com.example.rest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class FoodListActivity extends AppCompatActivity {

    private RelativeLayout BurgerLayout, PizzaLayout, FastFoodLayout;


    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Foods");
        setContentView(R.layout.activity_food_list);

        mAuth= FirebaseAuth.getInstance();

        //Burger Layout..................................................................................................................
        BurgerLayout=findViewById(R.id.burgerLayoutId);
        BurgerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), BurgerActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"i m burger activity", Toast.LENGTH_SHORT).show();
            }
        });





        //Pizza Layout.....................................................................................................................
        PizzaLayout=findViewById(R.id.pizzaLayoutId);
        PizzaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), PizzaActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"i m pizza activity", Toast.LENGTH_SHORT).show();
            }
        });





        //Fast Food Layout...............................................................................................................
        FastFoodLayout=findViewById(R.id.fastFoodLayoutId);
        FastFoodLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), FastFoodActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"i m fast food activity", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);






    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.signOutMenu_Id){
            FirebaseAuth.getInstance().signOut();
            finish();

            Intent intent = new Intent(getApplicationContext(), UserLogin.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}

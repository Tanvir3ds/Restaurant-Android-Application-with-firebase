package com.example.rest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FastFoodActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<ModelClass> modelClassList;

    DatabaseReference databaseReference;

    Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Fast Foods");
        setContentView(R.layout.activity_fast_food);


        recyclerView=findViewById(R.id.BurgerRecyclerView_ID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        modelClassList= new ArrayList<>();
        databaseReference= FirebaseDatabase.getInstance().getReference("Food");
        query=databaseReference.orderByChild("foodType")
                .equalTo("Fast Food");


        ValueEventListener valueEventListener=(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                modelClassList.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    ModelClass modelClass = dataSnapshot1.getValue(ModelClass.class);

                    modelClassList.add(modelClass);
                }
                myAdapter= new MyAdapter(FastFoodActivity.this, modelClassList);
                recyclerView.setAdapter(myAdapter);




                //,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getApplicationContext()," Unsuccessful", Toast.LENGTH_SHORT).show();
            }
        });

        //databaseReference.addValueEventListener(valueEventListener);
        query.addListenerForSingleValueEvent(valueEventListener);

    }
}

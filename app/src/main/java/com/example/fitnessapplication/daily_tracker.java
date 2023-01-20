package com.example.fitnessapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class daily_tracker extends AppCompatActivity {
    final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    BottomNavigationView bottom_navigation;
    mealtime_model mealtimeModel  = new mealtime_model();
    CheckBox check1 ,check2 , check3;
    TextView txt1 ,txt2 ,txt3;
    Button clear_btn;
    private static final String TAG = "daily_tracker";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_tracker);
        bottom_navigation = findViewById(R.id.bottom_navigation_users);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);

        clear_btn = findViewById(R.id.clear_btn);
        bottom_navigation.setSelectedItemId(R.id.tracker_id);


        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home_id:
                        startActivity(new Intent(getApplicationContext(), home_page.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;

                    case R.id.nutrition_id:
                        startActivity(new Intent(getApplicationContext(), nutrition_page.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;

                    case R.id.tracker_id:

                        return true;

                    case R.id.profile_id:
                        startActivity(new Intent(getApplicationContext(), profile_page.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                }
                return false;
            }
        });

        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check1.isChecked()){

                        String breakfast = "Break fast is done";
                        mealtimeModel.setBreakfast(breakfast);
                        txt1.setText(breakfast);


                    FirebaseUser userID = mAuth.getCurrentUser();
                    mealtimeModel = new mealtime_model(mealtimeModel.getBreakfast(),mealtimeModel.getLunch()
                            ,mealtimeModel.getDinner());

                    Log.d(TAG, "onCreate: " + mealtimeModel.getBreakfast());
                    db.collection("mealtime").document(userID.getUid())
                            .set(mealtimeModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                }
                            });
                }
                else {
                    String update = "haven't eaten yet";
                    txt1.setText(update);

                    FirebaseUser userID = mAuth.getCurrentUser();
                    mealtimeModel = new mealtime_model(mealtimeModel.getBreakfast(),mealtimeModel.getLunch()
                            ,mealtimeModel.getDinner());

                    Log.d(TAG, "onCreate: " + mealtimeModel.getBreakfast());
                    db.collection("mealtime").document(userID.getUid())
                            .set(mealtimeModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                }
                            });

                }
            }
        });

        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check2.isChecked()){

                    String lunch = "Lunch is done";
                    mealtimeModel.setLunch(lunch);
                    txt2.setText(lunch);


                    FirebaseUser userID = mAuth.getCurrentUser();
                    mealtimeModel = new mealtime_model(mealtimeModel.getBreakfast(),mealtimeModel.getLunch()
                            ,mealtimeModel.getDinner());

                    Log.d(TAG, "onCreate: " + mealtimeModel.getBreakfast());
                    db.collection("mealtime").document(userID.getUid())
                            .set(mealtimeModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                }
                            });
                }
                else {
                    String update = "haven't eaten yet";
                    txt2.setText(update);
                    FirebaseUser userID = mAuth.getCurrentUser();
                    mealtimeModel = new mealtime_model(mealtimeModel.getBreakfast(),mealtimeModel.getLunch()
                            ,mealtimeModel.getDinner());

                    Log.d(TAG, "onCreate: " + mealtimeModel.getBreakfast());
                    db.collection("mealtime").document(userID.getUid())
                            .set(mealtimeModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                }
                            });

                }
            }
        });
        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check3.isChecked()){

                    String dinner = "Dinner is done";
                    mealtimeModel.setDinner(dinner);
                    txt3.setText(dinner);


                    FirebaseUser userID = mAuth.getCurrentUser();
                    mealtimeModel = new mealtime_model(mealtimeModel.getBreakfast(),mealtimeModel.getLunch()
                            ,mealtimeModel.getDinner());

                    Log.d(TAG, "onCreate: " + mealtimeModel.getBreakfast());
                    db.collection("mealtime").document(userID.getUid())
                            .set(mealtimeModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                }
                            });
                }
                else {

                    String update = "haven't eaten yet";
                    txt3.setText(update);
                    FirebaseUser userID = mAuth.getCurrentUser();
                    mealtimeModel = new mealtime_model(mealtimeModel.getBreakfast(),mealtimeModel.getLunch()
                            ,mealtimeModel.getDinner());

                    Log.d(TAG, "onCreate: " + mealtimeModel.getBreakfast());
                    db.collection("mealtime").document(userID.getUid())
                            .set(mealtimeModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                }
                            });

                }
            }
        });


        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser userID = mAuth.getCurrentUser();

                db.collection("mealtime").document(userID.getUid())
                        .delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                                txt1.setText("-----------");
                                txt2.setText("-----------");
                                txt3.setText("-----------");
                                Toast.makeText(daily_tracker.this, "record Cleared", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}
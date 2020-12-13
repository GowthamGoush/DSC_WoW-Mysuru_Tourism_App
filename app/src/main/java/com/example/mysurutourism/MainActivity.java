package com.example.mysurutourism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        logo = findViewById(R.id.logo);

        logo.animate().alpha(0f).rotationY(180f).setDuration(0).start();
        logo.animate().alpha(0.9f).rotationYBy(180f).setDuration(1500).start();

        CountDownTimer countDownTimer = new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        }.start();
/*
        FirebaseDatabase.getInstance().getReference().child("Slider Image Data").addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                            imageData.add(new SlideModel(dataSnapshot.child("url").getValue().toString(),dataSnapshot.child("title").getValue().toString(), ScaleTypes.FIT));
                        }

                        imageSlider.setImageList(imageData,ScaleTypes.FIT);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );

 */




    }
}
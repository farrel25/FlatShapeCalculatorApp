package com.farrel.corporation.flatshapecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setTitle("Home");
        }
    }


    public void moveToShapeCalculator(View view) {
        switch (view.getId()) {
            case R.id.btn_rectangle :
                Intent rectangleAct = new Intent(MainActivity.this,RectangleActivity.class);
                startActivity(rectangleAct);
                break;
            case R.id.btn_triangle :
                Intent triangleAct = new Intent(MainActivity.this,TriangleActivity.class);
                startActivity(triangleAct);
                break;
            case R.id.btn_circle :
                Intent circleAct = new Intent(MainActivity.this,CircleActivity.class);
                startActivity(circleAct);
                break;
        }
    }
}
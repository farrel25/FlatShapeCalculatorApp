package com.farrel.corporation.flatshapecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class TriangleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setTitle("Triangle");
        }
    }

    public void calctriangleAreaPerimeter(View view) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shape_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_home :
                Intent homeAct = new Intent(TriangleActivity.this, MainActivity.class);
                startActivity(homeAct);
                break;
            case R.id.menu_rectangle :
                Intent rectangleAct = new Intent(TriangleActivity.this, RectangleActivity.class);
                startActivity(rectangleAct);
                break;
            case R.id.menu_triangle :
                Toast.makeText(TriangleActivity.this, "You are still in the triangle page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_circle :
                Intent circleAct = new Intent(TriangleActivity.this, CircleActivity.class);
                startActivity(circleAct);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
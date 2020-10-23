package com.farrel.corporation.flatshapecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CircleActivity extends AppCompatActivity {

    private EditText etRadius;
    private TextView tvPerimeterResult;
    private TextView tvAreaResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setTitle("Circle");
        }

        etRadius = (EditText) findViewById(R.id.et_input_number);
        tvPerimeterResult = (TextView) findViewById(R.id.result_perimeter_value);
        tvAreaResult = (TextView) findViewById(R.id.result_area_value);

    }

    public void calcCircleAreaPerimeter(View view) {
        if (view.getId() == R.id.btn_calculate_circle) {

            String inputRadius = etRadius.getText().toString().trim();
            boolean isEmptyField = false;

            if (TextUtils.isEmpty(inputRadius)) {
                isEmptyField = true;
                etRadius.setError("This field must be filled");
            }

            if (!isEmptyField) {
                Double radius = Double.valueOf(inputRadius);

                double perimeter = 2 * Math.PI * radius;
                double area = Math.PI * Math.pow(radius, 2);

                tvPerimeterResult.setText(String.valueOf(perimeter));
                tvAreaResult.setText(String.valueOf(area));
            }
        }
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
                Intent homeAct = new Intent(CircleActivity.this, MainActivity.class);
                startActivity(homeAct);
                break;
            case R.id.menu_rectangle :
                Intent rectangleAct = new Intent(CircleActivity.this, RectangleActivity.class);
                startActivity(rectangleAct);
                break;
//            case R.id.menu_triangle :
//                Intent triangleAct = new Intent(CircleActivity.this, TriangleActivity.class);
//                startActivity(triangleAct);
//                break;
            case R.id.menu_circle :
                Toast.makeText(CircleActivity.this, "You are still in the circle page", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
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

import java.text.DecimalFormat;

public class TriangleActivity extends AppCompatActivity {

    private EditText etSideLenght;
    private TextView tvPerimeter, tvArea;
    private static final String STATE_RESULT_1 = "state_result_1";
    private static final String STATE_RESULT_2 = "state_result_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setTitle("Equilateral Triangle");
        }

        etSideLenght = (EditText) findViewById(R.id.et_input_number);
        tvPerimeter = (TextView) findViewById(R.id.result_perimeter_value);
        tvArea = (TextView) findViewById(R.id.result_area_value);

        if (savedInstanceState != null) {
            String resultPerimeter = savedInstanceState.getString(STATE_RESULT_1);
            String resultArea = savedInstanceState.getString(STATE_RESULT_2);
            tvPerimeter.setText(resultPerimeter);
            tvArea.setText(resultArea);
        }

    }

    public void calcTriangleAreaPerimeter(View view) {
        if (view.getId() == R.id.btn_calculate_triangle) {
            String inputSideLength = etSideLenght.getText().toString().trim();
            if(TextUtils.isEmpty(inputSideLength)) {
                etSideLenght.setError("This field must be filled");
            } else {
                Double sideLength = toDouble(inputSideLength);
                if (sideLength == null) {
                    etSideLenght.setError("This field must be a number");
                } else {
                    double perimeter = sideLength * 3;
                    double height = Math.sqrt(Math.pow(sideLength, 2) - Math.pow(sideLength/2, 2));
                    double area = 0.5 * sideLength * height;

//                    tvPerimeter.setText(String.valueOf(perimeter));
//                    tvArea.setText(String.valueOf(area));

                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    tvPerimeter.setText(decimalFormat.format(perimeter));
                    tvArea.setText(decimalFormat.format(area));
                }
            }
        }
    }

    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void resetCalculation(View view) {
        etSideLenght.setText("");
        tvPerimeter.setText("...");
        tvArea.setText("...");
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT_1, tvPerimeter.getText().toString());
        outState.putString(STATE_RESULT_2, tvArea.getText().toString());
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
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

public class RectangleActivity extends AppCompatActivity {

    private EditText etSideLength;
    private TextView tvPerimeterResult;
    private TextView tvAreaResult;
    private static final String STATE_RESULT_1 = "state_result_1";
    private static final String STATE_RESULT_2 = "state_result_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setTitle(R.string.title_rectangle);
        }

        etSideLength = (EditText) findViewById(R.id.et_input_number);
        tvPerimeterResult = (TextView) findViewById(R.id.result_perimeter_value);
        tvAreaResult = (TextView) findViewById(R.id.result_area_value);

        if (savedInstanceState != null) {
            String resultPerimeter = savedInstanceState.getString(STATE_RESULT_1);
            String resultArea = savedInstanceState.getString(STATE_RESULT_2);
            tvPerimeterResult.setText(resultPerimeter);
            tvAreaResult.setText(resultArea);
        }

    }

    public void calcRectangleAreaPerimeter(View view) {
        if (view.getId() == R.id.btn_calculate_rectangle) {
            String inputSideLength = etSideLength.getText().toString().trim();
            if (TextUtils.isEmpty(inputSideLength)) {
                etSideLength.setError("This field must be filled");
            } else {
                Double sideLength = toDouble(inputSideLength);
                if (sideLength == null) {
                    etSideLength.setError("This field must be a number");
                } else {
                    double perimeter = sideLength * 4;
                    double area = Math.pow(sideLength, 2);

//                    tvPerimeterResult.setText(String.valueOf(perimeter));
//                    tvAreaResult.setText(String.valueOf(area));

                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    tvPerimeterResult.setText(decimalFormat.format(perimeter));
                    tvAreaResult.setText(decimalFormat.format(area));
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
        etSideLength.setText("");
        tvPerimeterResult.setText("...");
        tvAreaResult.setText("...");
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT_1, tvPerimeterResult.getText().toString());
        outState.putString(STATE_RESULT_2, tvAreaResult.getText().toString());
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
                Intent homeAct = new Intent(RectangleActivity.this, MainActivity.class);
                startActivity(homeAct);
                break;
            case R.id.menu_rectangle :
                Toast.makeText(RectangleActivity.this, "You are still in the rectangle page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_triangle :
                Intent triangleAct = new Intent(RectangleActivity.this, TriangleActivity.class);
                startActivity(triangleAct);
                break;
            case R.id.menu_circle :
                Intent circleAct = new Intent(RectangleActivity.this, CircleActivity.class);
                startActivity(circleAct);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
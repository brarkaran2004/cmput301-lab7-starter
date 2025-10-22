package com.example.androiduitesting;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivityTest extends AppCompatActivity {

    private EditText editTextName;
    private Button buttonAdd, buttonClear, buttonConfirm;
    private ListView cityListView;

    private ArrayList<String> cityList;
    private ArrayAdapter<String> cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editText_name);
        buttonAdd = findViewById(R.id.button_add);
        buttonClear = findViewById(R.id.button_clear);
        buttonConfirm = findViewById(R.id.button_confirm);
        cityListView = findViewById(R.id.city_list);

        cityList = new ArrayList<>();
        cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cityList);
        cityListView.setAdapter(cityAdapter);

        // when Add button clicked
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextName.setVisibility(View.VISIBLE);
                buttonConfirm.setVisibility(View.VISIBLE);
            }
        });

        // when Confirm button clicked
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = editTextName.getText().toString();
                if (!cityName.isEmpty()) {
                    cityList.add(cityName);
                    cityAdapter.notifyDataSetChanged();
                    editTextName.setText("");
                }
                editTextName.setVisibility(View.GONE);
                buttonConfirm.setVisibility(View.GONE);
            }
        });

        // when Clear All button clicked
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityList.clear();
                cityAdapter.notifyDataSetChanged();
            }
        });
    }
}

package com.gridmultiselectdemo;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private Button btnGo;
    private List<String> selectedStrings;
    private static final String[] numbers = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGo = (Button) findViewById(R.id.btnGo);
        init();
    }

    public void init() {
        selectedStrings = new ArrayList<>();

        gridView = (GridView) findViewById(R.id.grid);

        final GridViewAdapter adapter = new GridViewAdapter(Arrays.asList(numbers), this);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selectedIndex = adapter.selectedPosition.indexOf(position);
                if (selectedIndex > -1) {
                    adapter.selectedPosition.remove(selectedIndex);
                    ((GridItemView) view).display(false);
                    selectedStrings.remove((String) parent.getItemAtPosition(position));
                } else {
                    adapter.selectedPosition.add(position);
                    ((GridItemView) view).display(true);
                    selectedStrings.add((String) parent.getItemAtPosition(position));
                    /**
                     * logic for image gallery, need to keep a boolean
                     * which will be true after a long press click listener
                     * then it will display(true) and add that item( i.e. getItemAtPosition(position))
                     * in its respective resultList.
                     */
                }
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putStringArrayListExtra(getString(R.string.intentResult), (ArrayList<String>) selectedStrings);
                startActivity(intent);
            }
        });
    }
}
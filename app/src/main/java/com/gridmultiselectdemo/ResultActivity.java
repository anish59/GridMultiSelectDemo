package com.gridmultiselectdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
    TextView txtResult;
    List<String> resultList;
    String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtResult = (TextView) findViewById(R.id.txtResult);

        resultList = new ArrayList<>();
        resultList = getIntent().getStringArrayListExtra(getString(R.string.intentResult));

        for (String s : resultList) {
            msg = msg + "," + s;
        }
        txtResult.setText(msg);
    }
}

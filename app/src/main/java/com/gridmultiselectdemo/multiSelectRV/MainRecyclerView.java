package com.gridmultiselectdemo.multiSelectRV;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gridmultiselectdemo.R;
import com.gridmultiselectdemo.multiSelectRV.model.DemoModel;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerView extends AppCompatActivity {
    private Context context = MainRecyclerView.this;
    private List<DemoModel> demoModels;
    private DemoModel demoModel;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.rvMain);
        init();

    }

    private void init() {
        initAdapter();
        getDummydata();
    }

    private void initAdapter() {
        mAdapter = new RecyclerViewAdapter(getDummydata(), context, new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, View view) {
                if (demoModels.get(position).getSelected()) {
                    demoModels.get(position).setSelected(false);
                } else {
                    demoModels.get(position).setSelected(true);
                }
                view.setBackgroundColor(demoModels.get(position).getSelected() ? Color.CYAN : Color.WHITE);
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setAdapter(mAdapter);
    }

    private List<DemoModel> getDummydata() {
        demoModels = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            demoModels.add(new DemoModel("UserName" + String.valueOf(i), false));
        }
        return demoModels;
    }


}

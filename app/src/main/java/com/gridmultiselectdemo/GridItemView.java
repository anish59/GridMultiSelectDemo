package com.gridmultiselectdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by ANISH on 21-04-2017.
 */

public class GridItemView extends FrameLayout {
    private TextView tv;

    public GridItemView(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.item_image, this);
        tv = (TextView) findViewById(R.id.edtText);
    }

    public void display(String text, boolean isSelected) {
        tv.setText(text);
        display(isSelected);
    }

    public void display(boolean isSelected) {
        tv.setBackgroundResource(isSelected ? R.drawable.green_square : R.drawable.grey_square);
    }
}

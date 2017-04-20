package com.gridmultiselectdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANISH on 21-04-2017.
 */

public class GridViewAdapter extends BaseAdapter {
    List<String> stringList;
    Context context;
    public List selectedPosition; //keep it public

    public GridViewAdapter(List<String> stringList, Context context) {
        this.stringList = stringList;
        this.context = context;

        selectedPosition = new ArrayList();
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int i) {
        return stringList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        GridItemView customView = (view == null) ? new GridItemView(context) : (GridItemView) view;
        customView.display(stringList.get(i), selectedPosition.contains(i));

        return customView;
    }
}

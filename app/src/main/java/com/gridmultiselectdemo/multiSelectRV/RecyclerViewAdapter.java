package com.gridmultiselectdemo.multiSelectRV;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gridmultiselectdemo.R;
import com.gridmultiselectdemo.multiSelectRV.model.DemoModel;

import java.util.List;

/**
 * Created by anish on 21-04-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<DemoModel> demoModels;
    private Context context;
    private OnItemClickListener onItemClickListener;

    LinearLayout layoutItem;

    public RecyclerViewAdapter(List<DemoModel> demoModels, Context context, OnItemClickListener onItemClickListener) {
        this.demoModels = demoModels;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_selection,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final DemoModel model = demoModels.get(position);
        holder.txtItemName.setText(model.getName());
        holder.view.setBackgroundColor(model.getSelected() ? Color.CYAN : Color.WHITE);
        holder.txtItemName.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(position,v);
            }
        });
       /* holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setSelected(!model.isSelected());
                holder.view.setBackgroundColor(model.isSelected() ? Color.CYAN : Color.WHITE);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return demoModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private TextView txtItemName;


        private MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            txtItemName = (TextView) itemView.findViewById(R.id.txtItemName);
            layoutItem=(LinearLayout)itemView.findViewById(R.id.layoutItem);
        }
    }

    public interface OnItemClickListener {
        void onClick(int position,View view);
    }
}

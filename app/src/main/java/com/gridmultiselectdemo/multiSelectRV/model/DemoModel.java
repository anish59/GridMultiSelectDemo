package com.gridmultiselectdemo.multiSelectRV.model;

/**
 * Created by anish on 21-04-2017.
 */

public class DemoModel {
    private String name;
    public Boolean isSelected;

    public DemoModel(String name, Boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }
}

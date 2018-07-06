package com.kaitechconsulting.todolist;

import android.util.Log;

import java.util.ArrayList;

public class CheckListArrayList extends ArrayList <CheckListItem> {
    private static final String TAG = CheckListArrayList.class.getSimpleName();
    public CheckListArrayList() {
        Log.d(TAG, "Great");
    }

    // this method should return an arraylist of the text objects in the text section of each row in the list view
    public ArrayList <String> getTextInListViewRows() {

        ArrayList <String> stringArrayList = new ArrayList<String>();

        for(CheckListItem item : this){
            stringArrayList.add(item.getRowText());
        }

        return stringArrayList;
    }

    public ArrayList <Integer> getIconsForListViewRows() {

        ArrayList <Integer> iconIdArrayList = new ArrayList<Integer>();

        for(CheckListItem item : this){
            iconIdArrayList.add(item.getIntegerIdForCheckedIcon());
        }

        return iconIdArrayList;
    }

    public void addItem(String itemDescription){
        CheckListItem item = new CheckListItem(false, itemDescription);
        this.add(item);
    }

}


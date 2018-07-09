package com.kaitechconsulting.todolist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CustomCheckListAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList <String> checkListItemsArrayList;
    private ArrayList <Integer> iconIdArrayList;


    public CustomCheckListAdapter(@NonNull Activity context, ArrayList <String> checkListItemsArrayList, ArrayList <Integer> iconIdArrayList) {
        super(context, R.layout.list_view_layout, checkListItemsArrayList);
        this.context = context;
        this.checkListItemsArrayList = checkListItemsArrayList;
        this.iconIdArrayList = iconIdArrayList;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.list_view_layout, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.textInput);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.checkboxIcon);

        titleText.setText(this.checkListItemsArrayList.get(position));
        imageView.setImageResource(this.iconIdArrayList.get(position));

        return rowView;

    }

    public void addToList(CheckListItem item){
        Log.d("CustomCheckListAdapter", "Hi My name is Dami");
        checkListItemsArrayList.add(item.getRowText());
        iconIdArrayList.add(item.getIntegerIdForCheckedIcon());
        this.notifyDataSetChanged();
    }

    public void removeFromList(int index) {
        checkListItemsArrayList.remove(index);
        iconIdArrayList.remove(index);
        this.notifyDataSetChanged();
    }

    public void editListItem(int index, String newInput) {
        checkListItemsArrayList.set(index, newInput);
        this.notifyDataSetChanged();

    }

}


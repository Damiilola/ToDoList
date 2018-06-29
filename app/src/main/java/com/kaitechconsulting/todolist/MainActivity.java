package com.kaitechconsulting.todolist;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AlertDialogFragment.OnDoneButtonTappedListener {

    private ArrayList<String> itemsToDo;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private AlertDialogFragment ald;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsToDo = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, itemsToDo);
        listView = findViewById(R.id.toDoListView);

        listView.setAdapter(adapter);
        //getting the user's input from the alert dialog fragment class
        itemsToDo.add("First Item");


        //code for enabling the floatingActionBar
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when the fab is clicked, an editable text fragment is opened
                addItemToListDialog();
            }
        });
    }

    private void addItemToListDialog() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "TAG");
    }

    @Override
    public void onTaskEntryComplete(String taskInput) {
        itemsToDo.add(taskInput);
    }


    //if there's an item on the todo list, put a checkbox next to it
}


package com.kaitechconsulting.todolist;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity implements AlertDialogFragment.OnDoneButtonTappedListener {

    private CheckListArrayList itemsToDo;
    private CustomCheckListAdapter adapter;
    private ListView listView;
    private AlertDialogFragment ald;
    private  CheckListItem checkListItem;
    private ContextMenu actionOptionMenu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsToDo = new CheckListArrayList();

        itemsToDo.addItem("FirstItem");
        itemsToDo.addItem("SecondItem");

        adapter = new CustomCheckListAdapter(this, itemsToDo.getTextInListViewRows(), itemsToDo.getIconsForListViewRows());

        listView = findViewById(R.id.toDoListView);
        listView.setAdapter(adapter);

        registerForContextMenu(this.listView);

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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.toDoListView) {
            AdapterView.AdapterContextMenuInfo info = ( AdapterView.AdapterContextMenuInfo) menuInfo;
            actionOptionMenu = menu;

            menu.setHeaderTitle("ToDo Task");

            menu.add(0,1, 0, "Edit Task");
            menu.add(0,2, 1, "Delete Task");

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        int chosenMenuItemIndex = item.getOrder();
        switch (chosenMenuItemIndex) {
            //for the edit option
            case 0:

            //for the delete option
            case 1:
                removeItemFromCheckListArrayUsingIndex(index);

            default:

        }
        return true;
    }

    private void addItemToListDialog() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "TAG");
    }

    @Override
    public void onTaskEntryComplete(String taskInput) {
        CheckListItem itemToBeAdded = new CheckListItem(taskInput);
        adapter.addToList(itemToBeAdded);
    }

    public void removeItemFromCheckListArrayUsingIndex(int index) {
        adapter.removeFromList(index);
    }

}


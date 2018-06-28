package com.kaitechconsulting.todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder todoTaskBuilder = new AlertDialog.Builder(getActivity());
        final EditText input = new EditText(getActivity());

        todoTaskBuilder.setTitle("Add a new task")
                .setView(input)
                //put an option for ok and cancel in the alert dialog
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // when done is tapped, save the typed item to the list
                        // hidden text in the edit text space -- describe your task.
                        String taskInput = input.getText().toString();
                    }
                })
                //when cancel is selected go back to the list view and do nothing
                .setNegativeButton("Cancel", null);



        return todoTaskBuilder.create();
    }

}

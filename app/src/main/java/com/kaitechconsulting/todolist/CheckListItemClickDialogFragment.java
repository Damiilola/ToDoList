package com.kaitechconsulting.todolist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class CheckListItemClickDialogFragment extends DialogFragment {
    private CheckListItem checkListItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // inflating the layout for the dialog
        View view = inflater.inflate(R.layout.on_list_item_click_dialog, null);

        // this gets the arguments passed to this fragment. the selected item's position is the argument
        Bundle bundle = getArguments();

        // reference to the edittext view of the layout
        EditText editText = view.findViewById(R.id.textInputField);

        // setting the edittext to the current item clicked on listview

       editText.setText(getTextOnCheckListRow(bundle.getInt("position")));

       return view;
}

    public String getTextOnCheckListRow(int position) {
        return checkListItem.getRowText();
    }

    public int getIconOnCheckListRow(int position) {
        return checkListItem.getIntegerIdForCheckedIcon();
    }



}

package com.kaitechconsulting.todolist;

public class CheckListItem {
    private boolean isChecked;
    private String rowText;

    public CheckListItem(String rowText) {
        this.isChecked = false;
        this.rowText = rowText;
    }

    public CheckListItem(boolean isChecked, String rowText) {
        this.isChecked = isChecked;
        this.rowText = rowText;
    }

    public void setRowText(String rowText) {
        this.rowText = rowText;
    }

    public String getRowText() {
        return rowText;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public Integer getIntegerIdForCheckedIcon() {

        Integer iconToUseID = R.drawable.circle_unchecked;

        if (isChecked){
            iconToUseID = R.drawable.circle_checked;
        }

        return iconToUseID;
    }


}

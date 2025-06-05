package com.example;

public class Editor {
    public String text = "";
    private int selectionStart = -1;
    private int selectionEnd = -1;

    public String getSelection() {
        if (selectionStart >= 0 && selectionEnd > selectionStart) {
            return text.substring(selectionStart, selectionEnd);
        }
        return "";
    }

    public void setSelection(String target) {
        int index = text.indexOf(target);
        if (index != -1) {
            selectionStart = index;
            selectionEnd = index + target.length();
        } else {
            selectionStart = -1;
            selectionEnd = -1;
        }
    }

    public void deleteSelection() {
        if (selectionStart >= 0 && selectionEnd > selectionStart) {
            text = text.substring(0, selectionStart) + text.substring(selectionEnd);
            clearSelection();
        }
    }

    public void replaceSelection(String replacement) {
        if (selectionStart >= 0 && selectionEnd > selectionStart) {
            text = text.substring(0, selectionStart) + replacement + text.substring(selectionEnd);
            clearSelection();
        } else {
            text += replacement;
        }
    }

    private void clearSelection() {
        selectionStart = -1;
        selectionEnd = -1;
    }

    @Override
    public String toString() {
        return "Text: " + text;
    }
}

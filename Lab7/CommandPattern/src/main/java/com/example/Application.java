package com.example;

public class Application {
    public Editor[] editors;
    public Editor activeEditor;
    private String clipboard;
    private CommandHistory history = new CommandHistory();

    public void executeCommand(Command c) {
        if (c.execute()) {
            history.push(c);
        }
    }

    public void undo() {
        if(!history.isEmpty()) {
            Command last = history.pop();
            last.undo();
        }
    }

    public void setClipboard(String text) {
        this.clipboard = text;
    }

    public String getClipboard() {
        return clipboard;
    }
}

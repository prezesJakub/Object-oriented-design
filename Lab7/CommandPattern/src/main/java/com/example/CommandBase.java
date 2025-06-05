package com.example;

public abstract class CommandBase implements Command {
    protected Application app;
    protected Editor editor;
    private String backup;

    public CommandBase(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }

    protected void saveBackup() {
        backup = editor.text;
    }

    @Override
    public void undo() {
        editor.text = backup;
    }
}

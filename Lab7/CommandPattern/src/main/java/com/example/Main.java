package com.example;

public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        Editor editor = new Editor();
        editor.text = "Hello world!";
        editor.setSelection("world");

        app.editors = new Editor[]{editor};
        app.activeEditor = editor;

        app.executeCommand(new CopyCommand(app, editor));
        app.executeCommand(new CutCommand(app, editor));
        System.out.println("Po wycięciu: " + editor);

        app.executeCommand(new PasteCommand(app, editor));
        app.executeCommand(new PasteCommand(app, editor));
        System.out.println("Po wklejeniu: " + editor);

        app.executeCommand(new UndoCommand(app, editor));
        System.out.println("Po cofnięciu: " + editor);
    }
}
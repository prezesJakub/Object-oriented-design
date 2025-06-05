package com.example;

public interface Command {
    boolean execute();
    void undo();
}

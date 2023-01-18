package com.ob.exception;

public class ArrayIndexOutOfBounds extends Exception {

    int index = 8;
    String[] users = {"Ona", "Kai", "Koa", "Laia", "Nil", "Pol"};

    public String getUser() {
        return users[index];
    }
}

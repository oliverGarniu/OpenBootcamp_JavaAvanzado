package com.ob.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileNotFound extends Exception {

    public InputStream getFile() throws FileNotFoundException {
        return new FileInputStream("file.txt");
    }
}

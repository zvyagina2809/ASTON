package com.example.module_2;

public class FileOperationException extends Exception{

    public FileOperationException(String message){
        super(message);
    }

    public FileOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}

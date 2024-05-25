package com.example.prac12;


public class FilePathStorage {
    public static String getFirstPath() {
        return firstPath;
    }

    public static void setFirstPath(String firstPath) {
        FilePathStorage.firstPath = firstPath;
    }

    public static String getSecondPath() {
        return secondPath;
    }

    public static void setSecondPath(String secondPath) {
        FilePathStorage.secondPath = secondPath;
    }

    private static String firstPath;
    private static String secondPath;

}

package com.company.W3.Loggers;
import java.io.*;

public class FileLogger extends PrintLogger {

    PrintWriter out;

    public FileLogger(File file)
    {
        try {
            out = new PrintWriter(new FileWriter(file, true), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void outputMessage(String s) {
        out.println(s);
    }
}
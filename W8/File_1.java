package com.company.W8;

import java.util.Scanner;
import java.io.*;

public class File_1 {

    public static void main(String[] args) {
        writeFile();
    }

    public static void writeFile()
    {
        Scanner in = new Scanner(System.in);
        String message;

        message = in.nextLine();

        try{
            File f = new File("message.txt");
            PrintWriter output = new PrintWriter(new FileOutputStream(f));

            if(!f.exists())
            {
                f.createNewFile();
            }

            output.print(message);
            output.close();
        }

        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}

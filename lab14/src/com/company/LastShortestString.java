package com.company;

import java.io.*;
import java.util.ArrayList;


public class LastShortestString {




    static  void  lastShortestString(String filinename,String filoutname) throws IOException {
        ArrayList<String> arrayStr;
        arrayStr = Reader(filinename);

        String answer = arrayStr.get(0);
        for (String i : arrayStr) {
            if (i.length() <= answer.length()) {
                answer = i;
            }
        }

        Writer(answer,filoutname);

    }

    static ArrayList<String> Reader(String filename) throws IOException {
        ArrayList<String> arrayString;
        try (

                FileInputStream fis = new FileInputStream(filename);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr)) {
            String str;
            arrayString = new ArrayList<>();

            while ((str = br.readLine()) != null) arrayString.add(str);
        }
        return arrayString;
    }

    //static void Printer(String filename) throws IOException {
    //    System.out.println(lastShortestString(filename).toString());

    //}
    static  void  Writer (String answer,String output) throws IOException{
        File file = new File(output);
        FileWriter fr = null;
        BufferedWriter br = null;
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            br.write(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

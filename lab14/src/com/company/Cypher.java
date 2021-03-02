package com.company;



import java.io.*;
import java.util.ArrayList;


public class Cypher {
    static void cypher(String inputfile, String outputfile, int key) throws IOException {
        ArrayList<Integer> bytes = Reader(inputfile);
        ArrayList<Integer> answer = new ArrayList <>();
        for (int i : bytes) {
            answer.add ((i + key) % 2);

        }
        Writer(outputfile, answer);
    }

    static ArrayList<Integer> Reader( String filename)  throws IOException {
        byte[] buf = new byte[512];
        ArrayList<Integer> array = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
            int readed;
            while ((readed = fileInputStream.read(buf)) != -1) {
                for (int i = 0; i < readed; i++) {
                    array.add((int)(buf[i]));
                }
            }

        }
        return array;

    }

    static void Writer(String filename, ArrayList<Integer> array) throws IOException {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File(filename));
            os.write(array.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

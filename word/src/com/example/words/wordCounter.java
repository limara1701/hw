package com.example.words;

import java.io.*;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.*;
import java.nio.file.Files;

public class wordCounter {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("littlewomen.txt");
        Scanner fileinput = new Scanner(file);
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> count = new ArrayList<Integer>();
        while (fileinput.hasNext()){
            String nextword = fileinput.next();
            if (words.contains(nextword)){
                int index = words.indexOf(nextword);
                count.set(index, count.get(index) +1);
            } else {
                words.add(nextword);
                count.add(1);
            }
        }
        fileinput.close();
        file.close();

        for (int i = 0; i<words.size(); i++){
            System.out.println(words.get(i) + " occured " + count.get(i) + " times");
        }



        String txt = "littlewomen.txt";
        try {
            Path src = FileSystems.getDefault().getPath(txt);
            Path temp = FileSystems.getDefault().getPath("tmp" + txt);
            FileReader reader = new FileReader(src.toFile());
            BufferedReader input = new BufferedReader(reader);
            FileWriter writer = new FileWriter(temp.toFile());
            BufferedWriter output = new BufferedWriter(writer);

            boolean content = false;
            int inChar;
            do {
                inChar = input.read();
                if (inChar != -1) {
                    char outChar = Character.toLowerCase((char) inChar);
                    output.write(outChar);
                } else
                    content = true;
            } while (!content);
            Files.delete(src);
            Files.move(temp, src);
        }catch (IOException | SecurityException se) {
            System.out.println("Error -- " + se.toString());
        }
    }
}

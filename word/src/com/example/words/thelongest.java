package com.example.words;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class thelongest {
    public static void main(String [ ] args) throws FileNotFoundException {
        new thelongest().getLongestWords();
    }

    public String getLongestWords() throws FileNotFoundException {

        String longestWord = "";
        String current;
        Scanner scan = new Scanner(new File("littlewomen.txt"));


        while (scan.hasNext()) {
            current = scan.next();
            if (current.length() > longestWord.length()) {
                longestWord = current;
            }

        }
        System.out.println("The longest word is:" +longestWord);
        longestWord.replaceAll("[^a-zA-Z ]", "").split("\\s+");
        return longestWord;

    }

}
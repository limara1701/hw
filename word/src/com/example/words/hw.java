package com.example.words;

import java.io.*;

public class hw {
    public static void main(String[] args) throws IOException {
        File text = new File("littlewomen.txt");
        FileInputStream fileinput = new FileInputStream(text);
        InputStreamReader input = new InputStreamReader(fileinput);
        BufferedReader reader = new BufferedReader(input);
        String line;
        int countWord = 0;
        int sentenceCount = 0;
        int characterCount = 0;
        int paragraphCount = 1;
        int whitespaceCount = 0;
        while((line = reader.readLine()) != null) {
            if(line.equals("")) {
                paragraphCount++;
            } else {
                characterCount += line.length();
                String[] wordList = line.split("\\s+");
                countWord += wordList.length;
                whitespaceCount += countWord -1;
                String[] sentenceList = line.split("[!?.:]+");
                sentenceCount += sentenceList.length;
            }
        }
        System.out.println("Number of paragraphs = " + paragraphCount);
        System.out.println("Word count = " + countWord);
        System.out.println("Number of characters = " + characterCount);
        System.out.println("Number of sentences = " + sentenceCount);
        System.out.println("Number of whitespaces = " + whitespaceCount);
    }
}

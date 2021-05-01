package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static final int ASCII_SIZE = 256;
    static char getMaxOccuringChar(String str)
    {
        int count[] = new int[ASCII_SIZE];
        int len = str.length();
        for (int i=0; i<len; i++)
            count[str.charAt(i)]++;
        int max = -1;
        char result = ' ';
        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String data = "";
        ArrayList<String> totalCharacters = new ArrayList<>();
        ArrayList<String> inputCharacters = new ArrayList<>();
        String result= "";

        try {
            File myObj = new File("day6.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                totalCharacters.add(myReader.nextLine());
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 0; i < totalCharacters.get(0).length(); i++) {
            for (String s : totalCharacters) {
                 data+=s.charAt(i);
            }
            inputCharacters.add(data);
            data = "";
        }

        for(String s : inputCharacters){
            result+=getMaxOccuringChar(s);
        }
        System.out.println(result);
    }}

package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException,IOException {
	// write your code here
        File file1= new File("dictionary.txt");
            Scanner scanner= new Scanner(file1);
            Scanner scanner1= new Scanner(System.in);
            String inputWord= scanner1.nextLine();
            int i=1;

            while((scanner.hasNext())){
                String word= scanner.nextLine();
                if(isAnagram(word,inputWord)){
                    System.out.println("Found anagram"+" "+ word);

                }
            }





    }

    static boolean isAnagram(String s1, String s2)
    {
        //Initially setting status as true

        boolean status = true;
        //checking the length
        if(s1.length() != s2.length())
        {
            status = false;
        }
        else
        {
            //Changing the case of characters of both cs1 and cs2 and converting them to char array

            char[] arrayS1 = s1.replaceAll("\\s", "").toLowerCase().toCharArray();

            char[] arrayS2 = s2.replaceAll("\\s", "").toLowerCase().toCharArray();

            //Sorting both arrayS1 and arrayS2

            Arrays.sort(arrayS1);

            Arrays.sort(arrayS2);

            //Checking whether arrayS1 and arrayS2 are equal

            status = Arrays.equals(arrayS1, arrayS2);
        }

        //Output

        if(status)
        {
            return  true;
        }
        else
        {
           return false;
        }
    }
}

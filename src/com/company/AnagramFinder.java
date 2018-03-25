package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnagramFinder {
    
    public static void main(String[] args) throws FileNotFoundException,IOException {
    	welcomeMessage();
    	List <String> wordList= new ArrayList<String>();
    	wordList=loadFile(args[0]);
    	takeInput(wordList);
        
    }
    
    private static void takeInput(List<String>wordList) {
    	while (true) {
        	System.out.println();
        	System.out.println();
            System.out.print("AnagramFinder> ");
            Scanner scanner2= new Scanner(System.in);
        	String inputWord = scanner2.nextLine();
        	 if ("exit".equals(inputWord)) {
        		scanner2.close();
             	System.exit(0); 
             }
        	 else {
        		 FindAnagramUsingSort(inputWord,wordList);
                 FindAnagramUsingSum(inputWord,wordList);
                 FindAnagramUsingCharacterCount(inputWord,wordList);

        	 } 
           
        }
    }
    
    private static ArrayList<String> loadFile(String args) throws FileNotFoundException {
    	long startTime= System.currentTimeMillis();
    	Scanner scanner = new Scanner(new File(args));
    	ArrayList<String> wordList = new ArrayList<String>();
    	while((scanner.hasNextLine())){
            wordList.add(scanner.nextLine());
            }
        
        scanner.close();
        long stopTime= System.currentTimeMillis();

        long endTime= stopTime-startTime;
        System.out.println("Dictionary Loaded in "+ endTime+"" +"milli seconds");
        
       return wordList;
    }
    
    private static void welcomeMessage() {
    	System.out.println("Welcome To Anagram Finder");
    	System.out.println();
    	System.out.println("-----------------------------------------------------------------");
    	
    }
    
    private static void FindAnagramUsingSort(String inputWord, List<String> list) {
    	System.out.println("============");
        System.out.println("Using Sort");
        long startTime= System.currentTimeMillis();
        for(int i=0; i<list.size();i++){
            String word= list.get(i);
            if(isAnagramUsingSort(word,inputWord)){
                System.out.println("Found anagram"+" "+ word);

            }
        }
        long stopTime= System.currentTimeMillis();

        long endTime= stopTime-startTime;
        System.out.println("Time to find all anagrams is "+ endTime+"" +"milli seconds");
        
    }
    private static void FindAnagramUsingSum(String inputWord, List<String> list) {
    	System.out.println("============");
        System.out.println("Using Sum");
        long startTime= System.currentTimeMillis();
        for(int i=0; i<list.size();i++){
            String word= list.get(i);
                if(isAnagramUsingSum(word,inputWord)){
                    System.out.println("Found anagram"+" "+ word);

                }
            }
        
        long stopTime= System.currentTimeMillis();
        long endTime= stopTime-startTime;
        System.out.println("Time to find all anagrams is "+ endTime+"" +"milli seconds");
        

    }

    private static void FindAnagramUsingCharacterCount(String inputWord, List<String> list) {
    	System.out.println("============");
        System.out.println("Using character count");
        long startTime= System.currentTimeMillis();
        
        for(int i=0; i<list.size();i++){
           
        	String word= list.get(i);
           
            if(isAnagramUsingCharacterCount(word,inputWord)){
                
            	System.out.println("Found anagram"+" "+ word);

            }
        }
        long stopTime= System.currentTimeMillis();

        long endTime= stopTime-startTime;
        
        System.out.println("Time to find all anagrams is "+ endTime+"" +"milli seconds");
        
    }

    static boolean isAnagramUsingSort(String s1, String s2)
    {
        //Initially setting status as true

        if(s1.equals(s2))
        	return true;
        //checking the length
        if(s1.length() != s2.length())
        	return false;
       
        else
        {
            //Changing the case of characters of both cs1 and cs2 and converting them to char array

            char[] arrayS1 = s1.replaceAll("\\s", "").toLowerCase().toCharArray();

            char[] arrayS2 = s2.replaceAll("\\s", "").toLowerCase().toCharArray();

            //Sorting both arrayS1 and arrayS2

            Arrays.sort(arrayS1);

            Arrays.sort(arrayS2);

            //Checking whether arrayS1 and arrayS2 are equal

            return Arrays.equals(arrayS1, arrayS2);
        }

        //Output

    }

    static boolean isAnagramUsingCharacterCount(String s1, String s2){
    	if(s1.equals(s2))
    		return false;
        if(s1.length()!=s2.length()){
            return false;
        }
        int[] letters= new int[128];
        String modifiedS1 = s1.replaceAll("\\s", "").toLowerCase();
        String modifiedS2 = s2.replaceAll("\\s", "").toLowerCase();
       // char[] arrayS2 = s2.replaceAll("\\s", "").toLowerCase().toCharArray();

        for (char c:modifiedS1.toCharArray()){
            //count each number of char in s
            letters[c]++;
        }
        for(int i=0;i<modifiedS2.length();i++){
            int c= (int)modifiedS2.charAt(i);
            letters[c]--;
            if(letters[c]<0){
                return false;
            }
        }
        return true;
    }

    static boolean isAnagramUsingSum(String s1, String s2) {
    	if(s1.equals(s2))
    		return false;
    	else if(s1.length()!=s2.length())
    		return false;
    	else {
    		 String modifiedS1 = s1.replaceAll("\\s", "").toLowerCase();
    	        String modifiedS2 = s2.replaceAll("\\s", "").toLowerCase();
    	        long sum1 = 0;
    	        long sum2 = 0;

    	        for (int i = 0; i < modifiedS1.length(); i++) {
    	            int c = (int) modifiedS1.charAt(i);
    	            sum1 += c;
    	        }

    	        for (int i = 0; i < modifiedS2.length(); i++) {
    	            int c = (int) modifiedS2.charAt(i);
    	            sum2 += c;
    	        }
    	        return sum1 == sum2;
    	}
       
    }
}

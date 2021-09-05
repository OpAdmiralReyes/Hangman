package com.company;

import java.util.Scanner;

public class Hangman {

    static Scanner input = new Scanner(System.in);
    private static String hangmanWord;
    static String endWord;
    static int numberLives = 6;
    static String guessLetter;
    static int letterIndex;
    static StringBuilder guessString = new StringBuilder("");


    public static void main(String[] args) {
       System.out.println("-------------------WELCOME TO HANGMAN-------------------");
       System.out.print("Enter Hangman word: ");
       hangmanWord = input.nextLine();
       endWord = hangmanWord;
       for(int i = 0; i < hangmanWord.length(); i++){
           guessString.append("-");
       }

       initialLayout();

       while (numberLives != 0 && guessString.indexOf("-") != -1){
           System.out.println("Word to solve: " + guessString);
           System.out.println("Guess a letter: ");
           if(!checkLetter()){
               numberLives--;
               switch(numberLives){
                   case 5:
                       fiveLives();
                       break;
                   case 4:
                       fourLives();
                       break;
                   case 3:
                       threeLives();
                       break;
                   case 2:
                       twoLives();
                       break;
                   case 1:
                       oneLife();
                       break;
               }
           }
           if(guessString.indexOf("-") == -1){
               System.out.println("The word was: " + endWord);
               System.out.println("-------------------YOU WIN-------------------");
         }
       }
       if(numberLives == 0 && guessString.indexOf("-") != -1){
           gameOver();
       }
    }

    public static boolean checkLetter(){
        guessLetter = input.nextLine();
        guessLetter.substring(0,1);
       if(hangmanWord.contains(guessLetter)) {
           while (hangmanWord.indexOf(guessLetter) != -1) {
               letterIndex = hangmanWord.indexOf(guessLetter);
               guessString.replace(letterIndex, letterIndex + 1, guessLetter);
                   hangmanWord = hangmanWord.replaceFirst(guessLetter, " ");
           }
           return true;
       } else {
           return false;
       }
    }

    public static void initialLayout(){
        System.out.println("          ------\n" +
                "         |      |\n" +
                "         |\n" +
                "         |\n" +
                "         |\n" +
                "         |\n" +
                "         |               Number of Lives: " + numberLives + "\n" +
                "         |\n" +
                "         ----------");
    }

    public static void fiveLives(){
        System.out.println("          ------\n" +
                "         |      |\n" +
                "         |      0\n" +
                "         |\n" +
                "         |\n" +
                "         |\n" +
                "         |               Number of Lives: " + numberLives + "\n" +
                "         |\n" +
                "         ----------");
    }

    public static void fourLives(){
        System.out.println("          ------\n" +
                "         |      |\n" +
                "         |      0\n" +
                "         |      +\n" +
                "         |      |\n" +
                "         |      |\n" +
                "         |               Number of Lives: " + numberLives + "\n" +
                "         |\n" +
                "         ----------");
    }

    public static void threeLives(){
        System.out.println("          ------\n" +
                "         |      |\n" +
                "         |      0\n" +
                "         |    /-+\n" +
                "         |      |\n" +
                "         |      |\n" +
                "         |               Number of Lives: " + numberLives + "\n" +
                "         |\n" +
                "         ----------");
    }

    public static void twoLives(){
        System.out.println("          ------\n" +
                "         |      |\n" +
                "         |      0\n" +
                "         |    /-+-/\n" +
                "         |      |\n" +
                "         |      |\n" +
                "         |               Number of Lives: " + numberLives + "\n" +
                "         |\n" +
                "         ----------");
    }

    public static void oneLife(){
        System.out.println("          ------\n" +
                "         |      |\n" +
                "         |      0\n" +
                "         |    /-+-/\n" +
                "         |      |\n" +
                "         |      |\n" +
                "         |     |         Number of Lives: " + numberLives + "\n" +
                "         |     |\n" +
                "         ----------");
    }

    public static void gameOver(){
        System.out.println("          ------\n" +
                "         |      |\n" +
                "         |      0\n" +
                "         |    /-+-/\n" +
                "         |      |\n" +
                "         |      |\n" +
                "         |     | |       Number of Lives: " + numberLives + "\n" +
                "         |     | |       The word was: " + endWord + "\n" +
                "         ----------");
        System.out.println("-------------------GAME OVER-------------------");
    }
}

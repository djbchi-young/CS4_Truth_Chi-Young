/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2_truth_chiyoung;
import java.util.Scanner;

/**
 *
 * @author TRUTH
 */
public class Ex2_Truth_ChiYoung {
    //variables used between multiple methods
    static int lowLimit = 1;
    static int highLimit = 10;
    static boolean gameFinished;
    static boolean playerWon;
    static int guessCount = 3;
    static boolean validMenuOption = true;
    
    static void changeSettings(){
        Scanner sc = new Scanner(System.in);
        //boolean for checking if inputs are valid
        boolean isValid = true;
        do{
        
        System.out.print("What is the lower limit of the random number? ");
        //creates a string variable to be parsed into an integer later
        String lowLimitInput = sc.nextLine();
        //checks if the input isn't empty
        if(lowLimitInput.length() > 0) {
            //checks if the input is an integer
            try {
                lowLimit = Integer.parseInt(lowLimitInput);
                isValid = true;}catch(NumberFormatException e) {
                isValid = false;
                System.out.println("Please input an integer.");}
            }else isValid = false;
        //runs if lower limit is valid
        if(isValid){
            System.out.print("What is the upper limit of the random number ? ");
            String highLimitInput = sc.nextLine();
        if(highLimitInput.length() > 0) {
            try {
                highLimit = Integer.parseInt(highLimitInput);
                isValid = true;}catch(NumberFormatException e) {
                isValid = false;
                System.out.println("Please input an integer.");}
            }else isValid = false;
        //checks if lower limit is greater than upperlimit
            if(lowLimit>=highLimit){
                isValid = false;
                System.out.println("Please input integers and input an upper limit that is greater than the lower limit.");
            }
        }
        //runs if 2 previous answers were valid
        if (isValid){System.out.print("How many guesses are allowed? ");
        String guessCountInput = sc.nextLine();
        if(lowLimitInput.length() > 0) {
            try {
                guessCount = Integer.parseInt(guessCountInput);
                //number of guesses should only be positive
                if(guessCount<=0){
                isValid = false;
                System.out.println("Please input a positive integer.");}
                else isValid = true;}catch(NumberFormatException e) {
                isValid = false;
                System.out.println("Please input a positive integer.");}
            }else isValid = false;
        //remove when finished testing!!
        //System.out.println(lowLimit);
        //System.out.println(highLimit);
        //System.out.println(guessCount);
        }
        }while(!isValid); //does it again when the 
    }
    static void playAgain(){
        Scanner sc = new Scanner(System.in);
        boolean isYesNo = true;
        boolean isYesNoTwo = true;
        do{ System.out.print("Play again (y/n)? ");
            String yesNo = sc.nextLine();
            switch(yesNo){
                case "y":
                    do{ System.out.print("Would you like to change the settings (y/n)? ");
                        String yesNoTwo = sc.nextLine();
                        switch(yesNoTwo){
                            case "y":
                                changeSettings();
                                break;
                            case "n":
                                startGame();
                            break;
                            default:
                                System.out.println("Please input either y or n");
                                isYesNoTwo = false;

                        }
        }while(!isYesNoTwo);
                    startGame();
                    break;
                case "n":
                    System.out.println("Thank you for playing!");
                    isYesNo = true;
                break;
                default:
                    System.out.println("Please input either y or n");
                    isYesNo = false;
                    
            }
        }while(!isYesNo);
    }
    static void checkNum(int playerAnswer, int correctAnswer, int playerGuessCount){
        //checks if player has enough guessses for the game to tell it to guess higher/lower
        if(playerGuessCount>0) {
        //checks if player guessed the correct number
            if(playerAnswer<correctAnswer){
                System.out.print("Guess higher! ");
            }
            else if(playerAnswer>correctAnswer){
                System.out.print("Guess lower! ");
            }
        }
        if(playerAnswer==correctAnswer){
                System.out.println("You got it!");
                gameFinished = true;
                playerWon = true;
        }
    }
    static void startGame(){
        Scanner sc = new Scanner(System.in);
        //resets the values
        gameFinished = false;
        playerWon = false;
        //chooses a random number
        int correctAnswer = (int) Math.floor(Math.random()*highLimit) + lowLimit;
        //remove when finished testing!!!
        //System.out.println("hint: answer is " + correctAnswer);
        //runs the game when player has guesses and game hasnt finished
        int playerGuessCount = guessCount;
        while(playerGuessCount>0 && !gameFinished){
            System.out.print("You have " + playerGuessCount + " guess(es) left. What is your guess? ");
            playerGuessCount-=1;
            int playerAnswer = Integer.parseInt(sc.nextLine());
            checkNum(playerAnswer, correctAnswer, playerGuessCount);
        }
        if(!playerWon){
        System.out.println("You lost...");
        }
        
        playAgain();
    }
    static void mainMenu(String answer){
            switch(answer){
                case "Start game" -> {
                    startGame();
                    validMenuOption = true;}
                case "Change settings" -> {
                    changeSettings();
                    validMenuOption = true;}
                case "End application" -> {
                    System.out.println("\nThank you for playing!");
                    validMenuOption = true;}
                default -> {
                    System.out.println("Please choose a valid input\n");
                    validMenuOption = false;}
            }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer;
           do{System.out.println("""
                                 Welcome to Higher or Lower! What will you do?
                                 -Start game
                                 -Change settings
                                 -End application""");
                answer = sc.nextLine();
                mainMenu(answer);
           }while("Change settings".equals(answer) || !validMenuOption);
            
    }
    
}

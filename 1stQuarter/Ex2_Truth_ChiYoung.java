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
        boolean isValid = true;
        do{
        System.out.print("What is the lower limit of the random number? ");
        lowLimit = Integer.parseInt(sc.nextLine());
        System.out.print("What is the upper limit of the random number ? ");
        highLimit = Integer.parseInt(sc.nextLine());
        if(lowLimit>=highLimit){
            isValid = false;
            System.out.println("Please input an upper limit that is greater than the lower limit.");
        }
        else{System.out.print("How many guesses are allowed? ");
        guessCount = Integer.parseInt(sc.nextLine());
        //remove when finished testing!!
        //System.out.println(lowLimit);
        //System.out.println(highLimit);
        //System.out.println(guessCount);
        isValid = true;}
        }while(!isValid);
    }
    static void playAgain(){
        Scanner sc = new Scanner(System.in);
        boolean isYesNo = true;
        do{ System.out.print("Play again (y/n)? ");
            String yesNo = sc.nextLine();
            switch(yesNo){
                case "y":
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

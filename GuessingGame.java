//Guessing Game
// File: ATGuessGame.java
/* Purpose: Create a guessing game that a user continues to play, guessing
 			a random number until they win, and can then choose to continue
			or quit playing.
*/

import java.util.Scanner; // program imports the Scanner from the library
import java.util.Random; // program imports Random number function generator 

public class ATGuessingGame
{
   public static void main(String[] args)
   {
	  int continueGame = 0;
	  int currGuesses = 0;
	  int bestGame = 0;
	  int totalGuesses = 0;
	  int totalGames = 0;
	  int gameRange;
	  char contCheck;
	  String cont;
	  Scanner userInput = new Scanner(System.in);
      Rules();
      
      // start of do/while loop
      do {
    	  System.out.println("What range would you like to play with?");
          gameRange = userInput.nextInt();
    	  currGuesses = playGame(gameRange);
    	  totalGuesses += currGuesses;
    	  if (bestGame == 0) {
    		  bestGame = currGuesses;
    	  }
    	  
    	  if (bestGame > currGuesses) {
    		  bestGame = currGuesses;
    	  }
    	  
    	  System.out.println("Do you want to play again?(Y or N)");
    	  cont = userInput.next();
    	  // sanitizes every user input to a lower case input
    	  contCheck = Character.toLowerCase(cont.charAt(0)); 
    	  // while loop runs if user entered word does not start with
    	  // either a y or n
    	  while(contCheck != 'n' && contCheck!='y') {
    		  System.out.println("The word you entered does not start with the letter Y or N");
    		  System.out.println("Please enter your answer again (Y or N): ");
    		  contCheck = userInput.next().charAt(0);
    	  }
    	  if(contCheck=='n') {
    		  continueGame =1;
    	  }
    	  else if(contCheck == 'y') {
    		  continueGame = 0;
    	  }
    	  totalGames++;
      }while(continueGame == 0);
      // end of do/while loop
      
      Stats(totalGuesses, bestGame, totalGames);
   } 
   
   // method that runs the main game loop, only runs for one game until the
   // player wins, returning amount of guesses before the user won
   public static int playGame(int gameRange)
   {
	  Random randNumber = new Random();
	  int  winningNumber = randNumber.nextInt(gameRange);
	  Scanner userInput = new Scanner(System.in);
	  System.out.println("I'm thinking of a number between 1 and "+gameRange+"...");
      int userGuess=0;
      int guessCounter = 0;
      // start of do/while loop
	  do {
		  System.out.println("Your guess is: ");
		  userGuess = userInput.nextInt();
		  
		  if(userGuess > winningNumber) {
			  System.out.println("Lower!");
		  }
		  else if(userGuess < winningNumber) {
			  System.out.println("Higher!");
		  }
		  guessCounter++;
		  
	  }while(userGuess != winningNumber);
	  // end of do/while loop
	  
	  if(guessCounter == 1) {
		  System.out.println("You guessed it in 1 try!");
		  return guessCounter;
	  }
	  
	  System.out.println("You guess it in "+ guessCounter +" guesses!");
	  return guessCounter;
	  
   } 
   
   // method that prints out the game's rules
   public static void Rules() 
   {
      System.out.printf("This program is a guessing game.%n"
      		+ "I will think of a number between 1 and the range you pick.");
      System.out.printf("%nYou are allowed to guess until you get the number correct.");
      System.out.printf("%nFor each guess, I will tell you if "
      		+ "the right answer is a higher or lower number than your guess.%n"); 
   } 
   
   // method that prints out the player's total stats across all games played
   public static void Stats(int totalGuesses, int bestGame, int totalGames)
   {
	   double guessesPerGame = (double)totalGuesses/(double)totalGames;
	   System.out.println("Total games: "+totalGames);
	   System.out.println("Total guesses: "+totalGuesses);
	   System.out.printf("Guesses/game: %.1f%n",guessesPerGame );
	   System.out.println("Best game: "+ bestGame);
   }
   
} 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Scanner;

/**
 *
 * @author oliverloye
 */
public class Prompter {
    private Game game;
    
    public Prompter(Game game) {
        this.game = game;
    }
    
    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        boolean isHit = false;
        boolean isAcceptable = false;
        
        do{
            System.out.print("Enter a letter:  ");
            String guessInput = scanner.nextLine();
            

            try {
                isHit = game.applyGuess(guessInput);
                isAcceptable = true;
            } catch(IllegalArgumentException iae) {
                System.out.printf("%s.   Please try again. %n",
                                    iae.getMessage());
            }
        } while(!isAcceptable);
        return isHit;
    }
    
    public void displayProgress() {
        System.out.printf("You have %d tries left to solve: %s%n", 
                            game.getRemainingTries(),
                            game.getCurrentProgress());
    }
    
    public void displayOutcome() {
        if(game.isWon()) {
            System.out.printf("Gratz, you won with %d tries remaining.%n",
                                game.getRemainingTries());
        } else {
            System.out.printf("Sorry! The correct answer was %s.  :( %n.",
                    game.getAnswer());
        }
    }
    
}

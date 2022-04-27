/*
 * @author: Sonadi Kannangara
 *
 * Description: This program will prompt the user to enter the bowling score of three different player for Game #1 and
 *              Game #2. Then, the program will store the entered scores in a two-dimensional array. Finally, calculate
 *              the average of each player and display the score of 2 games with the calculated average.
 */

package Arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BowlingScore {
    // Declare a 2 dimensional array
    static int[][] score = new int [Config.GAMES][Config.PLAYERS];
    // Declare an array with the name of the players
    public static String[] names = {"Sonadi", "Anne", "Tom"};

    /**
     * This method prompt the user to enter game scores for all 3 players.
     * Validate the entered scores and store the valid score in an array.
     */
    public static void scoreArray()
    {
        // Creating a scanner class
        Scanner bowling_score = new Scanner(System.in);
        // Looping to get the scores for Game 1 and Game 2
        for (int i = 0; i < Config.GAMES; i++)
        {
            // Looping to get the scores for 3 players
            for (int k = 0; k < Config.PLAYERS; k++)
            {
                boolean isValidInput; // sentinel variable
                // Validate the entered scores - do until isValidInput becomes false.
                do
                {
                    // Prompt the user to enter scores.
                    System.out.print("Please enter " + names[k] + "'s score for Game #" + (i+1) + ": ");
                    try
                    {
                        // Assign the entered score to the array
                        score[i][k] = bowling_score.nextInt();
                        isValidInput = true;
                        // Check the entered score is in the range of 0 and 300
                        if ((score[i][k] < Config.MINIMUM_SCORE) || (score[i][k] > Config.MAXIMUM_SCORE))
                        {
                            // If the score is not in the given range, display the error message
                            System.out.println("Invalid Input. Value between " + Config.MINIMUM_SCORE + " and " + Config.MAXIMUM_SCORE + " needed. Please try again.");
                            bowling_score.nextLine();
                            isValidInput = false;
                        }
                    }
                    // Check the entered value is integer
                    catch (InputMismatchException inputMismatchException)
                    {
                        // If the entered score is not an integer, display the error message.
                        System.out.println("Invalid Input. Numeric value needed. Please try again.");
                        bowling_score.nextLine();
                        isValidInput = false;
                    }
                }
                while (!isValidInput);
                System.out.println();
            }
        }
    }

    /**
     * This method calculates the average of each player and display the game 1 and game 2 score with the calculated average
     */
    public static void printScore()
    {
        // Output banner
        System.out.println("\n************** OUTPUT **************");
        // Calculating average by looping through the array values and display the result.
        for(int j = 0; j < Config.PLAYERS; j++)
        {
            float average;
            int total = 0;
            System.out.println("Score Details for " + names[j]);
            for (int i = 0; i < Config.GAMES; i++)
            {
                // Display the game score of the player
                System.out.println("Game #" + (i+1) + ": " +score[i][j]);
                // Incrementing total by adding the game score of the player
                total += score[i][j];
            }
            // Calculate the average
            average = (float) total / Config.GAMES;
            // Display the average
            System.out.println("Average for " + names[j] + ": "  + average);
            // Display a new line
            System.out.println();
        }
    }

    /**
     * This method calls the scoreArray function to get the user inputs and printScore function to display the result.
     * @param args string array
     */
    public static void main(String[] args)
    {
        scoreArray();
        printScore();
    }

}


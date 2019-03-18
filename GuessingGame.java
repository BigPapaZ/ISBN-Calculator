
/**
 * GuessingGame.java
 * The program makes the user guess a number from between 1 and 100
 * Part of HWK1 problem 2.
 */

//Importing the stuff required
import java.util.Random;
import java.util.Scanner;
import java.lang.Integer;


/**
 * This class ISBNGuessingGame is supposed to carry out all the operations required for this .java file
 *
 *  @param Input numbers between 1 and 100 until the right one is guessed (taken in with the help of a scanner obj
 * 
 *  @return None
 */

public class GuessingGame
{
    public static void gemini()
    {

	 //Generating the random number to be guessed
         Random rom = new Random();
         int  Number = rom.nextInt(100) + 1;
         

	 //To keep track of the number of attempts
         int acc=0;
         

	 //Creating the scanner class to accept the inputs
         Scanner scan = new Scanner(System.in);
         System.out.print("Please enter a number from 1 to 100 (or q to quit):");
         String i=new String(scan.nextLine());

         if(i.equals("q")==true)
            {
            System.out.println("Mystery number was "+Number+"\nThank you for playing");
            System.exit(0);
            }
         
         acc=1;
         

	 //Making the first guess
         if(Integer.parseInt(i)==Number)
	     {
		 System.out.println("That's correct.  It took you "+acc+" guesses");
	     }
         else if(Integer.parseInt(i)>Number)
	     {
		 System.out.println("Incorrect, too high");
	     }
         else if(Integer.parseInt(i)<Number)
	     {
		 System.out.println("Incorrect, too low");
	     }
    




	 //Making further guesses tell we get a correct input or an "q" to exit 
         while(Number!=Integer.parseInt(i))
            {
                System.out.print("Please enter a number from 1 to 100 (or q to quit):");
                i=scan.nextLine();
                
                if(i.equals("q")==true)
                {
                    System.out.println("Mystery number was "+Number+"\nThank you for playing");
                    System.exit(0);
                }
                
                acc+=1;
                
                if(Integer.parseInt(i)==Number)
		    {
			System.out.println("That's correct.  It took you "+acc+" guesses");
		    }
                else if(Integer.parseInt(i)>Number)
		    {
			System.out.println("Incorrect, too high");
		    }
                else if(Integer.parseInt(i)<Number)
		    {
			System.out.println("Incorrect, too low");
		    }
        }
    }


    public static void main(String args[])
    {


     gemini();//calling the gemini method which handles all of the stuff




     //Making sure that the use gets to play for as long as they want
     
     System.out.print("Would you like to play again (y/n)?");
     
     Scanner scan = new Scanner(System.in);
     String i=new String(scan.nextLine());
     
     while(i.equals("y")==true)
	 {
	     gemini();
	     System.out.print("Would you like to play again (y/n)?");
	     i=scan.nextLine();
	 }
    }
}

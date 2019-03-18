/**
 *
 * ISBN.java
 * A program to calculate the final digit of an ISBN number
 * Part of HWK1 problem 2.
 *
 */

//Importing the things required
import java.util.Random;
import java.util.Scanner;
import java.lang.*;





/**
 * This class ISBN is supposed to carry out all the operations required for this .java file
 * 
 * @param the first n-1 digits of an n-digit ISBN number ( given as a scanner input)
 * 
 * @return The last digit
 */


public class ISBN

{

    //If the input's length is 9
    public static String isbn10(int isbn)
    {

	//Converting the int input to a string type to make unit by unit iteration possible

        //READER: When you convert an int to a string, leading 0s are missing. 
        String Final_Digit=Integer.toString(isbn);
        long sum=0;
        


	//Iterating through the String's placeth values
        //READER: Index out of range of the string when you make substring from i to i+1.
        //You'd better not make substring possible because it's very inefficient when computing. 
        //I changed the substring with charAt operation.
	// Also, leading 0s get removed converting from String to int
	// using divide and mod operations 9 times will work
	// even with leading 0 removed.
        for(int i=0;i<Final_Digit.length();i++)
            {
                long Iteration= Character.getNumericValue(Final_Digit.charAt(i));
                sum+=Iteration*(i+1);                                          //Incrementing the sum by multipying each palceth value with its index
            }

        String return_thing=Long.toString(sum%11);

        if(return_thing.equals("10"))
            {
                return_thing="X";
            }

        return return_thing;
    }


    //If the input's length is 12
    public static String isbn13(long isbn)
    {


	//Converting the int input to a string type to make unit by unit iteration possible
        
	String Final_Digit=Long.toString(isbn);
	long sum=0;
	int acc=0;                                                             //Making an accumulator to keep track of whether the index is odd or even
        


	//Iterating through the String's placeth values
        
	for(int i=0;i<12;i++)
            {
                int Iteration=Integer.parseInt(Final_Digit.substring(i,i+1));
                
		//Incrementing the sum by multipying each palceth value with either 1 or 3 depending on the particular index being even or odd
		if (acc==0){
		              sum+=Iteration;
			      acc=1;
		           }
		else{
		        sum+=Iteration*3;
			acc=0;
		    }
	    }
	



	long Ans=10-sum%10;

        String return_thing=Long.toString(Ans);

	if(return_thing.equals("10"))
            {
                return_thing="0";
            }

        return return_thing;        
    }

    public static void main(String args[]) throws Exception
    {


        Scanner scan = new Scanner(System.in);                              //Making a Scanner obj
        System.out.print("Please enter an ISBN number except the last digit:");
       
        String Complete_ISBN=new String(scan.nextLine());  //Scanning for input

	Integer length=Complete_ISBN.length();


	//Making sure that a sorrect length of ISBN digits is given
        while ((length.equals(9)==false)&&(length.equals(12)==false))
            {
                System.out.print("Please enter a correct ISBN numbers:");
                Complete_ISBN=scan.nextLine();
		length=Complete_ISBN.length();
            }


	try{
	    //Calling the correct ISBN function depending on the length to geerate the output.
	if (length.equals(9)==true)
            {
		System.out.println(isbn10(Integer.parseInt(Complete_ISBN))+" is the last digit?");
            }

        else if (length.equals(12)==true)
            {
		System.out.println(isbn13(Long.parseLong(Complete_ISBN))+" is the last digit?");
	    }                                                                                            }

	catch (NumberFormatException nfe)
	    { //Exiting out of the system
		System.err.println("The input was not numerical");
		System.exit(1);
	    }
    }
}

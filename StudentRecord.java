/**
 * CSC-202 
 * macOs Mojave version 10.14.01
 * 01/22/2019 
 * @author Rohit Agrawal 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecord {

	public static void main(String[] args) {
		
		// Array List 
		ArrayList<String> names = new ArrayList<String>(); 
		
		String fileName = "myNewFile.txt";
		
		// Method ->> helps to save file data into Array list.
		saveInToArray(names, fileName);   
		
		// Size of ArrayList.
		int size = names.size();  
		
		// Static Method ->> setting the last name as an ascending order.
		ascendingOrder(names, size);
		
		// Static Method ->> sending the data as an output text file. 
		sendBackText(names, size);
			
	} 
	
	//Methods starts here....
	
	//Static Method ->> helps to set the last name in an ascending 
	private static void ascendingOrder (ArrayList<String> names, int size)
	{
		for(int i =0; i<size; i++)
		{
			for(int j = i+1; j<size; j++)
			{
				int first = indexOf(names, i);   // finding indexOf last name of first sentence.
				int second =indexOf(names, j);   // finding indexOf last name of second sentence.
				
				String firstLine = names.get(i).toLowerCase();  // converting to lower case before checking. 
				String secondLine = names.get(j).toLowerCase(); // converting to lower case before checking.
				
				if ((firstLine.charAt(first) > secondLine.charAt(second)))  // if smaller, then stays in top, otherwise exchange. 
				{
					String temp = names.get(i);
					String temp1 = names.get(j);
					names.set(i, temp1);
					names.set(j, temp);
				}
				else if ((firstLine.charAt(first) == secondLine.charAt(second))) //if equal then check for second letter. 
				{
					
					if ((firstLine.charAt(first+1) > secondLine.charAt(second+1))) // if smaller, then stays in top, otherwise exchange.
					{
						String temp = names.get(i);
						String temp1 = names.get(j);
						names.set(i, temp1);
						names.set(j, temp);
					}
				}
				
			}//end of Inner loop
		}//outer loop ends here
	}
	
	// Method ->> To get the index of position of last name. 
	private static int indexOf (ArrayList<String> names, int i)
	{
		
		return (names.get(i).indexOf(",", names.get(i).indexOf(",") + 1)) +1;
	}
	
	// Method ->> To copy the text file into array list. 
	private static void saveInToArray (ArrayList<String> copyNames, String fileName)
	{
		try  // exception checking
		{
			File myFile = new File (fileName);
			Scanner inputStream = new Scanner(myFile);
			
			for (int i =0; i<= copyNames.size(); i++)
			{
				if (inputStream.hasNextLine()){
					copyNames.add(inputStream.nextLine());
				}
				
			}
			inputStream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening File: " + "myNewFile.txt");
		}
		
	}
	
	// Methods ->> To send a output file outside with the ascending format of last name
	private static void sendBackText (ArrayList<String> names, int size)
	{
		String fileName = "out.txt";
		
		try // exception checking
		{
			PrintWriter outputStream = new PrintWriter(fileName);
			for (int i = 0; i< size; i++)
			{
				outputStream.println(names.get(i));
			}
			outputStream.close();
			
		}
		catch(FileNotFoundException e) 
		{
			System.out.println("Error opening file: " + fileName);
		}
	}

}

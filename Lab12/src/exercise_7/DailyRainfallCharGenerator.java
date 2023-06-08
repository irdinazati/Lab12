package exercise_7;

import java.io.BufferedWriter;
import java.io.FileWriter;

/*
 * This class is for processing Daily Rainfall Data from Selected 
 * Station using Character-Based Stream
 * 
 * This class is recreated based on RainFallDataWriter.java in package exercise5.
 * 
 * @author Nur Irdina Izzati Binti Khairuzaman
 */

public class DailyRainfallCharGenerator {

	public static void main (String [] args)
	{
		// 1. Identify the destination and declare output file
		String outFile = "DailyRainfallChar.txt";
		try
		{		
			// 2. Construct BufferedWriter object together with FileWriter
			FileWriter files = new FileWriter(outFile);
			BufferedWriter bwOutput = new BufferedWriter(files);
			int [] array= {0,4,1,0,6,19};
			
			// 3. Write the data
			for (int index = 0; index < array.length; index++) {
				bwOutput.write(String.valueOf(array[index]));
				bwOutput.newLine();
			}
			
			
			// 4. Clear the stream
			bwOutput.flush(); 
			
			// 5. Close the stream
			bwOutput.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + outFile); 
	}
	
}
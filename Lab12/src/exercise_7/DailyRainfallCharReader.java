package exercise_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * This class read the daily rainfall readings from selected station from a certain source file
 * using suitable subclasses of Reader.
 * 
 * This class is recreated based on RainFallDataReader.java in package exercise5
 * 
 * In this case, BufferedReader is used.
 * @author Nur Irdina Izzati Binti Khairuzaman
 */

public class DailyRainfallCharReader {

	public static void main (String [] args)
	{
		// 1. Declare output file 
		String sourceFile = "DailyRainfallChar.txt";
		
		// display the sentence for reading data
		System.out.println("Reading data from " + sourceFile + "\n");
		try
		{
			
			
			// 2. Construct the Reader object
			BufferedReader brInput = new BufferedReader(new FileReader(sourceFile));
			
			// 3. Read values from the stream
			// variables to handle data read from the source file
			
			// receive daily rainfall reading
			String DailyRainfall = "";
			
			// variables to count number of daily reading in the source file
			int noOfDays = 0;
			
			// variable to calculate total daily rainfall
			double TotalRainfall = 0.0;
			
			// Read values from the stream
			
			
			// 3. Read the data
			DailyRainfall = brInput.readLine();
			while (DailyRainfall != null) {
				
				// Display each daily rainfall reading
				System.out.println(DailyRainfall);
				
				// Calculate total daily rainfall
				TotalRainfall = TotalRainfall + Double.parseDouble(DailyRainfall);
				
				// Auto update current number of records read from the source file
				noOfDays ++;
				
				// Read next value for the daily rainfall reading
				DailyRainfall = brInput.readLine();
			}
			
			// Display total number of records for the daily rainffall readings from the source file
			System.out.println("\nTotal Records: " + noOfDays);
			
			// Display total daily rainfall
			System.out.println("Total Daily Rainfall: " + TotalRainfall);
			
			// Calculate average daily rainfall
			double averageRainfall = TotalRainfall / Double.valueOf(noOfDays);
			
			
			String formattedAverage = String.format("%.1f", averageRainfall);
			System.out.print("\nAverage rainfall for " + noOfDays 
					+ " days: " + formattedAverage);
						
			// 4. Close the Reader
			brInput.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
					
	}
	
	
}
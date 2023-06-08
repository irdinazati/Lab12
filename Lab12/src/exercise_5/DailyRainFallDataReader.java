package exercise_5;

import java.io.DataInputStream;
import java.io.FileInputStream;


/**
 * Exercise 5 from Lab 12
 * Task C
 * This program generates data for 6 days reading of daily rainfall
 * from station Simpang Ampat in Alor Gajah district from a file using DataOutputStream
 * 
 * @author Nur Irdina Izzati Binti Khairuzaman
 *
 */

public class DailyRainFallDataReader {
	
	public static void main(String[] args) {

		// 1. Declare output file 
		String sourceFile = "DailyRainFall.txt";
		
		// display the sentence for reading data
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			// 2. Create stream to read data
			DataInputStream disInput = new DataInputStream(new FileInputStream(sourceFile));
			
			// 3. Read values from the stream
			// variables to handle data read from the source file
			
			// receive daily rainfall reading
			double Rainfall = 0;
			
			// variables to count number of daily reading in the source file
			int noOfDays = 0;
			
			// variable to calculate total daily rainfall
			double totalRainfall = 0.0;
			
			// Read values from the stream
			Rainfall = disInput.read();
			
			System.out.println("The 6 days readings of daily rainfalL: ");
			
			// -1: read until end of file/stream
			while (Rainfall != -1) {
				
				// Display each daily rainfall reading
				System.out.println(Rainfall);
				
				// Calculate total daily rainfall
				totalRainfall = totalRainfall + Rainfall;
				
				// Auto update current number of records read from the source file
				noOfDays ++;
				
				// Read next value for the daily rainfall reading
				Rainfall = disInput.read();
	
			} 
			
			// Display total number of records for the daily rainffall readings from the source file
			System.out.println("\nTotal Days: " + noOfDays);
			
			// Display total daily rainfall
			System.out.println("Total Daily Rainfall: " + totalRainfall);
			
			// Calculate average daily rainfall
			double averageRainfall = totalRainfall / Double.valueOf(noOfDays);
			
			
			String formattedAverage = String.format("%.1f", averageRainfall);
			System.out.print("\nAverage rainfall for " + noOfDays
					+ " days: " + formattedAverage);
			
			
			// 4. Close stream
			disInput.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
		

	}
}

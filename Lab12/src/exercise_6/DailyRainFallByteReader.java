package exercise_6;

import java.io.DataInputStream;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Exercise 6 from Lab 12
 * This program enables Processing Daily Rainfall Data from Selected Station using Byte-Based Stream
 * The data is read in byte-based using DataInputStream class. 
 * The data represents station id, station name, name of district and 6-days reading of daily rainfall.
 * 
 * @author Nur Irdina Izzati Binti Khairuzaman
 *
 */

public class DailyRainFallByteReader {

	public static void main(String[] args) {

		// 1. Declare source file 
		String sourceFile = "DailyRainfallByte.txt";
		System.out.println("Reading data from " + sourceFile + "\n");
		
		try {

			// 2. Create input stream to read data
			DataInputStream disIn = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			// Station Id
			int id = 0;
			
			// Station Name and District
			String station = " ", district = " ";
			
			// Daily rainfall readings from 2 June 2023 to 7 June 2023
			double reading1 = 0.0, reading2 = 0.0, reading3 = 0.0;
			double reading4 = 0.0, reading5 = 0.0, reading6 = 0.0;
			
			// Variable declaration for calculation
			// Total number of records read from the source file
			int noOfDays = 0;
			
			// Total daily rainfall readings for each station
			double sum = 0.0;
			// Declaration of Arraylist to store the each total daily rainfall readings
			ArrayList <Double> totalRainfall = new ArrayList<Double>();
			
			// ArrayList to store stations for calculation purpose
			ArrayList<String> stations = new ArrayList<String>();
						
			// HashSet to store distinct district for calculation purpose
			HashSet<String> districtCount = new HashSet<String>();
			
			
			// 3. Process data until end-of-file
			while(disIn.available() > 0) {
				
				// Read data
				
				// station id
				id = disIn.readInt();
				
				// station name
				station = disIn.readUTF();
				
				// district
				district = disIn.readUTF();
				
				// daily rainfall readings for 1 June 2023
				reading1 = disIn.readDouble();
				
				// daily rainfall readings for 2 June 2023
				reading2 = disIn.readDouble();
				
				// daily rainfall readings for 3 June 2023
				reading3 = disIn.readDouble();
				
				// daily rainfall readings for 4 June 2023
				reading4 = disIn.readDouble();
				
				// daily rainfall readings for 5 June 2023
				reading5 = disIn.readDouble();
				
				// daily rainfall readings for 6 June 2023
				reading6 = disIn.readDouble();
				
				System.out.println( id + "\t" + station + "\t" + district
						+ "\t" + reading1 + "\t" + reading2 + "\t" + reading3 
						+ "\t" + reading4 + "\t" + reading5 + "\t" + reading6 );
				
				// calculate total daily rainfall readings for each station
				sum = reading1 + reading2 + reading3 + reading4 + reading5 + reading6;
				
				// save the sum into the arraylist, totalRainfall
				totalRainfall.add(sum);
				
				// save the station names into the arraylist, stations
				stations.add(station);
				
				// save the distinct district into hashSet, districtCount
				districtCount.add(district);
				
				// Auto update for current number of records
				noOfDays ++;
			}
			
			System.out.println("\n");
			
			// Calculation for average daily rainfall readings in each station
			for(int index = 0; index < stations.size(); index++)
			{
				// Calculation for average daily rainfall readings in each station
				double average = totalRainfall.get(index) / noOfDays;
				
				// format the average in one decimal places
				String formattedAverage = String.format("%.1f", average);
				
				// display the total daily rainfall readings in each station and its correspond average
				System.out.println("The total daily rainfall: " + stations.get(index) + " : " 
						+ totalRainfall.get(index) );
				System.out.println("The average daily rainfall:  " + stations.get(index) + " : " 
						+ formattedAverage + "\n");
			}
			
			System.out.println("There are " + stations.size() + " stations and "
						+ districtCount.size() + " districts in Melaka.");
			
			// 4. Close stream
			disIn.close();
	
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
	}
}
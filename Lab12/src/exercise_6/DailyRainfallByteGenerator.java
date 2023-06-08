package exercise_6;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * Exercise 6 from Lab 12
 * This program enables Processing  Daily  Rainfall Data  from Selected Station using Byte-Based Stream
 * The data is written in byte-based using DataOutputStream class. 
 * 
 * @author Nur Irdina Izzati Binti Khairuzaman
 *
 */

public class DailyRainfallByteGenerator {
	
	public static void main (String [] args)
	{
		// 1. Declare output file 
		String outFile = "DailyRainfallByte.txt";
		
		// Data declaration
		// Station id
		int id[] = {2421003, 2222002, 2324033, 2125002, 2223023, 2222006};
		
		// Station name
		String station[] = {"Simpang Ampat", "Melaka Pindah", "Hospital Jasin", "Chohong", "Cheng (Taman Merdeka)", "Bukit Katil,Sg. Duyong"};
		
		// district name
		String district[] = {"Alor Gajah", "Alor Gajah", "Jasin", "Jasin", "Melaka Tengah", "Melaka Tengah"};
		
		// readings on 2 June 2023
		double reading1[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		// readings on 3 June 2023
		double reading2[] = {4.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		// readings on 4 June 2023
		double reading3[] = {1.0, 0.0, 14.0, 21.5, 3.5, 0.5};
		
		// readings on 5 June 2023
		double reading4[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		// readings on 6 June 2023
		double reading5[] = {6.0, 2.0, 11.0, 39.0, 42.5, 37.5};
		
		// readings on 7 June 2023
		double reading6[] = {19.0, 18.5, 15.0, 14.5, 10.0, 23.5};
		
		try {
			
			// 2. Create output stream to read data
			DataOutputStream dosOut = new DataOutputStream(new FileOutputStream(outFile));
			
			// Process data
			for (int index = 0; index < station.length; index++) {
				
				// 3. Write data into data stream
				dosOut.writeInt(id[index]);
				dosOut.writeUTF(station[index]);
				dosOut.writeUTF(district[index]);
				dosOut.writeDouble(reading1[index]);
				dosOut.writeDouble(reading2[index]);
				dosOut.writeDouble(reading3[index]);
				dosOut.writeDouble(reading4[index]);
				dosOut.writeDouble(reading5[index]);
				dosOut.writeDouble(reading6[index]);
				
				// 4. Flush for each writing
				dosOut.flush();
			}
			
			// 5. Close stream
			dosOut.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + outFile); 
	}
}
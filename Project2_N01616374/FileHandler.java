import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.text.ParseException;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Handles loading road volume and speed data from files
 * and writing road section data to an output file.
 */
public class FileHandler {

	    /**
	     * Loads road volume records from a CSV file.
	     * Skips the header, parses each record, and stores the
	     * records in an ArrayList of RoadVolume objects.
	     *
	     * @param filename the name of the volume data file
	     * @return an ArrayList containing the road volume records
	     * @throws FileNotFoundException if the specified file cannot be found
	     * @throws ParseException if a date cannot be parsed
	     */
	public static ArrayList<RoadVolume> loadVolumeData(String filename) 
			throws FileNotFoundException, ParseException {
		
		ArrayList <RoadVolume> volumeList = new ArrayList<>();
		Scanner fileScanner = new Scanner(new File(filename));
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		formatter.setLenient(false);
		
		if (fileScanner.hasNextLine()) {
			fileScanner.nextLine();
		}
		
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			String[] fields = line.split(",");
			
			Date date = formatter.parse(fields[0]);
			String time = fields[1];
			
			int sensor1 = Integer.parseInt(fields[2]);
			int sensor2 = Integer.parseInt(fields[3]);
			int sensor3 = Integer.parseInt(fields[4]);
			int sensor4 = Integer.parseInt(fields[5]);
			
			RoadVolume volume = new RoadVolume(date, time, sensor1, sensor2, sensor3, sensor4);
			
			volumeList.add(volume);
		}
		
		fileScanner.close();
		return volumeList;
	}
	
	/**
     * Loads road speed records from a CSV file.
     * Skips the header, parses each record, and stores the
     * records in an ArrayList of RoadSpeed objects.
     *
     * @param filename the name of the speed data file
     * @return an ArrayList containing the road speed records
     * @throws FileNotFoundException if the specified file cannot be found
     * @throws ParseException if a date cannot be parsed
     */
	public static ArrayList<RoadSpeed> loadSpeedData(String filename)
			throws FileNotFoundException, ParseException {
		
		ArrayList<RoadSpeed> speedList = new ArrayList<>();
		Scanner fileScanner = new Scanner(new File(filename));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setLenient(false);
		
		if (fileScanner.hasNextLine()) {
			fileScanner.nextLine();
		}
		
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			String[] fields = line.split(",");
			
			Date date = formatter.parse(fields[0]);
			String time = fields[1];
			
			double sensor1 = Double.parseDouble(fields[2]);
			double sensor2 = Double.parseDouble(fields[3]);
			
			RoadSpeed speed = new RoadSpeed(date, time, sensor1, sensor2);
			
			speedList.add(speed);
		}
		
		fileScanner.close();
		return speedList;
	}
	
	/**
     * Writes road section records to a CSV output file.
     * Writes a header row followed by the data for each
     * RoadSection in the supplied list.
     *
     * @param sectionList the list of road sections to write
     * @throws FileNotFoundException if the output file cannot be created
     * @throws ParseException if a parsing error occurs while processing the data
     */
	public static void writeRoadSectionData(ArrayList<RoadSection> sectionList)
			throws FileNotFoundException, ParseException{
		
		PrintWriter writer = new PrintWriter("Road_Section_Data.csv");
		
		writer.println("Date,Time,Volume_Sensor_2003,Volume_Sensor_2004,"
				+ "Volume_Sensor_2005,Volume_Sensor_2006,Speed_Sensor_2282,"
				+ "Speed_Sensor_2293,Volume_Total,Volume_Avg,Speed_Avg");
		
		for (RoadSection section : sectionList) {
			writer.println(section.getFileData());
		}
		
		writer.close();
	}
}
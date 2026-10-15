import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * Runs Project 2 by loading road volume and speed data,
 * matching records, and writing the resulting road section data.
 */
public class Project2 {
	
	private static ArrayList<RoadSection> sectionList = new ArrayList<>();

	/**
     * Runs the program and processes the volume and speed data files.
     * Prompts the user for file names, loads the data, creates road
     * sections, and writes the results. Repeats if a file or data
     * parsing error occurs.
     *
     * @param args command-line arguments (not used)
     */
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		boolean validInput = false;
		
		while (!validInput) {
			System.out.println("Enter Path and Name of Volume and Speed Data File");
			
			String volumeFileName = scnr.next();
			String speedFileName = scnr.next();
		
			try {
				System.out.println("Loading Volume Data");
				
				ArrayList<RoadVolume> volumeList = FileHandler.loadVolumeData(volumeFileName);
				System.out.println("Volume Data Loaded");
				
				System.out.println("Loading Speed Data");
				
				ArrayList<RoadSpeed> speedList = FileHandler.loadSpeedData(speedFileName);
				System.out.println("Speed Data Loaded");
				
				createRoadSections(volumeList, speedList);
				
				FileHandler.writeRoadSectionData(sectionList);
				
				System.out.println("Road Section Data Created"); 
				
				validInput = true;
			}
			catch (FileNotFoundException e){
				System.out.println("File not found Error: " + e.getMessage() + " (The system cannot"
						+ " find the file specified)");
			}
			catch (ParseException e) {
				System.out.println("Date Parse Error: " + e.getMessage());
			}
			catch (NumberFormatException e){
				System.out.println("Number Parse Error: " + e.getMessage());
			}
		}
		
		scnr.close();
	}
	
	/**
     * Matches road volume records with road speed records that have
     * the same date and time. Creates a RoadSection for each matching
     * pair and stores the sections in sectionList.
     *
     * @param volumeList the list of road volume records
     * @param speedList the list of road speed records
     */
	public static void createRoadSections(
			ArrayList<RoadVolume> volumeList,
			ArrayList<RoadSpeed> speedList) {
		
		sectionList.clear();
		
		for (RoadVolume volume : volumeList) {
			for (RoadSpeed speed : speedList) {
				if (volume.getDate().equals(speed.getDate()) && volume.getTime().equals(speed.getTime())) {
					RoadSection section = new RoadSection(volume, speed);
					sectionList.add(section);
					
					break;
				}
			}
		}
	} 
}
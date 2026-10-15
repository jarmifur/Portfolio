import java.text.SimpleDateFormat;

/**
 * Represents a road section containing traffic volume and speed data.
 * Calculates the total and average volume and average speed.
 */
public class RoadSection {
	private RoadVolume roadVolume;
	private RoadSpeed roadSpeed;
	private int volumeTotal;
	private double volumeAvg;
	private double speedAvg;
	
	/**
     * Creates a road section using the supplied volume and speed data.
     * Calculates the total volume, average volume, and average speed.
     *
     * @param roadVolume the road volume data
     * @param roadSpeed the road speed data
     */
	public RoadSection(RoadVolume roadVolume, RoadSpeed roadSpeed) {
		this.roadVolume = roadVolume;
		this.roadSpeed = roadSpeed;
		
		this.volumeTotal = calcVolumeTotal();
		this.volumeAvg = calcVolumeAvg();
		this.speedAvg = calcSpeedAvg();
	}
	
	/**
     * Creates a comma-separated string containing the road section data.
     *
     * @return the road section data formatted for a CSV file
     */
	public String getFileData() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyy");
		
		return formatter.format(roadVolume.getDate()) + ","
				+ roadVolume.getTime() + ","
				+ roadVolume.getVolumeSensor1() + "," 
				+ roadVolume.getVolumeSensor2() + ","
				+ roadVolume.getVolumeSensor3() + ","
				+ roadVolume.getVolumeSensor4() + ","
				+ roadSpeed.getSpeedSensor1() + "," 
				+ roadSpeed.getSpeedSensor2() + ","
				+ volumeTotal + ","
				+ volumeAvg + ","
				+ speedAvg;
	}
	
	/**
     * Returns the road volume data.
     *
     * @return the road volume object
     */
	public RoadVolume getRoadVolume() {
		return roadVolume;
	}
	
	/**
     * Sets the road volume data.
     *
     * @param roadVolume the road volume object to assign
     */
	public void setRoadVolume(RoadVolume roadVolume) {
		this.roadVolume = roadVolume;
	}
	
	/**
     * Returns the road speed data.
     *
     * @return the road speed object
     */
	public RoadSpeed getRoadSpeed() {
		return roadSpeed;
	}
	
	/**
     * Sets the road speed data.
     *
     * @param roadSpeed the road speed object to assign
     */
	public void setRoadSpeed(RoadSpeed roadSpeed) {
		this.roadSpeed = roadSpeed;
	}
	
	/**
     * Returns the total traffic volume.
     *
     * @return the total volume from all four sensors
     */
	public int getVolumeTotal() {
		return volumeTotal;
	}
	
	/**
     * Sets the total traffic volume.
     *
     * @param total the total volume to assign
     */
	public void setVolumeTotal(int total) {
		this.volumeTotal = total;
	}
	
	/**
     * Returns the average traffic volume.
     *
     * @return the average volume from the four sensors
     */
	public double getVolumeAvg() {
		return volumeAvg;
	}
	
	/**
     * Sets the average traffic volume.
     *
     * @param avg the average volume to assign
     */
	public void setVolumeAvg(double avg) {
		this.volumeAvg = avg;
	}
	
	/**
     * Returns the average traffic speed.
     *
     * @return the average speed from the two sensors
     */
	public double getSpeedAvg() {
		return speedAvg;
	}
	
	/**
     * Sets the average traffic speed.
     *
     * @param avg the average speed to assign
     */
	public void setSpeedAvg(double avg) {
		this.speedAvg = avg;
	}
	
	/**
     * Calculates the total traffic volume from all four sensors.
     *
     * @return the sum of the four volume sensor readings
     */
	private int calcVolumeTotal() {
		return roadVolume.getVolumeSensor1() 
				+ roadVolume.getVolumeSensor2() 
				+ roadVolume.getVolumeSensor3() 
				+ roadVolume.getVolumeSensor4();
	}
	
	/**
     * Calculates the average traffic volume from all four sensors.
     *
     * @return the average of the four volume sensor readings
     */
	private double calcVolumeAvg() {
		return calcVolumeTotal() / 4.0;
	}
	
	/**
     * Calculates the average traffic speed from both sensors.
     *
     * @return the average of the two speed sensor readings
     */
	private double calcSpeedAvg() {
		return (roadSpeed.getSpeedSensor1() + roadSpeed.getSpeedSensor2()) / 2.0;
	}
}
import java.util.Date;

/**
 * Represents road volume data collected by four volume sensors
 * at a specific date and time.
 */
public class RoadVolume {
	private Date date;
	private String time;
	private int volumeSensor1;
	private int volumeSensor2;
	private int volumeSensor3;
	private int volumeSensor4;
	
	/**
     * Creates a RoadVolume object with the specified date, time,
     * and volume sensor readings.
     *
     * @param date the date of the volume readings
     * @param time the time of the volume readings
     * @param volumeSensor1 the reading from volume sensor 1
     * @param volumeSensor2 the reading from volume sensor 2
     * @param volumeSensor3 the reading from volume sensor 3
     * @param volumeSensor4 the reading from volume sensor 4
     */
	public RoadVolume(Date date, String time, int volumeSensor1, int volumeSensor2, int volumeSensor3, int volumeSensor4) {
		this.date = date;
		this.time = time;
		this.volumeSensor1 = volumeSensor1;
		this.volumeSensor2 = volumeSensor2;
		this.volumeSensor3 = volumeSensor3;
		this.volumeSensor4 = volumeSensor4;
	}
	
	/**
     * Returns the date, time, and volume sensor readings as a
     * comma-separated string.
     *
     * @return a string containing the date, time, and all four volume sensor readings
     */
	public String getFileData() {
		return date + "," + time + "," + volumeSensor1 + "," + volumeSensor2 + "," + volumeSensor3 + "," + volumeSensor4;
	}
	
	/**
     * Returns the date of the volume readings.
     *
     * @return the date of the readings
     */
	public Date getDate() {
		return date;
	}
	
	/**
     * Sets the date of the volume readings.
     *
     * @param date the date to assign
     */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
     * Returns the time of the volume readings.
     *
     * @return the time of the readings
     */
	public String getTime() {
		return time;
	}
	
	/**
     * Sets the time of the volume readings.
     *
     * @param time the time to assign
     */
	public void setTime(String time) {
		this.time = time;
	}
	
	/**
     * Returns the reading from volume sensor 1.
     *
     * @return the first volume sensor reading
     */
	public int getVolumeSensor1() {
		return volumeSensor1;
	}
	
	/**
     * Sets the reading from volume sensor 1.
     *
     * @param volumeSensor1 the first volume sensor reading
     */
	public void setVolumeSensor1(int volumeSensor1) {
		this.volumeSensor1 = volumeSensor1;
	}
	
	/**
     * Returns the reading from volume sensor 2.
     *
     * @return the second volume sensor reading
     */
	public int getVolumeSensor2() {
		return volumeSensor2;
	}
	
	/**
     * Sets the reading from volume sensor 2.
     *
     * @param volumeSensor2 the second volume sensor reading
     */
	public void setVolumeSensor2(int volumeSensor2) {
		this.volumeSensor2 = volumeSensor2;
	}
	
	/**
     * Returns the reading from volume sensor 3.
     *
     * @return the third volume sensor reading
     */
	public int getVolumeSensor3() {
		return volumeSensor3;
	}
	
	/**
     * Sets the reading from volume sensor 3.
     *
     * @param volumeSensor3 the third volume sensor reading
     */
	public void setVolumeSensor3(int volumeSensor3) {
		this.volumeSensor3 = volumeSensor3;
	}
	
	/**
     * Returns the reading from volume sensor 4.
     *
     * @return the fourth volume sensor reading
     */
	public int getVolumeSensor4() {
		return volumeSensor4;
	}
	
	/**
     * Sets the reading from volume sensor 4.
     *
     * @param volumeSensor4 the fourth volume sensor reading
     */
	public void setVolumeSensor4(int volumeSensor4) {
		this.volumeSensor4 = volumeSensor4;
	}
}
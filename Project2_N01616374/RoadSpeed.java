import java.util.Date;

/**
 * Represents road speed data collected by two speed sensors
 * at a specific date and time.
 */
public class RoadSpeed {
	private Date date;
	private String time;
	private double speedSensor1;
	private double speedSensor2;
	
	/**
     * Creates a RoadSpeed object with the specified date, time,
     * and speed sensor readings.
     *
     * @param date the date of the speed readings
     * @param time the time of the speed readings
     * @param speedSensor1 the reading from speed sensor 1
     * @param speedSensor2 the reading from speed sensor 2
     */
	public RoadSpeed(Date date, String time, double speedSensor1, double speedSensor2) {
		this.date = date;
		this.time = time;
		this.speedSensor1 = speedSensor1;
		this.speedSensor2 = speedSensor2;
	}
	
	/**
	 * Returns the date, time, and speed sensor readings as a
	 * comma-separated string.
	 *
	 * @return a string containing the date, time, and both speed sensor readings
	 */
	public String getFileData() {
		return date + "," + time + "," + speedSensor1 + "," + speedSensor2;
	}
	
	/**
     * Returns the date of the speed readings.
     *
     * @return the date of the readings
     */
	public Date getDate() {
		return date;
	}
	
	/**
     * Sets the date of the speed readings.
     *
     * @param date the date to assign
     */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
     * Returns the time of the speed readings.
     *
     * @return the time of the readings
     */
	public String getTime() {
		return time;
	}
	
	/**
     * Sets the time of the speed readings.
     *
     * @param time the time to assign
     */
	public void setTime(String time) {
		this.time = time;
	}
	
	/**
     * Returns the reading from speed sensor 1.
     *
     * @return the first speed sensor reading
     */
	public double getSpeedSensor1() {
		return speedSensor1;
	}
	
	/**
     * Sets the reading from speed sensor 1.
     *
     * @param speedSensor1 the first speed sensor reading
     */
	public void setSpeedSensor1(double speedSensor1) {
		this.speedSensor1 = speedSensor1;
	}
	
	/**
     * Returns the reading from speed sensor 2.
     *
     * @return the second speed sensor reading
     */
	public double getSpeedSensor2() {
		return speedSensor2;
	}
	
	/**
     * Sets the reading from speed sensor 2.
     *
     * @param speedSensor2 the second speed sensor reading
     */
	public void setSpeedSensor2(double speedSensor2) {
		this.speedSensor2 = speedSensor2;
	}
}
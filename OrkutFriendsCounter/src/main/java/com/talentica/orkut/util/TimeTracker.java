package com.talentica.orkut.util;

import java.util.Date;

/**
 * Utility class to track time spent on different functions.
 * 
 * @author NitinK
 *
 */
public class TimeTracker {

	private Date startTime;

	private Date endTime;

	/**
	 * Starts measuring time from current instant.
	 */
	public void start() {
		startTime = new Date();
	}

	/**
	 * Stops measuring of time from current instant.
	 */
	public void stop() {
		endTime = new Date();
	}

	/**
	 * Returns time elapsed in seconds.
	 */
	public float getTimeElapsedInSeconds() {
		return Float.valueOf((endTime.getTime() - startTime.getTime())) / 1000f;
	}

	/**
	 * Returns time elapsed in milliseconds.
	 */
	public long getTimeElapsedInMilliSeconds() {
		return (endTime.getTime() - startTime.getTime());
	}

	/**
	 * Prints elapsed time in seconds with extra context information passed on
	 * {@link System} console
	 * */
	public void logTimeElapsedInSeconds(String context) {
		System.out.println("Time elapsed (" + context + "): "
				+ getTimeElapsedInSeconds() + " seconds");
	}

	/**
	 * Prints elapsed time in milliseconds with extra context information passed
	 * on {@link System} console
	 * */
	public void logTimeElapsedInMilliSeconds(String context) {
		System.out.println("Time elapsed (" + context + "): "
				+ getTimeElapsedInMilliSeconds() + " ms");
	}

}

package com.talentica.orkut.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for time tracker.
 * 
 * @author NitinK
 *
 */
public class TimeTrackerTest {

	@Test
	public void testGetTimeElapsedInMilliSeconds() throws InterruptedException {
		TimeTracker timeTracker = new TimeTracker();
		timeTracker.start();
		Thread.sleep(1234);
		timeTracker.stop();
		long timeElapsedInMilliSeconds = timeTracker
				.getTimeElapsedInMilliSeconds();
		Assert.assertEquals(
				"Actual elapsed time was less than expected: 1234 ms. Actual elapsed time is:"
						+ timeElapsedInMilliSeconds, true,
				timeElapsedInMilliSeconds >= 1234);
	}

}

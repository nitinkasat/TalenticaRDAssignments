package com.talentica.orkut.builder;

import junit.framework.Assert;

import org.junit.Test;

import com.talentica.orkut.domain.Member;
import com.talentica.orkut.util.TimeTracker;

public class TabDelimatedStringMemberBuilderTest {

	private MemberBuilder memberBuilder = new TabDelimatedStringMemberBuilder();

	@Test
	public void testBuildMember() {
		String tabDelimatedInput = "1	2";
		TimeTracker timeTracker = new TimeTracker();
		timeTracker.start();
		Member member = memberBuilder.buildMember(tabDelimatedInput);
		timeTracker.stop();
		timeTracker.logTimeElapsedInMilliSeconds("testBuildMember");
		Assert.assertNotNull(member);
		Assert.assertNotNull(member.getId());
		Assert.assertEquals("1", member.getId());
		long timeElapsedInMilliSeconds = timeTracker
				.getTimeElapsedInMilliSeconds();
		org.junit.Assert.assertEquals(
				"Took more than maximum expected time. Time taken:"
						+ timeElapsedInMilliSeconds, true,
				timeElapsedInMilliSeconds <= 1);
	}

}

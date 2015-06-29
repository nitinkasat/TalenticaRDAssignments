package com.talentica.orkut.friends;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.talentica.orkut.domain.Member;

/**
 * Test class for {@link FriendsCounter}
 * 
 * @author NitinK
 *
 */
public class FriendsCounterTest {

	private URL graphFile;

	@Before
	public void setup() {
		graphFile = FriendsCounterTest.class.getClassLoader().getResource(
				"FriendsGraphTest.txt");
	}

	@Test
	public void testCountForMemberId1() throws FileNotFoundException,
			IOException {
		FriendsCounter counter = new FriendsCounter(graphFile.getPath());
		Map<String, Member> mapOfMembersToQueryFriendsCountFor = new HashMap<String, Member>();
		String memberId = "1";
		mapOfMembersToQueryFriendsCountFor.put(memberId, new Member(memberId));
		mapOfMembersToQueryFriendsCountFor = counter
				.count(mapOfMembersToQueryFriendsCountFor);
		Assert.assertNotNull(mapOfMembersToQueryFriendsCountFor);
		Assert.assertEquals(1, mapOfMembersToQueryFriendsCountFor.size());
		Member memberWithId1 = mapOfMembersToQueryFriendsCountFor.get(memberId);
		Assert.assertNotNull(memberWithId1);
		Assert.assertEquals(13, memberWithId1.getNoOfFriends());
	}

	@Test
	public void testCountForMemberId62() throws FileNotFoundException,
			IOException {
		FriendsCounter counter = new FriendsCounter(graphFile.getPath());
		Map<String, Member> mapOfMembersToQueryFriendsCountFor = new HashMap<String, Member>();
		String memberId = "62";
		mapOfMembersToQueryFriendsCountFor.put(memberId, new Member(memberId));
		mapOfMembersToQueryFriendsCountFor = counter
				.count(mapOfMembersToQueryFriendsCountFor);
		Assert.assertNotNull(mapOfMembersToQueryFriendsCountFor);
		Assert.assertEquals(1, mapOfMembersToQueryFriendsCountFor.size());
		Member memberWithId1 = mapOfMembersToQueryFriendsCountFor.get(memberId);
		Assert.assertNotNull(memberWithId1);
		Assert.assertEquals(7, memberWithId1.getNoOfFriends());
	}

	@Test
	public void testCountForNonExistingMember() throws FileNotFoundException,
			IOException {
		FriendsCounter counter = new FriendsCounter(graphFile.getPath());
		Map<String, Member> mapOfMembersToQueryFriendsCountFor = new HashMap<String, Member>();
		String memberId = "62213123";
		mapOfMembersToQueryFriendsCountFor.put(memberId, new Member(memberId));
		mapOfMembersToQueryFriendsCountFor = counter
				.count(mapOfMembersToQueryFriendsCountFor);
		Assert.assertNotNull(mapOfMembersToQueryFriendsCountFor);
		Assert.assertEquals(1, mapOfMembersToQueryFriendsCountFor.size());
		Member memberWithId1 = mapOfMembersToQueryFriendsCountFor.get(memberId);
		Assert.assertNotNull(memberWithId1);
		Assert.assertEquals(0, memberWithId1.getNoOfFriends());
	}

}

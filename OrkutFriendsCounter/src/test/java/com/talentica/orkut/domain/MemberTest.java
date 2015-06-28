package com.talentica.orkut.domain;

import junit.framework.Assert;

import org.junit.Test;

public class MemberTest {

	@Test
	public void testEqualsForNotEqualMembers() {
		Member member1 = new Member("1");
		Member member2 = new Member("2");
		Assert.assertEquals(false, member1.equals(member2));
	}

	@Test
	public void testEqualsForEqualMembers() {
		Member member1 = new Member("1");
		Member member2 = new Member("1");
		Assert.assertEquals(member1.hashCode(), member2.hashCode());
		Assert.assertEquals(true, member1.equals(member2));
	}

	@Test
	public void testAddFriend() {
		Member member1 = new Member("1");
		Assert.assertEquals(member1.getFriendsCount(), 0);
		member1.incrementCountOfFriends();
		Assert.assertEquals(member1.getFriendsCount(), 1);
		member1.incrementCountOfFriends();
		Assert.assertEquals(member1.getFriendsCount(), 2);
	}

}

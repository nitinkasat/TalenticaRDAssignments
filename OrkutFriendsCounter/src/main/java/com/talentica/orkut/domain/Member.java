package com.talentica.orkut.domain;

/**
 * 
 * Represents Orkut member.
 * 
 * @author NitinK
 *
 */
public class Member {

	private String id;

	private long noOfFriends = 0;

	public Member(String memberId) {
		this.id = memberId;
	}

	/**
	 * Increments no. of friends member have by one.
	 */
	public void addNewFriend(Member friend) {
		noOfFriends++;
	}

	/**
	 * Returns no. of friends a member have.
	 */
	public long getNoOfFriends() {
		return noOfFriends;
	}

	/**
	 * Returns member identifier.
	 */
	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		if (id != null) {
			return id.hashCode();
		}
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj instanceof Member && getId() != null) {
			Member otherMember = (Member) obj;
			return getId().equals(otherMember.getId());
		}
		return false;
	}

	@Override
	public String toString() {
		return "ID:\t" + getId() + "\tNo of friends:\t" + getNoOfFriends();
	}

}

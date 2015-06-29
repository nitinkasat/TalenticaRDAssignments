package com.talentica.orkut.friends;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.talentica.orkut.builder.MemberBuilder;
import com.talentica.orkut.builder.TabDelimatedLineMemberBuilder;
import com.talentica.orkut.domain.Member;
import com.talentica.orkut.util.TimeTracker;

/**
 * Counter to count no. of friends from a friendship graph file for of members.
 * 
 * @author NitinK
 *
 */
public class MembersFriendsCounter {

	private static final int DEFAULT_BUFFER_SIZE = 65536;

	private String friendshipGraphFileLocation;

	private static final MemberBuilder memberBuilder = new TabDelimatedLineMemberBuilder();

	public MembersFriendsCounter(String friendshipGraphFilePath) {
		friendshipGraphFileLocation = friendshipGraphFilePath;
	}

	/**
	 * Counts no. of friends from friendship graph file for the members present
	 * in map and returns updated map with count of no. friends for each member.
	 * 
	 * @param mapOfMembersToQueryFriendsCountFor
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Map<String, Member> count(Map<String, Member> mapOfMembersToQueryFriendsCountFor)
			throws FileNotFoundException, IOException {
		TimeTracker timeTracker = new TimeTracker();
		timeTracker.start();
		String lineRead = null;
		File graphFile = new File(friendshipGraphFileLocation);
		FileReader graphFileReader = new FileReader(graphFile);
		BufferedReader graphFileBufferedReader = new BufferedReader(graphFileReader, DEFAULT_BUFFER_SIZE);
		Member queryMember = null;
		while (((lineRead = graphFileBufferedReader.readLine()) != null)) {
			Member graphMember = memberBuilder.buildMember(lineRead);
			queryMember = mapOfMembersToQueryFriendsCountFor.get(graphMember.getId());
			if (queryMember != null) {
				queryMember.addNewFriend(graphMember);
			}
		}
		graphFileBufferedReader.close();
		return mapOfMembersToQueryFriendsCountFor;
	}
}

package com.talentica.orkut.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.talentica.orkut.domain.Member;

/**
 * Reader to read members' query file.
 * 
 * @author nitink
 *
 */
public class MembersQueryFileReader {

	private String fileLocation;

	public MembersQueryFileReader(String queryFileLocation) {
		fileLocation = queryFileLocation;
	}

	/**
	 * Reads members information from queries file as a {@link Map} with keys
	 * being identifier of {@link Member}s
	 * 
	 * @return
	 * @throws IOException
	 */
	public Map<String, Member> readAsMap() throws IOException {
		String memberId = null;
		Map<String, Member> membersToGetFriendsCountInformationFor = new HashMap<String, Member>();
		FileReader queriesFileReader = null;
		BufferedReader queriesFileBufferedReader = null;
		try {
			File queriesFile = new File(fileLocation);
			queriesFileReader = new FileReader(queriesFile);
			queriesFileBufferedReader = new BufferedReader(queriesFileReader);
			while ((memberId = queriesFileBufferedReader.readLine()) != null) {
				Member member = new Member(memberId);
				membersToGetFriendsCountInformationFor.put(member.getId(), member);
			}
		} finally {
			if (queriesFileBufferedReader != null) {
				queriesFileBufferedReader.close();
			}
			if (queriesFileReader != null) {
				queriesFileReader.close();
			}
		}
		return membersToGetFriendsCountInformationFor;
	}

}

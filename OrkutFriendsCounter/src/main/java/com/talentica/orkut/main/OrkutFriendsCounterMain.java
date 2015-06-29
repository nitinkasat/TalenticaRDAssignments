package com.talentica.orkut.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import com.talentica.orkut.domain.Member;
import com.talentica.orkut.friends.FriendsCountFileWriter;
import com.talentica.orkut.friends.MembersFriendsCounter;
import com.talentica.orkut.util.MembersQueryFileReader;
import com.talentica.orkut.util.TimeTracker;

/**
 * Main class for Orkut friends counter application.
 * 
 * @author NitinK
 *
 */
public class OrkutFriendsCounterMain {

	private static final String OUTPUT_FILE_NAME = "OrkutFriendCounterResults";

	public static void main(String[] args) throws IOException {
		TimeTracker timeTracker = new TimeTracker();
		timeTracker.start();
		validateArguments(args);
		Map<String, Member> membersToGetFriendsCountInformationFor = readQueriesFile(args);
		Map<String, Member> membersWithUpdatedCountOfFriends = countNoOfFriends(args,
				membersToGetFriendsCountInformationFor);
		writeResultsToOutputFile(args, membersWithUpdatedCountOfFriends);
		timeTracker.stop();
		timeTracker.logTimeElapsedInMilliSeconds("OrkutFriendsCounterMain-main method");
	}

	private static void validateArguments(String[] args) {
		if (args.length != 3) {
			System.err.println("Please pass input friendship grpah file location, queries file location "
					+ "and output folder location arguments " + "e.g. java " + OrkutFriendsCounterMain.class.getName()
					+ " D:/GraphFile/com-orkut.ungraph.txt D:/GraphFile/queries D:/GraphFile/");
			System.exit(1);
		}
	}

	private static Map<String, Member> readQueriesFile(String[] args) throws IOException {
		MembersQueryFileReader queryFileReader = new MembersQueryFileReader(args[1]);
		Map<String, Member> membersToGetFriendsCountInformationFor = queryFileReader.readAsMap();
		return membersToGetFriendsCountInformationFor;
	}

	private static Map<String, Member> countNoOfFriends(String[] args,
			Map<String, Member> membersToGetFriendsCountInformationFor) throws FileNotFoundException, IOException {
		MembersFriendsCounter counter = new MembersFriendsCounter(args[0]);
		Map<String, Member> membersWithUpdatedCountOfFriends = counter.count(membersToGetFriendsCountInformationFor);
		return membersWithUpdatedCountOfFriends;
	}

	private static void writeResultsToOutputFile(String[] args, Map<String, Member> membersWithUpdatedCountOfFriends)
			throws FileNotFoundException, IOException {
		String outputFilePath = args[2] + OUTPUT_FILE_NAME + "_" + new Date().getTime();
		FriendsCountFileWriter countFileWriter = new FriendsCountFileWriter(outputFilePath);
		countFileWriter.write(membersWithUpdatedCountOfFriends);
		System.out.println("Results wrote successfully to: " + outputFilePath);
	}

}

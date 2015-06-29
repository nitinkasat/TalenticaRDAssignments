package com.talentica.orkut.main;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.talentica.orkut.domain.Member;
import com.talentica.orkut.friends.FriendsCounter;

/**
 * Main class for Orkut friends counter application.
 * 
 * @author NitinK
 *
 */
public class OrkutFriendsCounterMain {

	private static final String MEMBER_ID_COUNT_SEPERATOR = " : ";

	private static final String LINE_SEPERATOR = "\n";

	private static final String OUTPUT_FILE_NAME = "OrkutFriendCounterResults";

	public static void main(String[] args) throws IOException {
		if (args.length != 3) {
			System.err
					.println("Please pass input friendship grpah file location, queries file location "
							+ "and output folder location arguments "
							+ "e.g. java "
							+ OrkutFriendsCounterMain.class.getName()
							+ " D:/GraphFile/com-orkut.ungraph.txt D:/GraphFile/queries D:/GraphFile/");
			System.exit(1);
		}
		Map<String, Member> membersToGetFriendsCountInformationFor = readQueriesInputToGetFriendsCountFor(args[1]);
		FriendsCounter counter = new FriendsCounter(args[0]);
		counter.count(membersToGetFriendsCountInformationFor);
		writeFriendsCountResultsToFile(args[2],
				membersToGetFriendsCountInformationFor);
	}

	private static void writeFriendsCountResultsToFile(String outputFolderPath,
			Map<String, Member> results) throws FileNotFoundException,
			IOException {
		FileOutputStream fileOutputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		String outputFilePath = outputFolderPath + OUTPUT_FILE_NAME + "_"
				+ new Date().getTime();
		try {
			File outputFile = new File(outputFilePath);
			fileOutputStream = new FileOutputStream(outputFile);
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			for (Map.Entry<String, Member> entry : results.entrySet()) {
				bufferedOutputStream.write((entry.getKey()
						+ MEMBER_ID_COUNT_SEPERATOR
						+ entry.getValue().getNoOfFriends() + LINE_SEPERATOR)
						.getBytes(StandardCharsets.US_ASCII));
			}
		} finally {
			if (bufferedOutputStream != null) {
				bufferedOutputStream.close();
			}
			if (fileOutputStream != null) {
				fileOutputStream.close();
			}
		}
		System.out.println("Results wrote successfully to: " + outputFilePath);
	}

	private static Map<String, Member> readQueriesInputToGetFriendsCountFor(
			String queryFileLocation) throws IOException {
		String lineRead = null;
		Map<String, Member> membersToGetFriendsCountInformationFor = new HashMap<String, Member>();
		FileReader queriesFileReader = null;
		BufferedReader queriesFileBufferedReader = null;
		try {
			File queriesFile = new File(queryFileLocation);
			queriesFileReader = new FileReader(queriesFile);
			queriesFileBufferedReader = new BufferedReader(queriesFileReader);
			while ((lineRead = queriesFileBufferedReader.readLine()) != null) {
				Member member = new Member(lineRead);
				membersToGetFriendsCountInformationFor.put(member.getId(),
						member);
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

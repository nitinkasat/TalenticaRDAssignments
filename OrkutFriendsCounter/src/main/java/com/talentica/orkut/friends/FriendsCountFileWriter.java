package com.talentica.orkut.friends;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.talentica.orkut.domain.Member;

/**
 * Writes output file with details of count of friends of members.
 * 
 * @author nitink
 *
 */
public class FriendsCountFileWriter {

	private static final String MEMBER_ID_COUNT_SEPERATOR = " : ";

	private static final String LINE_SEPERATOR = "\n";

	private String outputFilePath = null;

	public FriendsCountFileWriter(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	/**
	 * Writes to output file.
	 * 
	 * @param members
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void write(Map<String, Member> members) throws FileNotFoundException, IOException {
		FileOutputStream fileOutputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			File outputFile = new File(outputFilePath);
			fileOutputStream = new FileOutputStream(outputFile);
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			for (Map.Entry<String, Member> entry : members.entrySet()) {
				bufferedOutputStream.write((entry.getKey() + MEMBER_ID_COUNT_SEPERATOR
						+ entry.getValue().getNoOfFriends() + LINE_SEPERATOR).getBytes(StandardCharsets.US_ASCII));
			}
		} finally {
			if (bufferedOutputStream != null) {
				bufferedOutputStream.close();
			}
			if (fileOutputStream != null) {
				fileOutputStream.close();
			}
		}
	}

}

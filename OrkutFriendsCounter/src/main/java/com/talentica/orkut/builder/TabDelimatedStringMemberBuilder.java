package com.talentica.orkut.builder;

import com.talentica.orkut.domain.Member;

/**
 * A member builder which builds {@link Member} objects from tab delimated
 * string text.
 * 
 * @author NitinK
 *
 */
public class TabDelimatedStringMemberBuilder implements MemberBuilder {

	private String TAB = "\t";

	public TabDelimatedStringMemberBuilder() {
	}

	/**
	 * Parses input {@link String} to build a new member.
	 * 
	 */
	public Member buildMember(Object input) {
		Member member = new Member(input.toString().substring(0,
				input.toString().indexOf(TAB)));
		return member;
	}

}

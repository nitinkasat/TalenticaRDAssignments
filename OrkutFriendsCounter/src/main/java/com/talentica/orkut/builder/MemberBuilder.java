package com.talentica.orkut.builder;

import com.talentica.orkut.domain.Member;

/**
 * Member builder interface to build {@link Member}s from different types of
 * inout.
 * 
 * @author NitinK
 *
 */
public interface MemberBuilder {

	/**
	 * 
	 * Builds a new member from passed input.
	 */

	Member buildMember(Object input);

}
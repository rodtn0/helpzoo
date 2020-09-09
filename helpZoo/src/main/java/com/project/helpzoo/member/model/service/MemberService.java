package com.project.helpzoo.member.model.service;

import com.project.helpzoo.member.model.vo.Member;

public interface MemberService {

	/** 로그인 Service
	 * @param member
	 * @return loginMember
	 */
	public abstract Member login(Member member);

	/** 회원가입 Service
	 * @param signUpMember
	 * @return result
	 */
	public abstract int signUp(Member signUpMember);

	/** 아이디 중복 검사 Service
	 * @param memberId
	 * @return result
	 */
	public abstract int idDupCheck(String memberId);

	/** 회원 정보 수정 Service
	 * @param upMember
	 * @return result
	 */
	public abstract int updateMember(Member upMember);

}
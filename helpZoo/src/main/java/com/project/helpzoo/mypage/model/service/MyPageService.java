package com.project.helpzoo.mypage.model.service;

import com.project.helpzoo.member.model.vo.Member;

public interface MyPageService {

	// public abstract (생략 가능)
	
	/** 회원 정보 수정 Service
	 * @param upMember
	 * @return result
	 */
	public abstract int updateMember(Member upMember);

	/** 회원 탈퇴 Service
	 * @param loginMember
	 * @return result
	 */
	public abstract int deleteMember(Member loginMember);

	/** 비밀번호 변경 Service
	 * @param loginMember
	 * @param newPwd1
	 * @return result
	 */
	public abstract int updatePwd(Member loginMember, String newPwd1);

}

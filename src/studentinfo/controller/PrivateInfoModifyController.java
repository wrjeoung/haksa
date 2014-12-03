package studentinfo.controller;

import dao.MemberDao;

public class PrivateInfoModifyController {
	private MemberDao memberDao;

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
}

package member;

import java.util.List;
import java.util.Scanner;

public class MemberService {

	public static Member memberInfo = null;

	Scanner scn = new Scanner(System.in);

	// 로그인
	public void doLogin() {
		Member member = null;

		System.out.println("ID>");

		String id = scn.nextLine();

		System.out.println("PW>");

		String pw = scn.nextLine();

		member = MemberManage.getInstance().loginInfo(id);

		if (member.getMemberPw().equals(pw)) {
			memberInfo = member;
		} else {
			System.out.println("로그인 실패");
		}
	}

	// 로그아웃
	public void logout() {
		if (memberInfo != null)
			memberInfo = null;
	}

	// 회원 등록
	public void registerMember() {
		Member member = new Member();

		System.out.println("고객 ID>");
		String id = scn.nextLine();
		System.out.println("고객 PW>");
		String pw = scn.nextLine();
		System.out.println("고객 이름>");
		String name = scn.nextLine();
		System.out.println("고객 번호>");
		String tel = scn.nextLine();
		System.out.println("고객 등급>");
		String grade = scn.nextLine();
		System.out.println("포인트 적립율");
		String bonusRat = scn.nextLine();
		
		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberName(name);
		member.setMemberTel(tel);
		member.setMemberGrade(grade);
		member.setMemeber_bonusRat(0);
		member.setRole("0");

		int result = MemberManage.getInstance().registMember(member);

		if (result == 1) {
			System.out.println("고객 정보 등록 완료");
		} else {
			System.out.println("고객 정보 등록 실패");
		}
	}
	
	// 회원 전체 조회
	public void detailMemberList() {
		System.out.println("회원 전체 조회");
		List<Member> list = MemberManage.getInstance().getDetailMemberList();
		for(Member member : list) {
			System.out.println("=================================");
			System.out.println("| 회원 아이디 : " + member.getMemberId());
			System.out.println("| 회원 비밀번호 : " + member.getMemberPw());
			System.out.println("| 회원 이름 : " + member.getMemberName());
			System.out.println("| 회원 전화번호 : " + member.getMemberGrade());
			System.out.println("| 회원 적립률 : " + member.getMemeber_bonusRat() );
		}
	}
	
	// 회원 이름 조회
		public void MemberList() {
			System.out.println("회원 단건 조회");
			List<Member> list = MemberManage.getInstance().getDetailMemberList();
			for(Member member : list) {
				System.out.println("=================================");
				System.out.println("| 회원 아이디 : " + member.getMemberId());
				System.out.println("| 회원 비밀번호 : " + member.getMemberPw());
				System.out.println("| 회원 이름 : " + member.getMemberName());
				System.out.println("| 회원 전화번호 : " + member.getMemberGrade());
				System.out.println("| 회원 적립률 : " + member.getMemeber_bonusRat() );
			}
		}
	
		
	
}
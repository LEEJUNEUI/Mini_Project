package member;

import java.util.List;
import java.util.Scanner;

public class MemberService {

	public static Member memberInfo = null;

	Scanner scn = new Scanner(System.in);

	int menuNo = 0;

	// 로그인
	public void doLogin() {
		Member member = null;

		System.out.println("|1. 로그인 | 2. 종료 |");
		menuNo = Integer.parseInt(scn.nextLine());
		switch (menuNo) {
		case 1:
			System.out.println("ID>");

			String id = scn.nextLine();

			System.out.println("PW>");

			String pw = scn.nextLine();

			member = MemberManage.getInstance().loginInfo(id);

			if (MemberManage.mem.getMemberPw().equals(pw)) {
				memberInfo = MemberManage.mem;
			}
			break;
		case 2:
			System.out.println("===========");
			System.out.println("|프로그램 종료|");
			System.out.println("===========");
			break;
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
		System.out.println("고객 전화번호>");
		String tel = scn.nextLine();
		System.out.println("고객 등급>");
		String grade = scn.nextLine();
		System.out.println("고객 할인율>");
		double saleRat = Double.parseDouble(scn.nextLine());

		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberName(name);
		member.setMemberTel(tel);
		member.setMemberGrade(grade);
		member.setMember_saleRat(saleRat);
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
		for (Member member : list) {
			System.out.println("=================================");
			System.out.println("| 회원 아이디 : " + member.getMemberId());
			System.out.println("| 회원 비밀번호 : " + member.getMemberPw());
			System.out.println("| 회원 이름 : " + member.getMemberName());
			System.out.println("| 회원 전화번호 : " + member.getMemberTel());
			System.out.println("| 회원 등급 : " + member.getMemberGrade());
			System.out.println("| 회원 적립률 : " + member.getMember_saleRat());
		}
	}

	// 회원 이름 조회
	public void MemberList() {
		System.out.println("회원 단건 조회");
		System.out.println("회원 이름>");
		String name = scn.next();

		List<Member> list = MemberManage.getInstance().getMemberList(name);
		for (Member member : list) {
			System.out.println("===============================================");
			System.out.println("| 회원 아이디 : " + member.getMemberId());
			System.out.println("| 회원 비밀번호 : " + member.getMemberPw());
			System.out.println("| 회원 이름 : " + member.getMemberName());
			System.out.println("| 회원 전화번호 : " + member.getMemberTel());
			System.out.println("| 회원 등급 : " + member.getMemberGrade());
			System.out.println("| 회원 할인율 : " + member.getMember_saleRat());
		}
	}

	// 회원 등급 조회
	public void MemberGrade() {
		System.out.println("회원 등급 조회");
		System.out.println("회원 이름>");
		String grade = scn.next();

		List<Member> list = MemberManage.getInstance().getMemberGrade(grade);
		for (Member member : list) {
			System.out.println("===============================================");
			System.out.println(member.getMemberName() + "님의 등급은 " + member.getMemberGrade() + "이며, 할인율은 "
					+ member.getMember_saleRat() + "% 입니다.");
		}
	}

	// 회원 등급 변경
	public void updateGrade() {
		Member member = new Member();
		System.out.println("수정할 회원 ID : ");
		String memberId = scn.nextLine();

		System.out.println("등급 변경 : ");
		String memberGrade = scn.nextLine();

		System.out.println("할인율 변경 : ");
		double saleRat = Double.parseDouble(scn.nextLine());

		member.setMemberId(memberId);
		member.setMemberGrade(memberGrade);
		member.setMember_saleRat(saleRat);
		int result = MemberManage.getInstance().updateGrade(member);

		if (result == 1) {
			System.out.println("등급 수정 완료");
		} else {
			System.out.println("등급 수정 실패");
		}
	}

	// 회원 삭제
	public void DeleteMember() {
		System.out.println("삭제할 ID>");
		String memberId = scn.nextLine();

		int result = MemberManage.getInstance().deleteMember(memberId);
		if (result == 1) {
			System.out.println("회원 정상 삭제");
		} else {
			System.out.println("회원 삭제 실패");
		}
	}
}

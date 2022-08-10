package WineExe;

import java.util.Scanner;

import Wine.WineDAO;
import Wine.WineService;
import member.MemberManage;
import member.MemberService;

public class ManageMent {

	Scanner scn = new Scanner(System.in);

	MemberService ms = new MemberService();
	WineService ws = new WineService();

	int menuNo = 0;

	boolean run = true;

	public ManageMent() {
		WineBar();
	}

	private void WineBar() {
		while (true) {
			if (MemberService.memberInfo.getRole().equals("1")) {
				menuInfo();
			}
		}
	}

	private void menuInfo() {
		if (MemberService.memberInfo.getRole().equals("1")) {

			System.out.println("================================================");
			System.out.println("| 1. 회원관리 | 2. 와인관리 | 3. 예약관리 4. 프로그램 종료 |");
			System.out.println("================================================");
			System.out.println("선택> ");

			while (run) {
				int selectNo = Integer.parseInt(scn.nextLine());

				switch (selectNo) {
				case 1:
					System.out.println("| 1. 회원 조회 | 2. 회원 등록 | 3. 회원 수정 | 4. 회원 삭제 |");
					System.out.println("입력>");
					menuNo = Integer.parseInt(scn.nextLine());
					if (menuNo == 1) {
						// 회원 조회
						System.out.println("| 1.회원 전체 조회 | 2.회원 단건 조회 |");
						System.out.println("조회할 번호>");
						menuNo = Integer.parseInt(scn.nextLine());
						switch (menuNo) {
						case 1:
							System.out.println("회원 전체 조회");
							ms.detailMemberList();
							break;
						case 2:
							System.out.println("회원 단건 조회");

							break;
						}
					} else if (menuNo == 2) {
						// 회원 등록
						ms.registerMember();
					} else if (menuNo == 3) {
						// 회원 수정
						MemberManage.getInstance().updateGrade();
					} else if (menuNo == 4) {
						// 회원 삭제
						MemberManage.getInstance().deleteMember();
					}
					break;
				case 2:
					System.out.println("| 1. 와인 등록 | 2. 와인 조회 | 3. 와인 판매 | 4. 와인 수정 | 5. 와인 매출 | 6. 와인 삭제 |");
					System.out.println("입력>");
					menuNo = Integer.parseInt(scn.nextLine());
					if (menuNo == 1) {
						// 와인 등록
						ws.insertWine();
					} else if (menuNo == 2) {
						// 와인 조회
						System.out.println("| 1.국가별 조회 | 2. 품종별 조회 | 3. 타입별 조회 | 4. 가격별 조회 | 5. 상세 조회 |");
						System.out.println("조회할 번호>");
						menuNo = Integer.parseInt(scn.nextLine());
						switch (menuNo) {
						case 1:
							ws.getCountry();
							break;
						case 2:
							ws.getVarieties();
							break;
						case 3:
							ws.getType();
							break;
						case 4:
							ws.getPrice();
							break;
						case 5:
							ws.getDetailWine();
							break;
						}
					} else if (menuNo == 3) {
						// 와인 판매
						ws.salesWine();
					} else if (menuNo == 4) {
						// 와인 수정
						ws.changeWine();
					} else if (menuNo == 5) {
						// 와인 매출
						ws.calWine();
					} else if (menuNo == 6) {
						// 와인 삭제
						ws.deleteWine();
					}
					break;
				case 3:
					System.out.println("| 1. 예약 조회 | 2. 예약 등록 | 3. 예약 변경 | 4. 시간표 변경");
					System.out.println("입력>");
					menuNo = Integer.parseInt(scn.nextLine());
					break;
				case 4:
					System.out.println("프로그램 종료");
					break;
				}
				break;
			}
		} else if (MemberService.memberInfo.getRole().equals("0")) {
			System.out.println("| 1. 와인 조회 | 2. 고객 등급 조회 | ");
			menuNo = Integer.parseInt(scn.nextLine());
			switch (menuNo) {
			case 1:
				System.out.println("| 1.국가별 조회 | 2. 품종별 조회 | 3. 타입별 조회 | 4. 가격별 조회 | 5. 상세 조회 |");
				System.out.println("조회할 번호>");
				menuNo = Integer.parseInt(scn.nextLine());
				switch (menuNo) {
				case 1:
					ws.getCountry();
					break;
				case 2:
					ws.getVarieties();
					break;
				case 3:
					ws.getType();
					break;
				case 4:
					ws.getPrice();
					break;
				case 5:
					ws.getDetailWine();
					break;
				}
				break;
			case 2:
				System.out.println("고객님의 등급은 " + MemberManage.getInstance().getMemberGrade() + "입니다.");
				break;

			}
		}
	}
}

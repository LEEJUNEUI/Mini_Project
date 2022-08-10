package WineExe;

import java.util.Scanner;

import Wine.WineDAO;
import Wine.WineService;
import member.MemberManage;
import member.MemberService;

public class Application {

	Scanner scn = new Scanner(System.in);

	MemberService ms = new MemberService();
	WineService ws = new WineService();

	int menuNo = 0;

	public Application() {
		start();

	}

	private void start() {
		ms.doLogin();
		if (MemberService.memberInfo != null) {
			new ManageMent();
		}
		while (true) {
			System.out.println(
					"| 1. 회원 조회 | 2. 회원 등록 | 3. 회원 수정 | 4. 회원 삭제 | 5. 와인 등록 | 6. 와인 조회 | 7. 와인 판매 | 8. 와인 수정 | 9. 와인 매출 | 10. 와인 삭제 | 11. 예약 | 12. 종료");
			int menuNo = Integer.parseInt(scn.nextLine());

			if (menuNo == 1) {
				// 회원 조회
				System.out.println("| 1. 전체 조회 | 2. 단건 조회 |");
				System.out.println("조회할 번호>");
				menuNo = Integer.parseInt(scn.nextLine());

				switch (menuNo) {
				case 1:
					ms.detailMemberList();
					break;
				case 2:
					
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
			} else if (menuNo == 5) {
				// 와인 등록
				ws.insertWine();
			} else if (menuNo == 6) {
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
			} else if (menuNo == 7) {
				// 와인 판매
				ws.salesWine();
			} else if (menuNo == 8) {
				// 와인 수정
				ws.changeWine();
			} else if (menuNo == 9) {
				// 와인 매출
				ws.calWine();
			} else if (menuNo == 10) {
				// 와인 삭제
				ws.deleteWine();
			} else if (menuNo == 11) {
				// 와인 예약
			} else if (menuNo == 12) {
				System.out.println("프로그램 종료");
				break;
			}
			break;
		}
	}
}

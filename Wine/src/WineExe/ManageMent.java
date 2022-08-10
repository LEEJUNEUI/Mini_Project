package WineExe;

import java.util.Scanner;

import member.MemberService;

public class ManageMent {

	Scanner scn = new Scanner(System.in);
	
	MemberService ms = new MemberService();
	
	int menuNo = 0;
	boolean run = true;
	
	public ManageMent() {
		WineBar();
	}
	
	private void WineBar() {
		while (true) {
			menuInfo();
			if(MemberService.memberInfo.getRole().equals("1")) {
				if(menuNo == 1) {
					// 회원 조회
					
				}else if(menuNo == 2) {
					// 회원 등록
				}else if(menuNo == 3) {
					// 회원 수정
				}else if(menuNo == 4) {
					// 회원 삭제
				}else if(menuNo == 5) {
					// 와인 등록
				}else if(menuNo == 6) {
					// 와인 조회
				}else if(menuNo == 7) {
					// 와인 판매
				}else if(menuNo == 8) {
					// 와인 수정
				}else if(menuNo == 9) {
					// 와인 매출
				}else if(menuNo == 10) {
					// 와인 삭제
				}else if(menuNo == 11) {
					// 예약
				}
			}
		}
	}
	
	private void menuInfo() {
		if(MemberService.memberInfo.getRole().equals("1")) {
			
			while (run) {
				System.out.println("=====================================");
				System.out.println("| 1. 회원관리 | 2. 와인관리 | 3. 예약관리 |");
				System.out.println("=====================================");
				System.out.println("선택> ");
				int selectNo = Integer.parseInt(scn.nextLine());
				
				switch (selectNo) {
				case 1:
					System.out.println("| 1. 회원 조회 | 2. 회원 등록 | 3. 회원 수정 | 4. 회원 삭제 |");
					break;
				case 2:
					System.out.println("| 1. 와인 등록 | 2. 와인 조회 | 3. 와인 판매 | 4. 와인 수정 | 5. 와인 매출 | 6. 와인 삭제 |");
					break;
				case 3:
					System.out.println("| 1. 예약 조회 | 2. 예약 등록 | 3. 예약 변경 | 4. 시간표 변경");
					break;
				}
			}
		}
		else if (MemberService.memberInfo.getRole().equals("0")) {
			System.out.println("| 1. 와인 조회 | 2. 고객 등급 조회 | ");
		}
		System.out.println("입력>");
		menuNo = Integer.parseInt(scn.nextLine());
	}
		
}

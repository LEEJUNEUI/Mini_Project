package WineExe;

import java.util.Scanner;

import Wine.WineService;
import member.MemberService;
import reservation.RsService;

public class ManageMent {

	Scanner scn = new Scanner(System.in);

	MemberService ms = new MemberService();
	WineService ws = new WineService();
	RsService rs = new RsService();

	int menuNo = 0;

	public ManageMent() {
		while(true) {
			WineBar();
		}
	}

	private void WineBar() {
		boolean run = true;
		ms.doLogin();
		while (run) {
			if (MemberService.memberInfo != null) {

				if (MemberService.memberInfo.getRole().equals("1")) {

					System.out.println("============================================");
					System.out.println("| 1. 회원관리 | 2. 와인관리 | 3. 예약관리 4. 로그아웃 |");
					System.out.println("============================================");
					System.out.println("선택> ");
					int selectNo = Integer.parseInt(scn.nextLine());

					switch (selectNo) {
					case 1:
						boolean run1 = true;
						while (run1) {
							System.out.println("| 1. 회원 조회 | 2. 회원 등록 | 3. 회원 수정 | 4. 회원 삭제 | 5. 첫 메뉴 이동 |");
							System.out.println("입력>");
							menuNo = Integer.parseInt(scn.nextLine());

							if (menuNo == 1) {
								// 회원 조회
								System.out.println("| 1.회원 전체 조회 | 2.회원 단건 조회 | 3.회원 등급 조회");
								System.out.println("조회할 번호>");
								menuNo = Integer.parseInt(scn.nextLine());
								switch (menuNo) {
								case 1:
									ms.detailMemberList();
									break;
								case 2:
									ms.MemberList();
									break;
								case 3:
									ms.MemberGrade();
									
								}
								
							} else if (menuNo == 2) {
								// 회원 등록
								ms.registerMember();
							} else if (menuNo == 3) {
								// 회원 수정
								ms.updateGrade();
							} else if (menuNo == 4) {
								// 회원 삭제
								ms.DeleteMember();
							} else if (menuNo == 5) {
								System.out.println("첫 메뉴 이동");
								run1 = false;
							}
						}
						break;

					case 2:
						boolean run2 = true;
						while (run2) {

							System.out.println(
									"| 1. 와인 등록 | 2. 와인 조회 | 3. 와인 판매 | 4. 와인 수정 | 5. 와인 매출 | 6. 와인 삭제 | 7. 첫 메뉴 이동 |");
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
							} else if (menuNo == 7) {
								// 메뉴 이동
								System.out.println("첫 메뉴 이동");
								run2 = false;
							}
						}
						break;

					case 3:
						boolean run3 = true;
						while (run3) {

							System.out.println("| 1. 예약 조회 | 2. 예약 등록 | 3. 예약 취소 | 4. 첫 메뉴 이동 |");
							System.out.println("입력>");
							menuNo = Integer.parseInt(scn.nextLine());
							if (menuNo == 1) {
								// 예약 조회
								rs.RsMemberList();

							} else if (menuNo == 2) {
								// 예약 등록
								rs.registerRsMember();

							} else if (menuNo == 3) {
								// 예약 취소
								rs.DeleteReserve();
							} else if (menuNo == 4) {
								// 메뉴 이동
								System.out.println("첫 메뉴 이동");
								run3 = false;
							}
						}
						break;
					case 4:
						System.out.println("로그아웃");
						run = false;
						break;
					}
				} else if (MemberService.memberInfo.getRole().equals("0")) {
					System.out.println("| 1. 와인 조회 | 2. 고객 등급 조회 | 3. 와인 구매 | 4. 로그아웃");
					menuNo = Integer.parseInt(scn.nextLine());
					switch (menuNo) {
					case 1:
						boolean run4 = true;
						while (run4) {
							System.out.println(
									"| 1.국가별 조회 | 2. 품종별 조회 | 3. 타입별 조회 | 4. 가격별 조회 | 5. 상세 조회 | 6. 첫 메뉴 이동 |");
							System.out.println("조회할 번호>");
							menuNo = Integer.parseInt(scn.nextLine());
							if (menuNo == 1) {
								ws.getCountry();
							} else if (menuNo == 2) {
								ws.getVarieties();
							} else if (menuNo == 3) {
								ws.getType();
							} else if (menuNo == 4) {
								ws.getPrice();
							} else if (menuNo == 5) {
								ws.getDetailWine();
							} else if (menuNo == 6) {
								System.out.println("첫 메뉴 이동");
								run4 = false;
							}
						}
						break;
					case 2:
						ms.MemberGrade();
						break;
					case 3:
						ws.salesWine();
						break;
					case 4:
						System.out.println("로그아웃");
						run = false;
						break;
					}
				}
			}
		}
	}
}

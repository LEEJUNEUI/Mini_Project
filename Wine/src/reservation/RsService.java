package reservation;

import java.util.List;
import java.util.Scanner;

import member.Member;
import member.MemberManage;

public class RsService {

	Scanner scn = new Scanner(System.in);

	// 예약 손님 전체 조회
	public void RsMemberList() {
		System.out.println("회원 전체 조회");
		List<Reservation> list = RsManage.getInstance().getRsMemberList();

		for (Reservation reservation : list) {
			System.out.println("=================================");
			System.out.println("| 회원 이름 : " + reservation.getRsMemberName());
			System.out.println("| 회원 전화번호 : " + reservation.getRsMemberTel());
		}
	}

	// 예약 손님 등록
	public void registerRsMember() {
		Reservation reservation = new Reservation();

		System.out.println("예약 손님 이름>");
		String name = scn.nextLine();
		System.out.println("예약 손님 번호>");
		String tel = scn.nextLine();

		reservation.setRsMemberName(name);
		reservation.setRsMemberTel(tel);

		int result = RsManage.getInstance().registRsMember(reservation);

		if (result == 1) {
			System.out.println("예약 손님 등록 완료");
		} else {
			System.out.println("예약 손님 등록 실패");
		}
	}
	
	// 예약 취소
		public void DeleteReserve() {
			System.out.println("예약 취소할 이름>");
			String RsmemberName = scn.nextLine();

			int result = RsManage.getInstance().deleteReserve(RsmemberName);
			if (result == 1) {
				System.out.println("예약 정상 취소");
			} else {
				System.out.println("예약 취소 실패");
			}
		}
	
}

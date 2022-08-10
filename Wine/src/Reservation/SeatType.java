package Reservation;

import java.util.Scanner;

public class SeatType {
	Scanner scn = new Scanner(System.in);

	private char type;
	private Seat[] aSeat;

	// 생성자
	public SeatType(char type, int num) {
		this.type = type;
		aSeat = new Seat[num];

		for (int i = 0; i < aSeat.length; i++) {
			aSeat[i] = new Seat();
		}
	}

	// 메소드
	public boolean seatReserve() {
		show();
		System.out.println("이름 : ");
		String name = scn.nextLine();
		System.out.println("좌석 번호 : ");
		int seatNum = scn.nextInt();

		if (seatNum < 1 || seatNum > aSeat.length) {
			System.out.println("잘못된 좌석번호 입니다.");
			return false;
		}
		if (aSeat[seatNum - 1].isOccupeied()) {
			System.out.println("이미 예약된 좌석번호 입니다.");
			return false;
		}
		aSeat[seatNum - 1].reserveName(name);
		return true;
	}

	public boolean cancel() {
		show();
		System.out.println("이름 :");
		String name = scn.nextLine();

		if (name != null) {
			for (int i = 0; i < aSeat.length; i++) {
				if (aSeat[i].match(name)) {
					aSeat[i].cancel();
					return true;
				}
			}
			System.out.println("예약자 이름을 찾을 수 없습니다.");
		}
		return false;
	}

	public void show() {
		System.out.println(type + "석 예약 : ");

		for (int i = 0; i < aSeat.length; i++) {
			if (aSeat[i].isOccupeied())
				System.out.println(aSeat[i].getName());
			else
				System.out.println("---");
			System.out.println(" ");
		}
		System.out.println();
	}
}
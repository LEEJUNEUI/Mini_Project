package Reservation;

import java.util.Scanner;

public class Reservation extends Seat{
	public static void main(String[] args) {
        SeatType[] aSeatType = new SeatType[4];

        aSeatType[0] = new SeatType('P',10);     // 플레티넘 등급석
        aSeatType[1] = new SeatType('G',20);     // 골드 등급석
        aSeatType[2] = new SeatType('S',30);     // 실버 등급석
        
        int choice = 0 ;

        while(choice != 4 ) {
            int type;
            System.out.println("=============== 메인 메뉴 =============== ");
            System.out.println(" 다음 중 하나의 메뉴를 선택하세요.");
            System.out.println(" 1. 예약");
            System.out.println(" 2. 조회");
            System.out.println(" 3. 취소");
            System.out.println(" 4. 종료");
            System.out.println(" 선택하세요 >>>>> ");

            Scanner scn = new Scanner(System.in);
            choice = scn.nextInt();

            switch (choice) {
                case 1: // 예약
                    System.out.println("<좌석 구분>");
                    System.out.println("1. P석 (5석)");
                    System.out.println("2. G석 (10석)");
                    System.out.println("3. S석 (20석)");

                    type = scn.nextInt();

                    if (type < 1 || type > 3) {
                        System.out.println("예약시 잘못된 자석 타입 입니다.");
                        break;
                    }
                    aSeatType[type - 1].seatReserve();
                    break;
                case 2:  // 조회
                    for (int i=0; i<aSeatType.length; i++) {
                        aSeatType[i].show();
                    }
                    System.out.println("조회를 완료하였습니다.");
                    break;
                case 3: // 취소
                     System.out.println("<좌석 구분>");
                     System.out.println("1. P석 (5석)");
                     System.out.println("2. G석 (10석)");
                     System.out.println("3. S석 (20석)");
                     
                     type = scn.nextInt();

                     if(type < 1 || type > 3) {
                         System.out.println("취소시 잘못된 자석 타입입니다");
                         break;
                     }
                     aSeatType[type-1].cancel();
                     break;
                case 4:  // 종료
                    break;

                default:
                    System.out.println("메뉴를 잘못 입력했습니다.");
            }
        }
    }
}

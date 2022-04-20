package ch05_controll;

import java.util.Scanner;

public class Loopwhile {

	public static void main(String[] args) {
		// while 문
		
		int i = 0;					//초기화식
		while(i < 10) {				// 조건식
			System.out.println(i);
			i++;					// 증감식
		}
		
		// for문과 비슷
		// 구구단 2단 출력을 while문으로 작성
		// 2x2 = 4
		// 2x3 = 6
		// 2x9 = 18
		
		int j = 1;
		while(j <= 9) {
			System.out.println("2x"  + j + "=" + (2*j));
			j++;
		}
		
		System.out.println("\n============================================\n");
		
		boolean isRun = true;
		Scanner sc = new Scanner(System.in);
		
//		while(isRun) {
//			System.out.println("이름 입력[종료하시려면 q 또는 Q입력]");
//			System.out.print(">>>");
//			
//			String inputText = sc.nextLine();
//			
//			if(inputText.contentEquals("q") || inputText.equals("Q")) {
//				System.out.println("프로그램을 종료합니다.");
//				isRun = false;
//			} else {
//				System.out.println(inputText + "님 환영합니다.");
//		}
	
//	}
//		while(true) {
//			System.out.println("이름 입력[종료하려면 q 또는 Q]");
//			System.out.print(">>>");
//			
//			String inputText = sc.nextLine();
//			
//			// inputText.toLowerCase().equals("q")
//			if(inputText.equalsIgnoreCase("q")) {
//				System.out.println("프로그램 종료");
//				break;
//			} 
//				System.out.println(inputText + "님 환영합니다~");
//			}
//		
//		System.out.println("\n=====================================\n");
//		
//		isRun = false;
		
		// do-while문
		isRun = false;
		
		do {
			System.out.println("이름 입력[종료하려면 q 또는 Q]");
			System.out.print(">>>");
			
			String inputText = sc.nextLine();
			
			// inputText.toLowerCase().equals("q")
			if(inputText.equalsIgnoreCase("q")) {
				System.out.println("프로그램 종료");
				break;
			} 
				System.out.println(inputText + "님 환영합니다~");
		} while(isRun);
		
		System.out.println("\n================================================\n");
		
		// while문 또한 다중으로 사용가능
		// 구구단
		// 2 x 2 = 4
		// 2 x 3 = 6
		// 2 x 9 = 18
		// 3 x 2 = 6
		// 3 x 3 = 9
		// 9 x 9 = 81
		// while문 2개를 이용해서
		
		
		int left = 2;
		while(left <= 9) {
			int right = 2;
			while(right <= 9) {
			System.out.println(left + " x " + right + " = " + (left * right));
			right++;
		}
		left++;
		}
		
		// 포켓몬스터
		int enemyHp = 100;
		outer: while(true) {
			System.out.println("야생의 파이리를 만났습니다.");
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 공격 | 2. 도망");
			System.out.println(">>>" );
			
			int command = Integer.parseInt(sc.nextLine());
			
			if(command == 1) {
				while(true) {
					System.out.println("공격 방법 선택");
					System.out.println("1. 백만볼트 | 2. 전광석화 | 3. 취소");
					System.out.print(">>> ");
					
					int attack = Integer.parseInt(sc.nextLine());
				
					if (attack == 1) {
						System.out.println("피카츄 백만볼트!!");
						enemyHp -= 20;
					}else if(attack == 2) {
						System.out.println("피카츄 전광석화!!");
						enemyHp -= 10;
					}else if(attack == 3) {
						// 내부 while문 종료
						// 외부 while문은 계속 실행
						break;
					}
					
					// 파이리 꺠꼬닥
					if(enemyHp <= 0) {
						System.out.println("파이리를 잡았다!!");
						System.exit(0);			// 프로그램 종
						break outer; 			// 외부 while문 종료
						
					}
					
				}
			
			}else if(command == 2) {
				System.out.println("도망쳤습니다.");
				break;
			}
			
		}
		
	}
}

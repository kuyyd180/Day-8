package dallhyun.submit05;

import java.util.Scanner;

public class UPDown {

	public static void main(String[] args) {

		
		  // 랜덤한 수 얻기 // System.out.println(Math.random());
		  
		  // Math.random()은 0 ~ 1 사이의 랜덤 실수 리턴 // Math.random() * 10은 0 ~ 10 사이의 랜덤 실수
		  // (int) (Math.random() * 10)은 0 ~ 9중 랜덤 정수 // 1부터 50까지 중 랜덤한 정수를 얻고 싶다 //
		  //(int) (Math.random() * 50) + 1
		 
		  int randInt = (int)(Math.random() * 45) +1; System.out.println(randInt);
		  
		  int life = 5;
		  
		  while(true) {
			  	Scanner sca = new Scanner(System.in);
			  	System.out.print("숫자를 입력해주세요 : "); 
		     	int botten = Integer.parseInt(sca.nextLine());
				
		     if (botten == randInt) { 
			  System.out.println("정답입니다."); break; 
			// 5번 기회 } else
		    }
		    if (botten <= randInt) { 
			  	life -= 1; 
			  	System.out.println("업!! 기회가" + life + "번 남았습니다."); 
			} else if (botten >= randInt) { 
				  life -= 1;
				  System.out.println("다운!! 기회가" + life + "번 남았습니다."); 
			}
		    
		  // 실패시 문자
		  if (life == 0) { 
			  System.out.println("실패! 정답은: " + randInt + "입니다."); 
			  break; 
		  }
	  }
			
		  System.out.println("\n===========================================\n");
		// 랜덤 엘리베이터
		// 1. 사용자의 현재 위치를 입력하면 사용자의 위치와 가까운 엘리베이터가 이동한다.
		// 2. 사용자의 위치와 두 엘리베이터의 위치 차이가 동일하다면 위 층 엘리베이터가 내려온다.
		// 3. 사용자의 위치로 엘리베이터의 위치를 바꿔준다.
		// 4. 엘리베이터 프로그램을 종료하려면 q, Q, exit, EXIT, Exit 중 하나를 입력한다.
	
		int ele1 = (int) (Math.random() * 10) + 1;
		int ele2 = (int) (Math.random() * 10) + 1;
		
		System.out.println("승강기 A의 현재위치: " + ele1 + "층");
		System.out.println("승강기 B의 현재위치: " + ele2 + "층");

		while (true) {
			System.out.println("\n=========== 희영빌딩 엘리베이터 =============\n");

			// 엘리베이터 현재 랜덤위치
			System.out.println("승강기 A의 현재위치: " + ele1 + "층");
			System.out.println("승강기 B의 현재위치: " + ele2 + "층");

			// 1. 사용자의 현재 위치를 입력하면 사용자의 위치와 가까운 엘리베이터가 이동한다.

			Scanner sca = new Scanner(System.in);
			System.out.print("몇층에 계시나요? [종료하시려면 q 또는 exit 입력: ");
			int Elebotten = Integer.parseInt(sca.nextLine());
		

			if (ele1 < Elebotten)  {
				System.out.println(ele1 + "층에서 엘리베이터를 호출합니다.");
				ele1 = Elebotten;
			} else if (ele1 < Elebotten)  {
				System.out.println(ele1 + "층에서 엘리베이터를 호출합니다.");
				ele1 = Elebotten;
			} else if (ele1 > Elebotten)  {
				System.out.println(ele1 + "층에서 엘리베이터를 호출합니다.");
				ele1 = Elebotten;
			} else if (ele2 > Elebotten) {
				System.out.println(ele2 + "층에서 엘리베이터를 호출합니다.");
				ele2 = Elebotten;
			} else if (ele1 > Elebotten)  {
				System.out.println(ele1 + "층에서 엘리베이터를 호출합니다.");
				ele1 = Elebotten;
			} 
			
			
			
			
			
			// 2. 사용자의 위치와 두 엘리베이터의 위치 차이가 동일하다면 위 층 엘리베이터가 내려온다.
			if (ele1 == ele2) {
				System.out.println(ele1 + "층에서 엘리베이터를 호출합니다.");
				ele1 = Elebotten;
			}

		

			
		}
		
	}
}


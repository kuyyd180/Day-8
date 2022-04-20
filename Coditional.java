package ch05_controll;

public class Coditional {
	
	String title = "캡틴";

	public static void main(String[] args) {
		// 조건문
		
		// if문
		int price= 30000;
		int myMoney = 10000;
		
		if (myMoney < price) {
				System.out.println("돈이 부족합니다.");
			}
		
		if(myMoney < price) {System.out.println("돈이 부족합니다.");}
		
		// 블록{} 안 명령어가 한줄이면
		// 블록을 생략할 수 있다.
		if(myMoney < price) System.out.println("돈이 부족합니다.");
		
		System.out.println("\n==============================================\n");
		
		// 변수의 사용범위(Scope)
		String review = "맛있어요~";
		String warning = "";
		if(review.length() < 12) {
			warning = "리뷰는 12글자 이상 작성하세요.";
		}
		
		// 블록 {} 중괄호 안에 선언된 변수는
		// 해당 중괄호 바깥에선 사용할 수 없다(지역 변수)
		// 전역 변수: class 중괄호 안에서 선언된 변수
		// 해당 클래스 내 어디서든 사용이 가능하다.
		
		System.out.println("리뷰:" + review);
		System.out.println("결과:" + warning);
		
		System.out.println("\n==============================================\n");
		
		int intVal = 0;
		
		if (intVal < 0) {
			System.out.println("intVal가 0보다 작다.");
		} else {
			System.out.println("intVal가 0보다 같거나 크다.");
		}
		
		if(intVal < 0) {
			System.out.println("intVal가 0보다 작다.");
			}else if(intVal == 0) {
				System.out.println("intVal가 0이다.");
			}else {
				System.out.println("intVal가 0보다 크다.");
		
				System.out.println("\n==============================================\n");
				
				// 웹 브라우저에서 사용자가 로그인을 하면
				// 해당 브러우저의 세션 스토리지에 로그인 정보를 저장하는데, 이 정보를 이용해서
				// 로그인 된 화면 혹은 로그인하지 않은 화면을 다르게 보여준다.
				
				String userInfo = "akow283";
				
				if(userInfo != null) {
					System.out.println("로그인 상태의 화면을 보여준다.");
				}else {
					System.out.println("로그인 화면으로 이동시킨다.");
				}
				
				// 리모콘의 전원 버튼의 경우
				// 버튼 하나로 on/off가 다 가능하다.
				boolean isPowerOn = false;
				
				// 전원 버튼을 눌렀을때의 로직
				if(isPowerOn) {
					System.out.println("TV를 끕니다.");
					isPowerOn = false;
				}else {
					System.out.println("TV를 켭니다.");
					isPowerOn = true;
				}
				if(isPowerOn) {
					System.out.println("TV를 끕니다.");
					isPowerOn = false;
				}else {
					System.out.println("TV를 켭니다.");
					isPowerOn = true;
				}
			}
				// boolean의 true/false를 스위치의 on/off 처럼 사용하는 boolean 변수를
				// 토글(toggle) 혹은 플래그 (flag)라고 한다.
				
				System.out.println("\n==============================================\n");
			
				// 주민번호 뒷자리의 첫번째 숫자로 성별구분
				String idBack = "1342352";
				int first = Integer.parseInt(idBack.substring(0,1));
				
				if(first % 2 == 1) {
					System.out.println("남자");
				} else if (first % 2 == 0) {
					System.out.println("여자");
				}
				
				// 이중 삼항 연산자 썼던거
				int score = 85;
				String grade = "C";
				
				if(score > 90) {
					grade = "A";
				} else if(score > 80) {
					grade = "B";
 				}
				
				System.out.println("등급:" + grade);
				
				score = 92;
				// 범위를 명확히 하거나, 순서를 잘 고려해주세요.
				if(score > 80 && score <= 90) {
					grade = "B";
				}else if (score > 90) {
					grade = "A";
				}
				System.out.println("등급:" + grade);
	
				System.out.println("\n==============================================\n");
				
				// 회원가입 조건 체크
				String name = "길동이";
				String phone ="01034355435";
				int age = 20;
				
				// level 1
				if(!name.isEmpty()) {
					if((phone.length() == 10 || phone.length() == 11)) {
						if(age >= 14) {
							System.out.println("회원가입 성공");
						} else {
							System.out.println("회원가입 불가");
						}
					}else {
						System.out.println("회원가입 불가");
					}
						
				}else {
					System.out.println("회원가입 불가");
				}
				
				// level 2
				boolean isOkay = false;
				if(!name.isEmpty()) {
					if(phone.length() == 10 || phone.length() == 11) {
						if(age >= 14) {
							isOkay = true;
						}
					}
				}
				
				if(isOkay) {
					System.out.println("회원가입 성공");
				}else {
					System.out.println("회원가입 실패");
				}
				
				// level 3
				if((!name.isEmpty()) 
						&& (phone.length() == 10 || phone.length() == 11)
						&& (age >= 14)) {
					System.out.println("회원가입 성공");
				}else {
					System.out.println("회원가입 실패");
				}
				
				System.out.println("\n==============================================\n");
				
				// 값을 매칭하는 경우가 많을때,
				
				// 여러분들의 교육기간(단위:월)
				int month = 2;
				
				if(month == 0) {
					System.out.println("열심히 배우는 중");
				}else if (month == 1) {
					System.out.println("오라클 DB 마스터");
				}else if (month == 2) {
					System.out.println("자바 마스터");
				}else if (month == 3) {
					System.out.println("자바 스크립트 마스터");
				}else if (month == 4) {
					System.out.println("JSP 마스터");
				}else if (month == 5) {
					System.out.println("팀프로젝트");
				}else {
					System.out.println("수료!!");
				}
				
				// switch문
				switch(month) {
					case 0: 
						System.out.println("열심히 배우는 중");
						break;
					case 1:
						System.out.println("오라클 DB 마스터");
						break;
					case 2: 
						System.out.println("자바 마스터");
						break;
					case 3: 
						System.out.println("자바 스크립트 마스터");
						break;
					case 4: 
						System.out.println("JSP 마스터");
						break;
					case 5: 
						System.out.println("팀프로젝트");
						break;
					default:
						System.out.println("수료!!");
			}
				
				
				
	}
	
}

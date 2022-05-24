package game;

import java.util.Scanner;

import game.Game;


public class Start {
	
	public static boolean finish = false;
	
	Scanner sc  = new Scanner(System.in);
	
	String name;
	
	//사용자 이름 확정하기
	public String showName() {
		System.out.println("사용자의 이름은 무엇입니까?");
		name  = sc.nextLine();
		return name;
	}
	
	//캐릭터 소개하기
	public int showStart() {
		
			System.out.println("★캐릭터 소개★");
			System.out.println("1. 레이코 : 학교의 학생회장. 당당하고, 주변인들에게 덕망이 높다.");
			System.out.println("2. 하루카 : 연극부의 연극 부원. 미인으로, 인기가 많다.");
			System.out.println("3. 린 : 어렸을때부터 소꿉친구. 오랜 기간 알았고, 서로에 대해 이해도가 높다.");
			
			int start = Integer.parseInt(sc.nextLine());
			
			switch(start) {
			case 1: return 1; //원래 시작했던 값 showStart로 돌아감
			case 2: return 2;
			case 3: return 3;
			default : System.out.println("!존재하는 학생을 선택해주세요!");
			}return -1;
			
	}
	
	public void showEnd() {
		
			System.out.println("게임이 끝났습니다.");
			System.out.println("다시 하시겠습니까? (Y/N)");
			String answer = sc.nextLine();
			Game.finish = answer.equals("Y") || answer.equals("y")?false:true;
			
		}

	
		
	
		
		

	

}//class

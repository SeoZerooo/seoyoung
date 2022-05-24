package game;

import game.Start;

public class Game {
	
	public static boolean finish;

	public static void main(String[] args) {
		
		
		
		System.out.println("♥두근두근!! KH 학원!!♥");
		
		Start start = new Start();
		
		
		//캐릭터 객체 생성
		Reiko rei  = new Reiko();
		Haruka haru = new Haruka();
		Lyn lyn = new Lyn();
		
		String startName = start.showName();
		
		do {
		System.out.println("어서오세요! "+ startName +"! 학생들을 만나보시겠어요?");
		System.out.println(" ");

		int startNum = start.showStart();
		
			if (startNum == 1) {
				System.out.println("레이코를 선택하셨습니다. 게임이 시작됩니다.");
				System.out.println(" ");
				rei.showReiko();
				rei.showReiko02();
				rei.showReiko03();
				//레이코 1번 보여주기
			}else if (startNum == 2) {
				System.out.println("하루카를 선택하셨습니다. 게임이 시작됩니다.");
				System.out.println(" ");
				haru.showHaruka();
				haru.showHaruka02();
				haru.showHaruka03();
				//하루카 1번
			}else if (startNum == 3) {
				System.out.println("린을 선택하셨습니다. 게임이 시작됩니다.");
				System.out.println(" ");
				lyn.showLyn();
				lyn.showLyn02();
				lyn.showLyn03();
				//린 1번
			}else {
				System.out.println("캐릭터 선택 페이지로 돌아갑니다.");
				//사용자가 잘못고름
			}
			
			start.showEnd();
			
		}while(!finish);
			
			
		
		
			
		
	
		
	}

}//class

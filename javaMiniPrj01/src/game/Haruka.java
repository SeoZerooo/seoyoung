package game;

import java.util.Scanner;

public class Haruka {
	
	public static boolean finish = false;
	
	public Haruka() {
		
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void showHaruka() {
		do {
			System.out.println("<첫만남>");
			System.out.println("▶ 어머, 네가 그 전학생?? 제법 귀여운걸?");
			System.out.println("1. 아앗...고마워 너도 예뻐");
			System.out.println("2. 너는...하..루카?");
			System.out.println("3. 뭐하시는 분이세요?");
			
			int check = Integer.parseInt(sc.nextLine());
			
			switch (check) {
			case 1:
				System.out.println("▶ ㅎㅎ 빈말은 아니었으면 좋겠는걸");
				System.out.println("===========================");
				break;
			case 2:
				System.out.println("▶ 어디서 내 얘기를 들었을까나?");
				System.out.println("===========================");
				break;
			case 3:
				System.out.println("▶ 음...나를 모를수도 있구나?");
				System.out.println("===========================");
				break;
			default :
				System.out.println("▶ 왜 말을 못하고 있는걸까나~");
				System.out.println("===========================");
			}
			Haruka.finish = check==1 || check==2 ||check==3 ?true:false;
		}while (!finish);
		
	}
		
	public void showHaruka02() {
		do {
			System.out.println("<데이트>");
			System.out.println("▶ 여기 파르페 정말 맛있지 않아? 장식도 너무 귀여워");
			System.out.println("1. 같이 맛있는것도 먹고 너무 좋다.");
			System.out.println("2. 이런데 자주 다니는거야?");
			System.out.println("3. 나 단거 별로 안좋아하는데...");
			
			int check = Integer.parseInt(sc.nextLine());
			
			switch (check) {
			case 1:
				System.out.println("▶ 그러게 같이 오니까 너무 좋다.");
				System.out.println("===========================");
				break;
			case 2:
				System.out.println("▶ 나는 단거나 귀여운것들 좋아해서, 자주 찾아다녀.");
				System.out.println("===========================");
				break;
			case 3:
				System.out.println("▶ 미리 말을 좀 해줬으면 좋았잖니.");
				System.out.println("===========================");
				break;
			default :
				System.out.println("▶ 먹는데 집중하느라고 못들었어 미안. 다시 말해줄 수 있을까?");
				System.out.println("===========================");
			}
			Haruka.finish = check==1 || check==2 ||check==3 ?true:false;
		}while(!finish);
		
	}
		
		public void showHaruka03() {
			do {
				System.out.println("<축제>");
				System.out.println("▶ 너무 예뻐~! 꼭 좋아하는 사람이랑 오고싶었는데!");
				System.out.println("1. 나랑 같네. 나도 좋아하는 사람이랑 오고싶었어.");
				System.out.println("2. 그게 나여도 괜찮은거야..?");
				System.out.println("3. 엥 그런데 나를 데려왔어?");
				
				int check = Integer.parseInt(sc.nextLine());
				
				switch (check) {
				case 1:
					System.out.println("▶ 오늘 소원 성취하는 날인것 같네.");
					System.out.println("===========================");
					break;
				case 2:
					System.out.println("▶ 그럼~나는 좋은데 넌 아닌걸까?");
					System.out.println("===========================");
					break;
				case 3:
					System.out.println("▶ 됐다 먹을거나 사러 가보자구");
					System.out.println("===========================");
					break;
				default :
					System.out.println("▶ 사람이 많아서 못들었는데 뭐라고 했어?");
					System.out.println(" ");
				}
				Haruka.finish = check==1 || check==2 ||check==3 ?true:false;
			}while(!finish);
			
		}
	
}//class


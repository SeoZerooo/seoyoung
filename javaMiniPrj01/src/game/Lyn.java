package game;

import java.util.Scanner;

public class Lyn {
	
	public static boolean finish = false;
	
	public Lyn() {
		
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void showLyn() {
		do {
			System.out.println("<첫만남>");
			System.out.println("▶ 뭐야 너도 여기 다니는거야?");
			System.out.println("1. 응 네가 다닌다고 해서 오고싶었어.");
			System.out.println("2. 어, 너도 여기 다녀?");
			System.out.println("3. 또 너냐?");
			
			int check = Integer.parseInt(sc.nextLine());
			
			switch (check) {
			case 1:
				System.out.println("▶ ㅁ..뭐야 갑자기 그런 말을하고 됐고 집에 가자");
				System.out.println("===========================");
				break;
			case 2:
				System.out.println("▶ 이제껏 내가 다니는 학교도 몰랐던거야..?");
				System.out.println("===========================");
				break;
			case 3:
				System.out.println("▶ 뭔데 보자마자 시비를 걸지?");
				System.out.println("===========================");
				break;
			default :
				System.out.println("▶ 물어봤는데, 대답좀..?");
				System.out.println("===========================");
			}
			Lyn.finish = check==1 || check==2 ||check==3 ?true:false;
		}while(!finish);
		
	}
	
	public void showLyn02() {
		do {
			System.out.println("<데이트>");
			System.out.println("▶ 간식거리 좀 사왔어.그래서 너네 집에는 왜 부른건데?");
			System.out.println("1. 그야 데이트 하려고 불렀지. 같이 영화나 볼까?");
			System.out.println("2. 뭐야 한두번 와봐? 새삼스럽게 왜 그래");
			System.out.println("3. 내가 부르는데 이유가 있어야 되냐?");
			
			int check = Integer.parseInt(sc.nextLine());
			
			switch (check) {
			case 1:
				System.out.println("▶ 영화..나쁘지 않을것..같네 뭐 볼건데..?");
				System.out.println("===========================");
				break;
			case 2:
				System.out.println("▶ 아니..그런 의미가 아니잖아.");
				System.out.println("===========================");
				break;
			case 3:
				System.out.println("▶ 오라면 오고 가라면 가고 내가 네 종이냐?");
				System.out.println("===========================");
				break;
			default :
				System.out.println("▶ 저..언제까지 이렇게 서있어야돼..? 말이라도 해줄래..?");
				System.out.println("===========================");
			}
			Lyn.finish = check==1 || check==2 ||check==3 ?true:false;
		}while(!finish);
		
		
	}
	
	public void showLyn03() {
		do {
			System.out.println("<축제>");
			System.out.println("▶ 이야 이런데를 너랑 같이 올줄이야.");
			System.out.println("1. 왜? 제법 연인같아?");
			System.out.println("2. 역시 누구랑 함께 와야 재밋잖아.");
			System.out.println("3. 같이 오면 안될 곳이라도 왔냐?");
			
			int check = Integer.parseInt(sc.nextLine());
			
			switch (check) {
			case 1:
				System.out.println("▶ 내가..언제..연인같다고..까지 했어..");
				System.out.println("===========================");
				break;
			case 2:
				System.out.println("▶ 그래 너라도 있어서 다행이다.");
				System.out.println("===========================");
				break;
			case 3:
				System.out.println("▶ 진짜 최악이다.");
				System.out.println("===========================");
				break;
			default :
				System.out.println("▶ 왜 가만히 서있어! 뭐라고 말좀 해봐.");
				System.out.println("===========================");
			}
			Lyn.finish = check==1 || check==2 ||check==3 ?true:false;
		}while(!finish);
		
		
	}

}//class

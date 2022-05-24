package game;

import java.util.Scanner;


public class Reiko {
	
	public static boolean finish = false;
	
	public Reiko() {
		
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void showReiko() {
		
		do {
			System.out.println("<첫만남>");
			System.out.println("▶ 안녕, 난 이 학원의 학생회장 레이코라고해. 네가 새로 온 전학생이라고?");
			System.out.println("1. 응, 안녕 만나서 반갑다");
			System.out.println("2. 그러는 넌...학생회장이라고?");
			System.out.println("3. 니가 뭔데 신경꺼");
			
			int check = Integer.parseInt(sc.nextLine());
			
			switch (check) {
			case 1:
				System.out.println("▶ 그래, 나도 앞으로 잘 부탁해");
				System.out.println("===========================");
				break;
			case 2:
				System.out.println("▶ 응 맞아 학교를 좀 소개해줄까?");
				System.out.println("===========================");
				break;
			case 3:
				System.out.println("▶ 너..제법 성격이 나쁘구나?");
				System.out.println("===========================");
				break;
			default :
				System.out.println("▶ 흐음.. 무슨 말을 하려는거야? 다시 말해볼래?");
				System.out.println("===========================");
			}
			Reiko.finish = check==1 || check==2 ||check==3 ?true:false;
		}while (!finish);
			
		
	}
	
	public void showReiko02() {
		
		do {
			System.out.println("<데이트>");
			System.out.println("▶ 내가 너무 바빠서 미안. 학생회실이지만..이런데서 데이트하는것도 나쁘지 않지?");
			System.out.println("1. 너랑 함께라면 어디든 좋아.");
			System.out.println("2. 왜 이렇게 바쁜거야. 도와줄테니 끝내고 나가서 놀자");
			System.out.println("3. 학생회실이라니 진짜 끔찍하다.");
			
			int check = Integer.parseInt(sc.nextLine());
			
			switch (check) {
			case 1:
				System.out.println("▶ 하하 꽤나 낭만적인걸~");
				System.out.println("===========================");
				break;
			case 2:
				System.out.println("▶ 상냥하네, 그래 얼른 끝내볼까?");
				System.out.println("===========================");
				break;
			case 3:
				System.out.println("▶ 미안하지만 내가 학생회장이라서 말이야. 이런데라서 미안하게 됐네.");
				System.out.println("===========================");
				break;
			default :
				System.out.println("▶ 왜 말을 못하고 있어?");
				System.out.println("===========================");
			}
			Reiko.finish = check==1 || check==2 ||check==3 ?true:false;
		}while (!finish);
		
	}
	
	public void showReiko03() {
		do {
			System.out.println("<축제>");
			System.out.println("▶ 누군가와 놀러나온건 정말 오랜만이네.");
			System.out.println("1. 오늘 내가 정말 재밋게 해줄게.");
			System.out.println("2. 그래? 그간 학생회 일이 많았었나.");
			System.out.println("3. 좀 놀러 다니지 그랬어.");
			
			int check = Integer.parseInt(sc.nextLine());
			
			switch (check) {
			case 1:
				System.out.println("▶ 믿고 있을게.오늘 잊지못할 하루가 될 것 같아.");
				System.out.println("===========================");
				break;
			case 2:
				System.out.println("▶ 아마 그렇지 않을까? 그렇지만 너와 나와서 기뻐.");
				System.out.println("===========================");
				break;
			case 3:
				System.out.println("▶ 학생회일을 처리하느라 어쩔수 없었는걸. 앞으로도 계속 그럴것 같지만.");
				System.out.println("===========================");
				break;
			default :
				System.out.println("▶ 사람들이 많아서 잘 안들려. 뭐라고 했어?");
				System.out.println("===========================");
			}
			Reiko.finish = check==1 || check==2 ||check==3 ?true:false;
		}while (!finish);
		
		
	}
	


}

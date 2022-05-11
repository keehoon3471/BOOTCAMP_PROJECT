package MiniProject;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TeamDAO dao = new TeamDAO();
		int menu = 0;
		boolean flag= true;
		while(flag) {
			System.out.println("▣ What`s your favorite baseball team? ▣");
			System.out.println("1. 설문참여하기");
			System.out.println("2. 설문현황출력");
			System.out.println("3. 설문종료");
			System.out.print("▶ 메뉴 선택 : ");
			menu = in.nextInt(); 
			
			switch(menu) {
			case 1 :
				System.out.println("===================================");
				System.out.println("설문참여를 선택하셨습니다.");
				System.out.println("(유의사항)");
				System.out.println("① 선호팀의 번호를 입력하세요.");
				System.out.println("② 기타선택 시 팀명을 입력하세요.");
				System.out.println("===================================");
				ArrayList<TeamVO> ret1 = dao.showAll();
				
				for(TeamVO tmp : ret1) 
					System.out.println(tmp.view());
				
				System.out.printf("%d.\t기타(팀명입력)\n",dao.getCount()+1);
				System.out.print("▶ 당신의 선택은? : ");
				
				int tnum = in.nextInt(); in.nextLine();
				System.out.println("===================================");
				System.out.println(tnum+"번을 선택하셨습니다.");
				
				if(tnum!=(dao.getCount()+1)) 
					dao.updateVote(tnum);
				else {
					System.out.print("▶ 팀 이름을 입력 해주세요 : ");
					String qq = in.nextLine();
					dao.insertTeam(qq);
				}
				System.out.println("설문참여를 완료하셨습니다.");
				System.out.println("===================================");
				break;

			case 2 :
				System.out.println("===================================");
				System.out.println("설문현황출력을 선택하셨습니다.");
				System.out.println("===================================");
				ArrayList<TeamVO> ret2 = dao.showAll();
				
				for(TeamVO tmp2 : ret2) 
					System.out.println(tmp2);
				
				break;
			case 3: 
				System.out.println("설문이 종료되었습니다.");
				flag = false;
				break;
			}
		}
		in.close();
	}
}

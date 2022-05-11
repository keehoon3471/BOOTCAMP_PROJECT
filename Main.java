package MiniProject;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TeamDAO dao = new TeamDAO();
		int menu = 0;
		boolean flag= true;
		while(flag) {
			System.out.println("�� What`s your favorite baseball team? ��");
			System.out.println("1. ���������ϱ�");
			System.out.println("2. ������Ȳ���");
			System.out.println("3. ��������");
			System.out.print("�� �޴� ���� : ");
			menu = in.nextInt(); 
			
			switch(menu) {
			case 1 :
				System.out.println("===================================");
				System.out.println("���������� �����ϼ̽��ϴ�.");
				System.out.println("(���ǻ���)");
				System.out.println("�� ��ȣ���� ��ȣ�� �Է��ϼ���.");
				System.out.println("�� ��Ÿ���� �� ������ �Է��ϼ���.");
				System.out.println("===================================");
				ArrayList<TeamVO> ret1 = dao.showAll();
				
				for(TeamVO tmp : ret1) 
					System.out.println(tmp.view());
				
				System.out.printf("%d.\t��Ÿ(�����Է�)\n",dao.getCount()+1);
				System.out.print("�� ����� ������? : ");
				
				int tnum = in.nextInt(); in.nextLine();
				System.out.println("===================================");
				System.out.println(tnum+"���� �����ϼ̽��ϴ�.");
				
				if(tnum!=(dao.getCount()+1)) 
					dao.updateVote(tnum);
				else {
					System.out.print("�� �� �̸��� �Է� ���ּ��� : ");
					String qq = in.nextLine();
					dao.insertTeam(qq);
				}
				System.out.println("���������� �Ϸ��ϼ̽��ϴ�.");
				System.out.println("===================================");
				break;

			case 2 :
				System.out.println("===================================");
				System.out.println("������Ȳ����� �����ϼ̽��ϴ�.");
				System.out.println("===================================");
				ArrayList<TeamVO> ret2 = dao.showAll();
				
				for(TeamVO tmp2 : ret2) 
					System.out.println(tmp2);
				
				break;
			case 3: 
				System.out.println("������ ����Ǿ����ϴ�.");
				flag = false;
				break;
			}
		}
		in.close();
	}
}

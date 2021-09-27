package ex0927;

import java.util.ArrayList;
import java.util.Scanner;

public class ex01 {

	public static void main(String[] args) {
		   // ����ý��� (ȸ������, �α���, ȸ����������, ȸ����Ϻ���)
	      
	      Scanner sc = new Scanner(System.in);
	      MemberDAO dao = new MemberDAO();
	      
	      System.out.println("����ý��� ���α׷��� �����մϴ�");
	      while(true) {
	         System.out.print("1.ȸ������ 2.�α��� 3.ȸ���������� 4.ȸ����Ϻ��� 5.���� >> ");
	         int choice = sc.nextInt();
	         
	         if(choice == 1) {
	            System.out.println("--ȸ������--");
	            System.out.print("ID�Է� : ");
	            String id = sc.next();
	            System.out.print("PW�Է� : ");
	            String pw = sc.next();
	            System.out.print("NICK�Է� : ");
	            String nick = sc.next();
	            System.out.print("PHONE�Է� : ");
	            String phone = sc.next();
	            
	            MemberVO vo = new MemberVO(id, pw, nick, phone);
	            int cnt = dao.join(vo);
	            
	            if(cnt > 0) {
	               System.out.println("ȸ������ ����!");
	            }else {
	               System.out.println("ȸ������ ����...");
	            }
	            
	         }else if(choice == 2) {
	            
	            System.out.println("--�α���--");
	            System.out.print("ID�Է� : ");
	            String id = sc.next();
	            System.out.print("PW�Է� : ");
	            String pw = sc.next();
	            
	            MemberVO vo = new MemberVO(id, pw);
	            MemberVO info = dao.login(vo);
	            
	            if(info != null) {
	               System.out.println(info.getNick() + "�� ȯ���մϴ�!");
	            }else {
	               System.out.println("�α��� ����..");
	            }
	            
	         }else if(choice == 3) {
	            // id�� ��ġ�ϴ� �� ã�Ƽ� pw, nick, phone�� �Է��� ������ ���� 
	            System.out.println("--ȸ����������--");
	            System.out.print("ID�Է� : ");
	            String id = sc.next();
	            System.out.print("PW�Է� : ");
	            String pw = sc.next();
	            System.out.print("NICK�Է� : ");
	            String nick = sc.next();
	            System.out.print("PHONE�Է� : ");
	            String phone = sc.next();
	            
	            MemberVO vo = new MemberVO(id, pw, nick, phone);
	            int cnt = dao.update(vo);
	            
	            if(cnt > 0) {
	               System.out.println("ȸ���������� ����!");
	            }else {
	               System.out.println("ȸ���������� ����..");
	            }
	            
	         }else if(choice == 4) {
	            
	            System.out.println("--ȸ����Ϻ���--");
	             ArrayList<MemberVO> list = dao.selectAll();
	             
	            for(int i = 0; i < list.size(); i++) {
	               System.out.println(list.get(i));
	               // System.out.println(list.get(i).getId());
	               // ��ü �� ��ü�� ����� �� toString�޼ҵ� ���Ǵ� ��!
	               // toString�޼ҵ带 ���������� �ʴ´ٸ� Object�� ������ �ִ�
	               // toString�޼ҵ尡 ����!(�ּҰ��� ��µǰ� ����)
	               
	               // toString�޼ҵ带 �������ϰԵǸ� MemberVO�ȿ� �ִ�
	               // toString�޼ҵ尡 ����!(�� ���迡 ���� ��µ�!)
	               
	            }
	         }else if(choice == 5) {
	           //ȸ��Ż�� ��� (�޼ҵ��: delete)
	           //���̵��  ��й�ȣ�� �Է¹޾Ƽ�
	           //�ش��ϴ� ���̵�� ��й�ȣ�� ��ġ�ϴ� ����� ������ 
	           //�����ͺ��̽��κ��� ����!
	           
	           //1. ���̵�� ��й�ȣ �Է�
	        	 System.out.println("���̵� �Է� >>");
	        	 String id = sc.next();
	        	 System.out.println("��й�ȣ �Է� >>");
	        	 String pw = sc.next();
	           // 1-1.���̵�� ��й�ȣ�� �ϳ��� �ڷ����� �����ֱ�
	        	 MemberVo vo = new MemberVo(id,pw);
	        	 
	           //2. MemberDao�ȿ� delete��� �޼ҵ� ����
	        	 dao.delete(vo);
	           //3. ȸ��Ż�� �����ߴ��� �����ߴ��� ���� ���!	 
	        	 
	         }else if(choice == 6) {
	        	 
	        	// 11�� 29��~ 
	        	 
	         }
	      }


	}

}

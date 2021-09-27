package ex0927;

import java.util.ArrayList;
import java.util.Scanner;

public class ex01 {

	public static void main(String[] args) {
		   // 멤버시스템 (회원가입, 로그인, 회원정보수정, 회원목록보기)
	      
	      Scanner sc = new Scanner(System.in);
	      MemberDAO dao = new MemberDAO();
	      
	      System.out.println("멤버시스템 프로그램을 시작합니다");
	      while(true) {
	         System.out.print("1.회원가입 2.로그인 3.회원정보수정 4.회원목록보기 5.종료 >> ");
	         int choice = sc.nextInt();
	         
	         if(choice == 1) {
	            System.out.println("--회원가입--");
	            System.out.print("ID입력 : ");
	            String id = sc.next();
	            System.out.print("PW입력 : ");
	            String pw = sc.next();
	            System.out.print("NICK입력 : ");
	            String nick = sc.next();
	            System.out.print("PHONE입력 : ");
	            String phone = sc.next();
	            
	            MemberVO vo = new MemberVO(id, pw, nick, phone);
	            int cnt = dao.join(vo);
	            
	            if(cnt > 0) {
	               System.out.println("회원가입 성공!");
	            }else {
	               System.out.println("회원가입 실패...");
	            }
	            
	         }else if(choice == 2) {
	            
	            System.out.println("--로그인--");
	            System.out.print("ID입력 : ");
	            String id = sc.next();
	            System.out.print("PW입력 : ");
	            String pw = sc.next();
	            
	            MemberVO vo = new MemberVO(id, pw);
	            MemberVO info = dao.login(vo);
	            
	            if(info != null) {
	               System.out.println(info.getNick() + "님 환영합니다!");
	            }else {
	               System.out.println("로그인 실패..");
	            }
	            
	         }else if(choice == 3) {
	            // id와 일치하는 걸 찾아서 pw, nick, phone을 입력한 것으로 수정 
	            System.out.println("--회원정보수정--");
	            System.out.print("ID입력 : ");
	            String id = sc.next();
	            System.out.print("PW입력 : ");
	            String pw = sc.next();
	            System.out.print("NICK입력 : ");
	            String nick = sc.next();
	            System.out.print("PHONE입력 : ");
	            String phone = sc.next();
	            
	            MemberVO vo = new MemberVO(id, pw, nick, phone);
	            int cnt = dao.update(vo);
	            
	            if(cnt > 0) {
	               System.out.println("회원정보수정 성공!");
	            }else {
	               System.out.println("회원정보수정 실패..");
	            }
	            
	         }else if(choice == 4) {
	            
	            System.out.println("--회원목록보기--");
	             ArrayList<MemberVO> list = dao.selectAll();
	             
	            for(int i = 0; i < list.size(); i++) {
	               System.out.println(list.get(i));
	               // System.out.println(list.get(i).getId());
	               // 객체 그 자체를 출력할 때 toString메소드 사용되는 중!
	               // toString메소드를 재정의하지 않는다면 Object가 가지고 있는
	               // toString메소드가 사용됨!(주소값이 출력되게 설계)
	               
	               // toString메소드를 재정의하게되면 MemberVO안에 있는
	               // toString메소드가 사용됨!(내 설계에 따라 출력됨!)
	               
	            }
	         }else if(choice == 5) {
	           //회원탈퇴 기능 (메소드명: delete)
	           //아이디와  비밀번호를 입력받아서
	           //해당하는 아이디와 비밀번호가 일치하는 사용자 정보를 
	           //데이터베이스로부터 삭제!
	           
	           //1. 아이디와 비밀번호 입력
	        	 System.out.println("아이디 입력 >>");
	        	 String id = sc.next();
	        	 System.out.println("비밀번호 입력 >>");
	        	 String pw = sc.next();
	           // 1-1.아이디와 비밀번호를 하나의 자료형을 묶어주기
	        	 MemberVo vo = new MemberVo(id,pw);
	        	 
	           //2. MemberDao안에 delete라는 메소드 생성
	        	 dao.delete(vo);
	           //3. 회원탈퇴 성공했는지 실패했는지 여부 출력!	 
	        	 
	         }else if(choice == 6) {
	        	 
	        	// 11시 29분~ 
	        	 
	         }
	      }


	}

}

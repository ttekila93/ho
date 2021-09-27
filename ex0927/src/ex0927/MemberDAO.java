package ex0927;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

   // DAO --> DataBase Access Object
   //데이터베이스 접근을 관리하는 우리가 설계한 객체!
   // JDBC 연결 과정
   // 1) 드라이버 동적로딩
   // 2) Connection연결
   // 3) sql문 준비
   // 4) 전송
   // 5) 종료**
   
   
   
   
   private Connection conn;
   private PreparedStatement psmt;
   private ResultSet rs;

   private void getConn() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
         String db_id = "hr";
         String db_pw = "hr";
         conn = DriverManager.getConnection(db_url, db_id, db_pw);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }

   private void close() {
      try {
         if (rs != null) {
            rs.close();
         }
         if (psmt != null) {
            psmt.close();
         }
         if (conn != null) {
            conn.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public int join(MemberVO vo) {
      int cnt = 0;
      getConn();
      try {
         String sql = "insert into big_member values(?,?,?,?)";
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, vo.getId());
         psmt.setString(2, vo.getPw());
         psmt.setString(3, vo.getNick());
         psmt.setString(4, vo.getPhone());
         cnt = psmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }

      return cnt;
   }

   public MemberVO login(MemberVO vo) {
      MemberVO info = null;
      getConn();
      try {

         String sql = "select * from big_member where id = ? and pw = ?";
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, vo.getId());
         psmt.setString(2, vo.getPw());
         rs = psmt.executeQuery();
         if (rs.next()) {
            String id = rs.getString("id");
            String pw = rs.getString("pw");
            String nick = rs.getString("nick");
            String phone = rs.getString("phone");
            info = new MemberVO(id, pw, nick, phone);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }

      return info;
   }

   public int update(MemberVO vo) {
      int cnt = 0;
      getConn();
      try {
         String sql = "update big_member set pw = ?, nick = ?, phone = ? where id = ?";
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, vo.getPw());
         psmt.setString(2, vo.getNick());
         psmt.setString(3, vo.getPhone());
         psmt.setString(4, vo.getId());
         cnt = psmt.executeUpdate();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close();
      }

      return cnt;
   }

   public ArrayList<MemberVO> selectAll() {
      ArrayList<MemberVO> list = new ArrayList<MemberVO>();

      getConn();

      String sql = "select * from big_member";
      try {
         psmt = conn.prepareStatement(sql);
         rs = psmt.executeQuery();
         while (rs.next()) {
            String id = rs.getString("id");
            String pw = rs.getString("pw");
            String nick = rs.getString("nick");
            String phone = rs.getString("phone");
            MemberVO vo = new MemberVO(id, pw, nick, phone);
            list.add(vo);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close();
      }

      return list;
   }

}

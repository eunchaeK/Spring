package com.fastcampus.ch3;

import com.mysql.cj.protocol.Resultset;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.PreparedStatement;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class) // pom.xml에서 JUnit 4.12 or 그 이상으로 설정
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DBConnectionTest2Test {

    @Autowired DataSource ds;
//    @Autowired ApplicationContext ac;

    @Test
    public void insertUserTest() throws Exception{
        User user = new User("asdf", "1234", "홍길동", "123@naver.com", new Date(),"fb", new Date());
        deleteAll();    // insert 전 테이블 데이터 모두 삭제
        int rowCnt = insertUser(user);
        
        assertTrue(rowCnt==1);
    }

    @Test
    public void selectUserTest() throws Exception{
        deleteAll();    // insert 전 테이블 데이터 모두 삭제
        User user = new User("asdf", "1234", "홍길동", "123@naver.com", new Date(),"fb", new Date());
        insertUser(user);

        User user2 = selectUser("asdf");

        assertTrue(user2.getId().equals("asdf"));
    }

    @Test
    public void deleteUserTest()throws Exception{
        deleteAll();    // insert 전 테이블 데이터 모두 삭제
        int rowCnt = deleteUser("asdf");

        assertTrue(rowCnt==0);

        User user = new User("asdf", "1234", "홍길동", "123@naver.com", new Date(),"fb", new Date());
        rowCnt = insertUser(user);
        assertTrue(rowCnt==1);

        rowCnt = deleteUser(user.getId());
        assertTrue(rowCnt==1);

        assertTrue(selectUser(user.getId())==null);
    }

    @Test
    public void updateUserTest() throws Exception{
        deleteAll();    // insert 전 테이블 데이터 모두 삭제
        User user = new User("asdf", "1234", "홍길동", "123@naver.com", new Date(),"fb", new Date());
        int rowCnt = insertUser(user);
        assertTrue(rowCnt==1);
        assertTrue(selectUser(user.getId()).getId().equals("asdf"));

        user.setPwd("9876").setName("구르미").setEmail("cloud@naver.com").setSns("instagram").setBirth(new Date());
        rowCnt = updateUser(user);
        assertTrue(rowCnt==1);

    }

    // 매개변수로 받은 사용자 정보로 user_info 테이블을 update하는 메서드
    public int updateUser(User user) throws Exception{
        Connection conn = ds.getConnection();

        String sql = "UPDATE user_info SET pwd=?, name=?, email=?, birth=?, sns=? WHERE id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getPwd());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getEmail());
        pstmt.setDate(4, new java.sql.Date(user.getBirth().getTime()));
        pstmt.setString(5, user.getSns());
        pstmt.setString(6, user.getId());

        return pstmt.executeUpdate();
    }


    public int deleteUser(String id) throws Exception{
        Connection conn = ds.getConnection();

        String sql = "DELETE FROM user_info WHERE id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
//        int rowCnt = pstmt.executeUpdate();
//        return rowCnt;
        return pstmt.executeUpdate();
    }


    public User selectUser(String id) throws Exception{
        Connection conn = ds.getConnection();

        String sql = "SELECT * FROM user_info WHERE id=?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();    // select문

        if (rs.next()){
            User user = new User();
            user.setId(rs.getString(1));
            user.setPwd(rs.getString(2));
            user.setName(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setBirth(new Date(rs.getDate(5).getTime()));
            user.setSns(rs.getString(6));
            user.setReg_date(new Date(rs.getDate(7).getTime()));

            return user;
        }

        return null;
    }

    private void deleteAll() throws SQLException {
        Connection conn = ds.getConnection();

        String sql = "DELETE FROM user_info";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
    }


    // 사용자 정보를 user_info 테이블에 저장하는 메서드
    public int insertUser(User user) throws Exception{
        Connection conn = ds.getConnection();

//        insert into user_info
//        values ('asdf', '1234', '홍길동', '123@naver.com', '1990-02-12','fb', now());

        String sql = "INSERT INTO user_info VALUES (?, ?, ?, ?, ?, ?, now())";

        PreparedStatement pstmt = conn.prepareStatement(sql);   // Statement에 비해 성능향상. SQL Injection 공격, ? 사용
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getPwd());
        pstmt.setString(3, user.getName());
        pstmt.setString(4, user.getEmail());
        pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime())); // util.Date -> sql.Date
        pstmt.setString(6, user.getSns());

        int rowCnt = pstmt.executeUpdate(); // insert, delete, udpate <-> select : executeQuery

        return rowCnt;
    }


    @Test
    public void main() throws Exception{
//        ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
//        DataSource ds = ac.getBean(DataSource.class);

        Connection conn = ds.getConnection(); // 데이터베이스의 연결을 얻는다.

        System.out.println("conn = " + conn);
        assertTrue(conn!=null);     // 괄호 안 조건식이 true이면 테스트 성공, 아니면 실패.
    }
}
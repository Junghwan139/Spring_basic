package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberJdbcRepository {

    // datasource는 DB와 JDBC에서 사용하는 DB 연결 드라이버
    @Autowired
    private DataSource dataSource; // 이걸로 application.yml 주소를 통해서 db가 주입된거

    /*
    datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/board
    username: root
    password: 1234
    */

    public void save(Member member) throws SQLException {
        String sql = "insert into member(name, email, password) values(?, ?, ?)";

        // datasource객체 안에 db정보를 담고 있고, 해당 db정보를 통해 connection을 맺는다.
        Connection con = dataSource.getConnection();
        // con객체에 작성한 쿼리문을 세팅하여 ps객체에 할당
        // ps: db정보+쿼리문
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,member.getName());
        ps.setString(2,member.getEmail());
        ps.setString(3,member.getPassword());
        // insert 또는 update는 excuteUpdate 메서드 사용
        // select는 executeQuery 메서드 사용
        ps.executeUpdate();

    }

    public Member findById(Long id) throws SQLException {

        String sql = "select * from member where id =?";

        Connection con = dataSource.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1,id);


        ResultSet rs = ps.executeQuery();  //JDBC 반환 값은 resultset임 따라서 멤버객체로 바꿔 줘야함
        if (rs.next()){
            Member member = new Member();
            member.setId(rs.getLong("id"));
            member.setName(rs.getString("name"));
            member.setEmail(rs.getString("email"));
            member.setPassword(rs.getString("password"));
            return member;
        }
        return null;
    }



    public List<Member> findAll() throws SQLException {

        String sql = "select * from member";
        Connection con = dataSource.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Member> members = new ArrayList<>();


        while(rs.next()){

            Member member = new Member();

            member.setId(rs.getLong("id"));
            member.setName(rs.getString("name"));
            member.setEmail(rs.getString("email"));
            member.setPassword(rs.getString("password"));

            members.add(member);
        }


        return members;
    }




}

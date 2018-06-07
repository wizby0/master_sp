package com.multicampus.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.multicampus.biz.common.JDBCUtil;

@Repository
public class UserDAOJDBC {	
	// JDBC ���� ����
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	// SQL ��ɾ��
	private String USER_GET = "select * from blog_user where user_id=? and password=?";

	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);	
			stmt.setString(1, vo.getUserId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()){
				user = new UserVO();
				user.setUserId(rs.getString("USER_ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
}
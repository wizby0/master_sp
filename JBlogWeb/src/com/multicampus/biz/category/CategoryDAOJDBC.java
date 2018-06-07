package com.multicampus.biz.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.multicampus.biz.common.JDBCUtil;

@Repository
public class CategoryDAOJDBC {
	// JDBC 관련 변수
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	// SQL 명령어들
	private String CATEGORY_INSERT = "insert into category(blog_id, category_id, category_name, display_type, description, created_date, modified_date) values(?,(select nvl(max(category_id), 0) + 1 from category),?,?,?,sysdate,sysdate)";
	private String CATEGORY_LIST = "select * from category where blog_id=? order by created_date asc";

	public void insertCategory(CategoryVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CATEGORY_INSERT);
			stmt.setString(1, vo.getBlogId());
			stmt.setString(2, vo.getCategoryName());
			stmt.setString(3, vo.getDisplayType());
			stmt.setString(4, vo.getDescription());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public List<CategoryVO> getCategoryList(CategoryVO vo) {
		List<CategoryVO> categoryList = new ArrayList<CategoryVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CATEGORY_LIST);
			stmt.setString(1, vo.getBlogId());
			rs = stmt.executeQuery();
			while (rs.next()) {
				CategoryVO category = new CategoryVO();
				category.setBlogId(rs.getString("BLOG_ID"));
				category.setCategoryId(rs.getString("CATEGORY_ID"));
				category.setCategoryName(rs.getString("CATEGORY_NAME"));
				category.setDisplayType(rs.getString("DISPLAY_TYPE"));
				category.setDescription(rs.getString("DESCRIPTION"));
				category.setCreatedDate(rs.getDate("CREATED_DATE"));
				category.setModifiedDate(rs.getDate("MODIFIED_DATE"));
				categoryList.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return categoryList;
	}
}

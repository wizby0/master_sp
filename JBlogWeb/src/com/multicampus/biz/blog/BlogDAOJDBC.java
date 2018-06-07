package com.multicampus.biz.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.multicampus.biz.common.JDBCUtil;

@Repository
public class BlogDAOJDBC {
	// JDBC 관련 변수
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	// SQL 명령어들
	private String BLOG_INSERT = "insert into blog(blog_id, title, status, file_name, tag) values(?,?,?,?,?)";
	private String BLOG_GET = "select * from blog where blog_id=?";
	private String BLOG_UPDATE1 = "update blog set title=?, tag=?, file_name=? where blog_id=?";
	private String BLOG_UPDATE2 = "update blog set title=?, tag=? where blog_id=?";
	private String BLOG_DELETE_REQUEST = "update blog set status='삭제요청' where blog_id=?";
	private String BLOG_DELETE = "delete blog where blog_id=?";
	private String BLOG_LIST_TITLE = "select b.blog_id, b.status, b.file_name, b.title, b.tag, u.user_name from blog b, blog_user u where u.user_id=b.blog_id and b.title like '%'||?||'%' order by b.title";
	private String BLOG_LIST_TAG = "select b.blog_id, b.status, b.file_name, b.title, b.tag, u.user_name from blog b, blog_user u where u.user_id=b.blog_id and b.tag like '%'||?||'%' order by b.title";
	private String BLOG_LIST_BLOGGER = "select b.blog_id, b.status, b.file_name, b.title, b.tag, u.user_name from blog b, blog_user u where u.user_id=b.blog_id and u.user_name like ? order by b.title";

	public void insertBlog(BlogVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_INSERT);
			stmt.setString(1, vo.getBlogId());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getStatus());
			stmt.setString(4, vo.getFileName());
			stmt.setString(5, vo.getTag());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public void updateBlog(BlogVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			if(vo.getFileName() != null) {
				stmt = conn.prepareStatement(BLOG_UPDATE1);
				stmt.setString(1, vo.getTitle());
				stmt.setString(2, vo.getTag());
				stmt.setString(3, vo.getFileName());
				stmt.setString(4, vo.getBlogId());
			} else {
				stmt = conn.prepareStatement(BLOG_UPDATE2);
				stmt.setString(1, vo.getTitle());
				stmt.setString(2, vo.getTag());
				stmt.setString(3, vo.getBlogId());
			}
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public void requestDeleteBlog(BlogVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_DELETE_REQUEST);
			stmt.setString(1, vo.getBlogId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public void deleteBlog(BlogVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_DELETE);
			stmt.setString(1, vo.getBlogId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public BlogVO getBlog(BlogVO vo) {
		BlogVO blog = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_GET);
			stmt.setString(1, vo.getBlogId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				blog = new BlogVO();
				blog.setBlogId(rs.getString("BLOG_ID"));
				blog.setTitle(rs.getString("TITLE"));
				blog.setFileName(rs.getString("FILE_NAME"));
				blog.setStatus(rs.getString("STATUS"));
				blog.setTag(rs.getString("TAG"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return blog;
	}

	public List<BlogVO> getBlogList(BlogVO vo) {
		List<BlogVO> blogList = new ArrayList<BlogVO>();
		try {
			conn = JDBCUtil.getConnection();
			if (vo.getSearchCondition().equals("TITLE")) {
				stmt = conn.prepareStatement(BLOG_LIST_TITLE);
			} else if (vo.getSearchCondition().equals("TAG")) {
				stmt = conn.prepareStatement(BLOG_LIST_TAG);
			} else if (vo.getSearchCondition().equals("BLOGGER")) {
				stmt = conn.prepareStatement(BLOG_LIST_BLOGGER);
			}
			stmt.setString(1, vo.getSearchKeyword());
			rs = stmt.executeQuery();
			while (rs.next()) {
				BlogVO blog = new BlogVO();
				blog.setBlogId(rs.getString("BLOG_ID"));
				blog.setTitle(rs.getString("TITLE"));
				blog.setFileName(rs.getString("FILE_NAME"));
				blog.setStatus(rs.getString("STATUS"));
				blog.setTag(rs.getString("TAG"));
				blog.setUserName(rs.getString("USER_NAME"));
				blogList.add(blog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return blogList;
	}
}

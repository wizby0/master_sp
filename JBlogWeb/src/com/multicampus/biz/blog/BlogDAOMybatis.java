package com.multicampus.biz.blog;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBlog(BlogVO vo) {
		mybatis.insert("Blog.insertBlog", vo);
	}

	public void updateBlog(BlogVO vo) {
		mybatis.update("Blog.updateBlog", vo);
	}

	public void requestDeleteBlog(BlogVO vo) {
		mybatis.update("Blog.deleteBlogRequest", vo);
	}

	public void deleteBlog(BlogVO vo) {
		mybatis.update("Blog.deleteBlog", vo);
	}

	public BlogVO getBlog(BlogVO vo) {
		return (BlogVO) mybatis.selectOne("Blog.getBlog", vo);
	}

	public List<BlogVO> getBlogList(BlogVO vo) {
		return (List<BlogVO>) mybatis.selectList("Blog.getBlogList", vo);
	}
}

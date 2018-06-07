package com.multicampus.biz.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogDAOMybatis blogDAO;

	public void insertBlog(BlogVO vo) {
		blogDAO.insertBlog(vo);
	}

	public void updateBlog(BlogVO vo) {
		blogDAO.updateBlog(vo);
	}

	public void requestDeleteBlog(BlogVO vo) {
		blogDAO.requestDeleteBlog(vo);
	}

	public void deleteBlog(BlogVO vo) {
		blogDAO.deleteBlog(vo);
	}

	public BlogVO getBlog(BlogVO vo) {
		return blogDAO.getBlog(vo);
	}

	public List<BlogVO> getBlogList(BlogVO vo) {
		return blogDAO.getBlogList(vo);
	}
}

package com.multicampus.biz.blog;

import java.util.List;

public interface BlogService {
	
	public void insertBlog(BlogVO vo);
	
	public void updateBlog(BlogVO vo);
	
	public void requestDeleteBlog(BlogVO vo);
	
	public void deleteBlog(BlogVO vo);
	
	public BlogVO getBlog(BlogVO vo);
	
	public List<BlogVO> getBlogList(BlogVO vo);
}

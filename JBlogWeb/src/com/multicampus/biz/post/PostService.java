package com.multicampus.biz.post;

import java.util.List;

public interface PostService {
	public void insertPost(PostVO vo);

	public void updatePost(PostVO vo);

	public void deletePost(PostVO vo);

	public void deletePostList(PostVO vo); 
	
	public PostVO getPost(PostVO vo);

	public List<PostVO> getPostList(PostVO vo);

}

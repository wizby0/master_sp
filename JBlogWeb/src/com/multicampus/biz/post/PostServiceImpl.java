package com.multicampus.biz.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostDAOMybatis postDAO;

	public void insertPost(PostVO vo) {
		postDAO.insertPost(vo);
	}

	public void updatePost(PostVO vo) {
		postDAO.updatePost(vo);
	}

	public void deletePost(PostVO vo) {
		postDAO.deletePost(vo);
	}
	
	public void deletePostList(PostVO vo) {
		postDAO.deletePostList(vo);
	}

	public PostVO getPost(PostVO vo) {
		return postDAO.getPost(vo);
	}
	
	public List<PostVO> getPostList(PostVO vo) {
		return postDAO.getPostList(vo);
	}

}

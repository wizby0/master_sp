package com.multicampus.biz.post;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertPost(PostVO vo) {
		mybatis.insert("Post.insertPost", vo);
	}

	public void updatePost(PostVO vo) {
		mybatis.update("Post.updatePost", vo);
	}
	
	public void deletePost(PostVO vo) {
		mybatis.delete("Post.deletePost", vo);
	}
	
	public void deletePostList(PostVO vo) {
		mybatis.delete("Post.deletePostList", vo);
	}
	
	public PostVO getPost(PostVO vo) {
		return (PostVO) mybatis.selectOne("Post.getPost", vo);
	}
	
	public List<PostVO> getPostList(PostVO vo) {
		return (List<PostVO>) mybatis.selectList("Post.getPostList", vo);
	}

}

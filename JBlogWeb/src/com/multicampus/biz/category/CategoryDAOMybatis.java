package com.multicampus.biz.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertCategory(CategoryVO vo) {
		mybatis.insert("Category.insertCategory", vo);
	}

	public List<CategoryVO> getCategoryList(CategoryVO vo) {
		return (List<CategoryVO>) mybatis.selectList("Category.getCategoryList", vo);
	}
}







package com.multicampus.biz.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multicampus.biz.post.PostDAOMybatis;
import com.multicampus.biz.post.PostVO;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDAOMybatis categoryDAO;

	public void insertCategory(CategoryVO vo) {
		categoryDAO.insertCategory(vo);
	}

	public List<CategoryVO> getCategoryList(CategoryVO vo) {
		return categoryDAO.getCategoryList(vo);
	}

}














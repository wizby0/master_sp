package com.multicampus.biz.category;

import java.util.List;

public interface CategoryService {

	public void insertCategory(CategoryVO vo);

	public List<CategoryVO> getCategoryList(CategoryVO vo);

}

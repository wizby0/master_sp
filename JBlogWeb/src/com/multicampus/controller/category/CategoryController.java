package com.multicampus.controller.category;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.category.CategoryService;
import com.multicampus.biz.category.CategoryVO;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/insertCategory.do")
	public String insertCategory(CategoryVO categoryVO) {
		categoryService.insertCategory(categoryVO);
		return "getCategoryList.do";
	}

	@RequestMapping("/getCategoryList.do")
	public String getCategoryList(CategoryVO categoryVO, HttpSession session, Model model) {
		categoryVO.setBlogId((String) session.getAttribute("userId"));
		List<CategoryVO> categoryList = categoryService.getCategoryList(categoryVO);
		model.addAttribute("categoryList", categoryList);
		return "blogadmin_category.jsp";
	}

}

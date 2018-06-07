package com.multicampus.controller.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.category.CategoryService;
import com.multicampus.biz.category.CategoryVO;
import com.multicampus.biz.post.PostService;
import com.multicampus.biz.post.PostVO;

@Controller
public class PostController {
	@Autowired
	PostService postService;
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/insertPostView.do")
	public String insertPostView(CategoryVO categoryVO, Model model) {
		List<CategoryVO> categoryList = categoryService.getCategoryList(categoryVO);
		model.addAttribute("categoryList", categoryList);
		return "blogadmin_post.jsp";
	}

	@RequestMapping("/insertPost.do")
	public String insertPost(PostVO postVO) {
		postService.insertPost(postVO);
		return "redirect:blogMain.do";
	}

	@RequestMapping("/updatePost.do")
	public String updatePost(PostVO postVO) {
		postService.updatePost(postVO);
		return "blogMain.do";
	}

	@RequestMapping("/deletePost.do")
	public String deletePost(PostVO postVO) {
		postService.deletePost(postVO);
		return "blogMain.do";
	}

	@RequestMapping("/getPost.do")
	public String getPost(PostVO postVO, CategoryVO categoryVO, Model model) {
		// Category 정보 조회
		List<CategoryVO> categoryList = categoryService.getCategoryList(categoryVO);
		model.addAttribute("categoryList", categoryList);
		
		// Post 정보 조회
		PostVO post = postService.getPost(postVO);
		model.addAttribute("post", post);
		return "blogadmin_post.jsp";
	}
}

package com.multicampus.controller.blog;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.multicampus.biz.blog.BlogService;
import com.multicampus.biz.blog.BlogVO;
import com.multicampus.biz.category.CategoryService;
import com.multicampus.biz.category.CategoryVO;
import com.multicampus.biz.post.PostService;
import com.multicampus.biz.post.PostVO;

@Controller
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PostService postService;

	@RequestMapping("/insertBlog.do")
	public String insertBlog(BlogVO blogVO, CategoryVO categoryVO, HttpSession session) {
		blogVO.setBlogId((String) session.getAttribute("userId"));
		blogVO.setStatus("운영");
		blogVO.setTag("NO Tags");
		blogVO.setFileName("j2eelogo.jpg");
		blogService.insertBlog(blogVO);
		session.setAttribute("blog", blogVO);

		categoryVO.setBlogId((String) session.getAttribute("userId"));
		categoryVO.setCategoryName("미분류");
		categoryVO.setDisplayType("글제목");
		categoryVO.setDescription("기본 카테고리입니다...");
		categoryService.insertCategory(categoryVO);
		
		return "index.jsp";
	}

	@RequestMapping("/updateBlog.do")
	public String updateBlog(BlogVO blogVO, HttpSession session) throws Exception {
		blogService.updateBlog(blogVO);
		session.setAttribute("blog", blogVO);
		return "getBlog.do";
	}

	@RequestMapping("/deleteBlog.do")
	public String deleteBlog(BlogVO blogVO) {
		blogService.deleteBlog(blogVO);		
		return "getBlogList.do";
	}

	@RequestMapping("/getBlog.do")
	public String getBlog(BlogVO vo, Model model) {
		BlogVO blog = blogService.getBlog(vo);
		model.addAttribute("blog", blog);
		return "blogadmin_detail.jsp";
	}

	@RequestMapping("/getBlogList.do")
	public String getBlogList(BlogVO vo, Model model) {
		if (vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		List<BlogVO> blogList = blogService.getBlogList(vo);		
		model.addAttribute("blogList", blogList);
		return "index.jsp";
	}

	@RequestMapping("/requestBlogDelete.do")
	public String requestBlogDelete(BlogVO vo) {
		blogService.requestDeleteBlog(vo);
		return "index.jsp";
	}

	@RequestMapping("/blogMain.do")
	public String blogMain(BlogVO blogVO, PostVO postVO, CategoryVO categoryVO, HttpSession session, Model model) {		
		if(blogVO.getBlogId() != null) {
			BlogVO blog = blogService.getBlog(blogVO);
			session.setAttribute("blog", blog);

			categoryVO.setBlogId(blogVO.getBlogId());
			postVO.setBlogId(blogVO.getBlogId());
		} else {
			categoryVO.setBlogId((String) session.getAttribute("userId"));
			postVO.setBlogId((String) session.getAttribute("userId"));
		}
		List<CategoryVO> categoryList = categoryService.getCategoryList(categoryVO);
		model.addAttribute("categoryList", categoryList);
		
		List<PostVO> postList = postService.getPostList(postVO);
		model.addAttribute("postList", postList);
		return "blogmain.jsp";
	}
}

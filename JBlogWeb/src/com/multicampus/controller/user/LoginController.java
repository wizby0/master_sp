package com.multicampus.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.blog.BlogService;
import com.multicampus.biz.blog.BlogVO;
import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;

	@RequestMapping("/login.do")
	public String login(UserVO userVo, BlogVO blogVo, HttpSession session) {
		UserVO user = userService.getUser(userVo);
		if (user != null) {
			// 로그인 성공 시, 세션에 user 정보 저장
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userRole", user.getRole());
			
			// 로그인 성공한 사용자가 블로그를 소유했다면, 사용자의 블로그 정보도 세션에 저장
			blogVo.setBlogId(user.getUserId());
			BlogVO blog = blogService.getBlog(blogVo);
			if (blog != null) {
				session.setAttribute("blog", blog);
			}
		}
		return "index.jsp";
	}
}
